package iut.info1.flip7.flip7.controleur

import iut.info1.flip7.cartes.Carte
import iut.info1.flip7.etats.EtatJoueur
import iut.info1.flip7.etats.EtatPartie
import iut.info1.flip7.flip7.vue.DeroulementPartieVue
import iut.info1.flip7.flip7.modele.Flip7Manager

class ControleurJeu(private val vue: DeroulementPartieVue, private val modele: Flip7Manager) {

    private var carteSpecialeEnAttente: Carte? = null

    init {
        vue.btnTirer.setOnAction {
            actionTirer()
        }

        vue.btnStop.setOnAction {
            actionStop()
        }
        for (i in 0 until 4) {
            vue.fixeActionSurCaseJoueur(i) {
                selectionnerCible(i)
            }
        }
    }

    private fun actionTirer() {

        val indexActuel = modele.partieEnCours?.joueurCourant
        val carteTiree = modele.partieEnCours?.joueurCourantPiocheUneCarte()
        if (carteTiree != null && indexActuel != null) {
            val coordonnees = utilitaires.OutilsAffichageCartes().obtenirCoordonneesCarte(carteTiree)
            vue.afficherCarteTiree(coordonnees.first, coordonnees.second)
            vue.ajouterCarteAuJoueur(indexActuel, coordonnees.first, coordonnees.second)
            if (modele.partieEnCours?.etatJoueur[indexActuel]== EtatJoueur.PERDU){
                vue.joueurEliminé(indexActuel)
            }
            if (modele.partieEnCours?.etatPartie == EtatPartie.ATTENTE_CIBLE_STOP || modele.partieEnCours?.etatPartie == EtatPartie.ATTENTE_CIBLE_3SUITE) {

                carteSpecialeEnAttente = carteTiree

            }

        }
        verifierEtatGlobal()
    }
    private fun selectionnerCible(indexCible: Int) {
        val partie = modele.partieEnCours ?: return
        val carte = carteSpecialeEnAttente ?: return
        val etatActuel = partie.etatPartie

        // On vérifie si le jeu attendait effectivement une cible
        if (etatActuel == EtatPartie.ATTENTE_CIBLE_STOP) {
            // 1. On applique l'effet STOP sur la cible dans le modèle
            partie.joueurCourantCibleStop(carte,indexCible)

            // 2. On met à jour visuellement la vue (par exemple griser la cible)
            vue.joueurStop(indexCible)



        } else if (etatActuel == EtatPartie.ATTENTE_CIBLE_3SUITE) { // Adapte si le nom est ATTENTE_CIBLE_CIBLE3SUITE
            // 1. On applique l'effet FLIP THREE sur la cible
            partie.joueurCourantCible3aLaSuite(carte, indexCible)

            // 2. On désactive le mode ciblage

        }
        verifierEtatGlobal()
    }
    private fun actionStop() {
        val indexActuel = modele.partieEnCours?.joueurCourant
        modele.partieEnCours?.joueurCourantDitStop()
        if (indexActuel != null){
            vue.joueurStop(indexActuel)
        }
        verifierEtatGlobal()
    }
    private fun verifierEtatGlobal() {
        val partie = modele.partieEnCours ?: return
        // 2. Vérification de la fin de manche ou de partie
        when (partie.etatPartie) {

            EtatPartie.MANCHE_TERMINEE -> {
                println("Manche terminée ! Lancement du calcul des scores...")

                // 1. On donne l'ordre au modèle de calculer les points de la manche.
                // Cette méthode ne doit être appelée QUE lorsque l'état est MANCHE_TERMINEE.
                val scoresDeLaManche = partie.scoreManche()

                // 2. On récupère les scores globaux (qui viennent d'être additionnés en interne par la librairie)
                val scoresTotaux = partie.score

                // 3. On transmet ces scores globaux à la Vue pour actualiser l'interface
                // (Remplace partie.nbJoueurs par la propriété exacte qui donne la taille de la liste si besoin)
                for (i in 0 until partie.nbJoueurs) {
                    val scoreTotal = scoresTotaux[i] ?: 0
                    vue.mettreAJourScore(i, scoreTotal)
                    println("Le joueur $i a remporté ${scoresDeLaManche[i]} points à cette manche. Score global : $scoreTotal")
                }

                // 4. L'appel à scoreManche() a automatiquement basculé l'état du jeu.
                // Il faut le revérifier pour décider de la suite des événements :
                if (partie.etatPartie == EtatPartie.PARTIE_TERMINEE) {
                    println("La limite de points a été franchie. Fin de la partie !")
                    // TODO: Ordonner à la vue de basculer sur l'écran des résultats finaux
                } else {
                    println("Mise en place de la manche suivante...")
                    partie.nouvelleManche() // Permet de réinitialiser la pioche et les mains dans le modèle

                    // On nettoie la table de jeu visuellement
                    // TODO: Créer une variable pour compter les manches si vous souhaitez l'afficher
                    vue.preparerNouvelleManche(2)
                }
            }
            EtatPartie.PARTIE_TERMINEE -> {
                println("Un joueur a atteint les 200 points. Fin de la partie !")
                // Ici, tu pourras plus tard afficher un écran de victoire
            }
            else -> {
                // L'état est normal (NOUVELLE_MANCHE ou en cours), on ne fait rien de spécial
            }
        }
    }
}