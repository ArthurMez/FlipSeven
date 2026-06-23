package flip7

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.stage.Stage


class TD1_1
    : Application() {

    init{
        print("je suis dans le constructeur")
    }
    override fun init(){
        print("je suis dans la méthode init")
    }

    override fun stop() {
        print("je suis dans la méthode stop")
    }

    override fun start(s: Stage) {
        s.title = ("titre")
        s.isResizable = false
        s.toFront()


        val root = BorderPane()
        val sc = Scene(root, 1000.0, 800.0)
        s.scene = sc
        s.show()
    }

}

fun main() {

    println("main avant launch")
    Application.launch(TD1_1::class.java)
    println("main après launch")
}



