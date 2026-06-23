package iut.info1.flip7.flip7

import iut.info1.flip7.Flip7
import iut.info1.flip7.Joueur
import iut.info1.flip7.cartes.*
import iut.info1.flip7.flip7.controleur.ControleurAjouterJoueur
import iut.info1.flip7.flip7.controleur.ControleurSupprimerJoueur
import iut.info1.flip7.flip7.modele.ModeleInitialisation
import iut.info1.flip7.flip7.vue.InitialisationVue
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage


class Initialisation: Application(){

    override fun start(primaryStage: Stage) {
        val modele = ModeleInitialisation()
        val vue = InitialisationVue()

        val controleurAjouter = ControleurAjouterJoueur(modele, vue)
        val controleurSupprimer = ControleurSupprimerJoueur(modele, vue)

        vue.fixeControleurBoutonAjouter(controleurAjouter)
        vue.fixeControleurBoutonSupprimer(controleurSupprimer)

        val scene = Scene(vue, 600.0, 400.0)
        primaryStage.title="Initialisation"
        primaryStage.scene=scene
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    println("Hello")
    val nbJoueurs=3
    val pioche : List<Carte> = listOf(
        CarteNum(0),
        CarteNum(1),
        CarteNum(2), CarteNum(2),
        CarteNum(3), CarteNum(3), CarteNum(3),
        CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4),
        CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5),
        CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6),
        CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7),
        CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8),
        CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9),
        CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10),
        CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11),
        CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12),
        CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10),
        CarteBonusMultiplie(),
        Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(),
        Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(),
        CarteStop(), CarteStop(), CarteStop()
    )
    val jeu = Flip7(nbJoueurs, listOf(Joueur("Bob"), Joueur("Boby"), Joueur("Bobo")), pioche)

    Application.launch(Initialisation::class.java)
}


