package iut.info1.flip7.flip7.controleur

import iut.info1.flip7.flip7.vue.DeroulementPartieVue
import iut.info1.flip7.flip7.modele.Flip7Manager

class ControleurJeu(private val vue: DeroulementPartieVue, private val modele: Flip7Manager) {

    init {
        // C'est ici qu'on "branche" les actions sur les boutons de la vue

        vue.btnTirer.setOnAction {
            // On demande au modèle d'agir sur la partie
            modele.partieEnCours?.joueurCourantPiocheUneCarte()
            println("Action : Tirer une carte")

            // Plus tard, on appellera une méthode ici pour mettre à jour la vue avec la nouvelle carte
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