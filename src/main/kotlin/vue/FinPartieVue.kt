package vue

import iut.info1.flip7.Flip7
import javafx.geometry.Insets

import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class FinPartieVue(partie : Flip7) : VBox(40.0) { // Ajout d'un espacement vertical global de 40.0
    val titre = Label("Fin de partie").apply {
        style = """
                -fx-font-family: 'Leckerli One';
                -fx-font-size: 50px;
                -fx-font-weight: bold;
                -fx-text-fill: #000000;
            """
    }

    val buttonStyle = """
            -fx-background-color: #A6A4CA;
            -fx-text-fill: #000000;
            -fx-font-family: 'Arial', sans-serif;
            -fx-font-size: 32px;
            -fx-font-weight: bold;
            -fx-background-radius: 12px;
            -fx-border-radius: 12px;
            -fx-border-color: #000000;
            -fx-border-width: 2px;
            -fx-pref-width: 320px;
            -fx-pref-height: 100px;
        """

    val btnQuitter = Button("Quitter").apply {
        style = buttonStyle
    }

    val btnRejouer = Button("Rejouer").apply {
        style = buttonStyle
    }

    val scoresContainer = VBox(15.0).apply {
        alignment = Pos.CENTER
        style = """
            -fx-border-color: #000000;
            -fx-border-width: 2px;
            -fx-padding: 25px 40px;
            -fx-background-color: transparent;
            -fx-border-radius: 12px;
        """
    }

    val scoresFinaux = partie.joueurs


    val lignesScores: List<String> = scoresFinaux.sortedByDescending { partie.score[partie.joueurs.indexOf(it)] }
        .mapIndexed { index, joueur ->
            val score = partie.score[partie.joueurs.indexOf(joueur)]

            "${index + 1} ${joueur.donneNom()} - $score pts"
        }

    init {
        alignment = Pos.CENTER
        style = "-fx-background-color: #D3D3D3;"

        val afficheBtn = HBox(80.0, btnQuitter, btnRejouer).apply {
            alignment = Pos.CENTER

        }

        val margesConteneur = Insets(0.0, 400.0, 00.0, 400.0)
        VBox.setMargin(scoresContainer,margesConteneur)

        this.children.addAll(titre, scoresContainer, afficheBtn)

        afficherScores(lignesScores)
    }

    fun afficherScores(listeScores: List<String>) {
        scoresContainer.children.clear()

        listeScores.forEach { scoreText ->
            val labelScore = Label(scoreText)
            labelScore.style ="""-fx-font-family: 'Comic Sans MS', 'Caveat', cursive;-fx-font-size: 28px;-fx-font-weight: bold;"""
            scoresContainer.children.add(labelScore)
        }
    }
}