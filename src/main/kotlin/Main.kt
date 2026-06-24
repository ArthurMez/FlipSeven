import iut.info1.flip7.flip7.controleur.ControleurAjouterJoueur
import iut.info1.flip7.flip7.controleur.ControleurSupprimerJoueur
import iut.info1.flip7.flip7.modele.ModeleInitialisation
import iut.info1.flip7.flip7.vue.InitialisationVue
import iut.info1.flip7.flip7.vue.MenuPrincipalVue
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage


class Flip7Main: Application() {

    override fun start(primaryStage: Stage) {
        // sans effet pour l'instant :
        //javafx.scene.text.Font.loadFont(javaClass.getResourceAsStream("/Polices/LeckerliOne-Regular.ttf"), 20.0)
        //javafx.scene.text.Font.loadFont(javaClass.getResourceAsStream("/Polices/Inter-VariableFont_slnt,wght.ttf"), 20.0)

        val modele = ModeleInitialisation()
        val vue = InitialisationVue()

        val controleurAjouter = ControleurAjouterJoueur(modele, vue)
        val controleurSupprimer = ControleurSupprimerJoueur(modele, vue)

        vue.fixeControleurBoutonAjouter(controleurAjouter)
        vue.fixeControleurBoutonSupprimer(controleurSupprimer)

        val scene = Scene(vue, 1280.0, 720.0)
        primaryStage.title="Initialisation"
        primaryStage.scene=scene
        primaryStage.show()

    }
}


fun main() {
    Application.launch(Flip7Main::class.java)
}