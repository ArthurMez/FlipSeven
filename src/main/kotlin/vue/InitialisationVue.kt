package iut.info1.flip7.flip7.vue

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane

class InitialisationVue: BorderPane() {
    val boutonRetour = Button("Retour")
    val titre = Label("Flip7")

    init {
        this.top = titre
        this.left = boutonRetour

    }
}