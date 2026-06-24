package iut.info1.flip7.flip7.vue

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class MenuPrincipalVue : VBox() {
    val titre: Label = Label("Flip 7")
    val boutonPartie: Button = Button("Creer une partie")
    val boutonRegles: Button = Button("Règles du jeu")
    val boutonQuitter: Button = Button("Quitter")

    init {

        this.alignment = Pos.CENTER
        this.spacing = 25.0
        this.padding = Insets(20.0)
        this.style = "-fx-background-color: #D0D0D0;"

        titre.style = "-fx-font-family: 'Leckerli One'; -fx-font-size: 55px; -fx-text-fill: black;"

        boutonPartie.style = "-fx-font-family: 'Inter'; -fx-font-size: 18px; -fx-font-weight: bold; -fx-background-color: #A3A2C4; -fx-text-fill: black; -fx-background-radius: 12px; -fx-border-radius: 12px; -fx-border-color: black; -fx-border-width: 2px;"
        boutonPartie.prefWidth = 250.0
        boutonPartie.prefHeight = 50.0

        boutonRegles.style = "-fx-font-family: 'Inter'; -fx-font-size: 18px; -fx-font-weight: bold; -fx-background-color: #A3A2C4; -fx-text-fill: black; -fx-background-radius: 12px; -fx-border-radius: 12px; -fx-border-color: black; -fx-border-width: 2px;"
        boutonRegles.prefWidth = 250.0
        boutonRegles.prefHeight = 50.0

        boutonQuitter.style = "-fx-font-family: 'Inter'; -fx-font-size: 18px; -fx-font-weight: bold; -fx-background-color: #A3A2C4; -fx-text-fill: black; -fx-background-radius: 12px; -fx-border-radius: 12px; -fx-border-color: black; -fx-border-width: 2px;"
        boutonQuitter.prefWidth = 250.0
        boutonQuitter.prefHeight = 50.0

        this.children.addAll(titre, boutonPartie, boutonRegles, boutonQuitter)
    }
}