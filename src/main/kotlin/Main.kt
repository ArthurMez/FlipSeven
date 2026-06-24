import iut.info1.flip7.flip7.vue.MenuPrincipalVue
import javafx.application.Application
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import iut.info1.flip7.flip7.controleur.ControleurMenu


class Flip7Main: Application() {

    private lateinit var scene: Scene

    override fun start(primaryStage: Stage) {

        javafx.scene.text.Font.loadFont(javaClass.getResourceAsStream("/polices/LeckerliOne-Regular.ttf"), 20.0)
        javafx.scene.text.Font.loadFont(javaClass.getResourceAsStream("/polices/Inter-VariableFont_slnt,wght.ttf"), 20.0)

        primaryStage.title="Flip7"
        val root = MenuPrincipalVue()
        scene = Scene(root, 1280.0, 720.0)

        ControleurMenu(root, this)
        primaryStage.scene=scene
        primaryStage.show()

    }

    fun changerVue(nouvelleVue: Parent) {
        scene.root = nouvelleVue
    }
}


fun main() {
    Application.launch(Flip7Main::class.java)
}