import iut.info1.flip7.flip7.controleur.ControleurJeu
import iut.info1.flip7.flip7.modele.Flip7Manager
import iut.info1.flip7.flip7.vue.DeroulementPartieVue
import iut.info1.flip7.flip7.vue.MenuPrincipalVue
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage


class Flip7Main: Application() {

    override fun start(primaryStage: Stage) {
        // sans effet pour l'instant :
        //javafx.scene.text.Font.loadFont(javaClass.getResourceAsStream("/Polices/LeckerliOne-Regular.ttf"), 20.0)
        //javafx.scene.text.Font.loadFont(javaClass.getResourceAsStream("/Polices/Inter-VariableFont_slnt,wght.ttf"), 20.0)

        val modele = Flip7Manager()
        primaryStage.title="Flip7"
        val vuePrincipale = DeroulementPartieVue()

        val controleur = ControleurJeu(vuePrincipale,modele)

        val scene = Scene(vuePrincipale, 1280.0, 720.0)
        primaryStage.scene=scene
        primaryStage.show()

    }
}


fun main() {
    Application.launch(Flip7Main::class.java)
}