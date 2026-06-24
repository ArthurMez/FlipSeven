package iut.info1.flip7.flip7.controleur

import Flip7Main
import controleur.ControleurFinDePartie
import iut.info1.flip7.cartes.Carte
import iut.info1.flip7.etats.EtatJoueur
import iut.info1.flip7.etats.EtatPartie
import iut.info1.flip7.flip7.vue.DeroulementPartieVue
import iut.info1.flip7.flip7.modele.Flip7Manager
import iut.info1.flip7.flip7.vue.InitialisationVue
import javafx.application.Application
import vue.FinPartieVue

class ControleurJeu(private val vue: DeroulementPartieVue, private val modele: Flip7Manager, private val application: Flip7Main) {

    private var carteSpecialeEnAttente: Carte? = null
    var manche : Int = 1
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
        val joueurs = modele.partieEnCours?.joueurs
        if (joueurs != null) {
            for(i in 0 until joueurs.size) {
                vue.initialisationNomJoueur(i, joueurs[i].donneNom())
            }
        }

    }

    private fun actionTirer() {

        val indexActuel = modele.partieEnCours?.joueurCourant
        val carteTiree = modele.partieEnCours?.joueurCourantPiocheUneCarte()
        if (carteTiree != null && indexActuel != null) {
            val coordonnees = utilitaires.OutilsAffichageCartes().obtenirCoordonneesCarte(carteTiree)
            vue.afficherCarteTiree(coordonnees.first, coordonnees.second)
            val mainDuJoueur = modele.partieEnCours?.main[indexActuel]
            if (mainDuJoueur != null) {
                vue.rafraichirMainJoueur(indexActuel, mainDuJoueur)
            }
            if (modele.partieEnCours?.etatJoueur[indexActuel]== EtatJoueur.PERDU){
                vue.joueurElimine(indexActuel)
            }
            if (modele.partieEnCours?.etatPartie == EtatPartie.ATTENTE_CIBLE_STOP || modele.partieEnCours?.etatPartie == EtatPartie.ATTENTE_CIBLE_3SUITE) {

                carteSpecialeEnAttente = carteTiree

            }

        }
        verifierEtatGlobal()
    }
    private fun selectionnerCible(indexCible: Int) {
        val indexActuel = modele.partieEnCours?.joueurCourant
        val partie = modele.partieEnCours ?: return
        val carte = carteSpecialeEnAttente ?: return
        val etatActuel = partie.etatPartie


        if (etatActuel == EtatPartie.ATTENTE_CIBLE_STOP) {
            partie.joueurCourantCibleStop(carte,indexCible)
            vue.joueurStop(indexCible)
        } else if (etatActuel == EtatPartie.ATTENTE_CIBLE_3SUITE) {
            // 1. Exécution de l'action dans le modèle
            partie.joueurCourantCible3aLaSuite(carte, indexCible)

            // 2. Rafraîchissement des mains impactées
            val mainJoueurCourant = partie.main[indexActuel] ?: emptyList()
            if (indexActuel != null) {
                    vue.rafraichirMainJoueur(indexActuel, mainJoueurCourant)
                }
            val mainCible = partie.main[indexCible] ?: emptyList()
            vue.rafraichirMainJoueur(indexCible, mainCible)
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
                    val vueFinDePartie = FinPartieVue(partie)
                    ControleurFinDePartie(vueFinDePartie, application)
                    application.changerVue(vueFinDePartie)
                } else {
                    println("Mise en place de la manche suivante...")
                    partie.nouvelleManche() // Permet de réinitialiser la pioche et les mains dans le modèle

                    manche += 1
                    vue.preparerNouvelleManche(manche)
                }
            }
            EtatPartie.PARTIE_TERMINEE -> {
                println("Un joueur a atteint les 200 points. Fin de la partie !")
                val vueFinDePartie = FinPartieVue(partie)
                ControleurFinDePartie(vueFinDePartie, application)
                application.changerVue(vueFinDePartie)
                // Ici, tu pourras plus tard afficher un écran de victoire
            }
            else -> {
                // L'état est normal (NOUVELLE_MANCHE ou en cours), on ne fait rien de spécial
            }
        }
    }
}