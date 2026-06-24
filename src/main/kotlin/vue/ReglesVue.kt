package iut.info1.flip7.flip7.vue

import javafx.scene.layout.BorderPane
import javafx.scene.control.Button
import javafx.scene.control.Label


class ReglesVue : BorderPane() {
    val boutonRetour = Button("Retour")
    val titre = Label("Flip7")

    init {
        this.top = titre
        this.left = boutonRetour

    }
}