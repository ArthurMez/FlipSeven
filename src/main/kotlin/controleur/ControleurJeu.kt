package iut.info1.flip7.flip7.controleur

import iut.info1.flip7.flip7.vue.DeroulementPartieVue
import iut.info1.flip7.flip7.modele.Flip7Manager

class ControleurJeu(private val vue: DeroulementPartieVue, private val modele: Flip7Manager) {

    init {
        // C'est ici qu'on "branche" les actions sur les boutons de la vue

        vue.btnTirer.setOnAction {
            val carteTiree = modele.partieEnCours?.joueurCourantPiocheUneCarte()

            if (carteTiree != null) {
                val coordonnees = utilitaires.OutilsAffichageCartes().obtenirCoordonneesCarte(carteTiree)
                vue.afficherCarteTiree(coordonnees.first, coordonnees.second)

                println("Carte piochée : $carteTiree")

                // 3. TODO : Mettre à jour le score du joueur à l'écran
            }
        }

        vue.btnStop.setOnAction {
            modele.partieEnCours?.joueurCourantDitStop()
            println("Action : Fin du tour")
        }
    }

    private fun actionTirer() {
        // Pour le moment, on met juste un texte dans la console pour tester
        println("Le joueur a cliqué sur le bouton Tirer !")

        // Plus tard, on fera :
        // 1. Demander au modèle de tirer une carte
        // 2. Dire à la vue d'afficher cette nouvelle carte
    }

    private fun actionStop() {
        println("Le joueur a décidé de s'arrêter !")
        // Logique pour passer au joueur suivant
    }
}