package iut.info1.flip7.flip7.vue

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.RowConstraints
import javafx.scene.layout.VBox
import utilitaires.OutilsAffichageCartes

class DeroulementPartieVue : BorderPane() {

    // --- ÉLÉMENTS EXPOSÉS AU CONTRÔLEUR ---
    private val outilsCartes = OutilsAffichageCartes()
    // Le contrôleur aura besoin d'accéder à ces boutons pour leur donner une action
    val btnTirer = Button("Tirer")
    val btnStop = Button("Stop")
    private val conteneurCarteTiree = HBox()//Reservation de l'emplacement pour la carte tiré
    // Labels qui seront mis à jour par le contrôleur
    private val labelManche = Label("Manche : 1")
    private val labelScoreTotal = Label("Score total:")
    // Tu peux stocker les labels de score des joueurs dans une liste pour y accéder facilement par index
    private val labelsScoresJoueurs = mutableListOf<Label>()

    init {
        // Grille des joueurs
        val grilleJoueurs = GridPane()
        grilleJoueurs.alignment = Pos.CENTER
        grilleJoueurs.hgap = 20.0
        grilleJoueurs.vgap = 20.0
        grilleJoueurs.padding = Insets(20.0)

        //  colonnes de 50% de largeur
        val colConstraint = ColumnConstraints()
        colConstraint.percentWidth = 50.0
        grilleJoueurs.columnConstraints.addAll(colConstraint, colConstraint)

        // 2 lignes de 50% de hauteur
        val rowConstraint = RowConstraints()
        rowConstraint.percentHeight = 50.0
        grilleJoueurs.rowConstraints.addAll(rowConstraint, rowConstraint)

        for (i in 0 until 4) {
            val zoneJoueur = creerZoneJoueur(i)
            // Placement dans la grille (2 colonnes x 2 lignes)
            grilleJoueurs.add(zoneJoueur, i % 2, i / 2)
        }

        this.center = grilleJoueurs

        // Menu d'actions et scores
        val menuBas = HBox(20.0)
        menuBas.alignment = Pos.CENTER
        menuBas.prefHeight = 120.0
        menuBas.style = "-fx-background-color: #1a1a3a; -fx-padding: 10;"

        // Section Pioche / Carte tirée
        val zonePioche = HBox(10.0)
        val imagePioche = outilsCartes.getImageCarte(5, 2)
        zonePioche.children.addAll(imagePioche, conteneurCarteTiree)

        // Section Scores
        val zoneScores = HBox(15.0)
        zoneScores.alignment = Pos.CENTER
        zoneScores.style = "-fx-background-color: #f0f0f0; -fx-background-radius: 10; -fx-padding: 10 20 10 20;"
        labelScoreTotal.style = "-fx-text-fill: black; -fx-font-weight: bold;"
        zoneScores.children.add(labelScoreTotal)

        for (i in 0 until 4) {
            val nomJoueurLabel = Label("Joueur${i+1}")
            val scoreLabel = Label("0")
            nomJoueurLabel.style = "-fx-text-fill: black;"
            scoreLabel.style = "-fx-text-fill: black;"

            val scoreBox = VBox(nomJoueurLabel, scoreLabel)
            scoreBox.alignment = Pos.CENTER
            labelsScoresJoueurs.add(scoreLabel)
            zoneScores.children.add(scoreBox)
        }

        // Section Boutons
        val zoneBoutons = VBox(10.0, btnTirer, btnStop)
        zoneBoutons.alignment = Pos.CENTER_RIGHT
        labelManche.style ="-fx-text-fill: white;"
        menuBas.children.addAll(zonePioche, labelManche, zoneScores, zoneBoutons)

        this.bottom = menuBas
    }

    /**
     * Crée la zone dédiée à un joueur spécifique.
     */
    private fun creerZoneJoueur(index: Int): VBox {
        // VBox globale pour le joueur
        val boxJoueur = VBox(10.0)
        boxJoueur.style = "-fx-background-color: #4a548c; -fx-padding: 10; -fx-background-radius: 10;"

        boxJoueur.maxWidth = Double.MAX_VALUE
        boxJoueur.maxHeight = Double.MAX_VALUE

        // Nom du joueur et symboles bonus
        val infoJoueur = HBox(10.0)
        val nomJoueur = Label("Joueur ${index + 1}")
        val zoneBonus = HBox(5.0) // Contiendrait les cœurs, x2, etc.
        infoJoueur.children.addAll(nomJoueur, zoneBonus)

        // cartes numéros possédées
        val zoneCartes = HBox(-15.0) // Marge négative pour superposer légèrement les cartes


        boxJoueur.children.addAll(infoJoueur, zoneCartes)
        return boxJoueur
    }

    // --- MÉTHODES DE MISE À JOUR POUR LE CONTRÔLEUR ---

    fun mettreAJourScore(indexJoueur: Int, nouveauScore: Int) {
        labelsScoresJoueurs[indexJoueur].text = nouveauScore.toString()
    }

    fun mettreAJourManche(numeroManche: Int) {
        labelManche.text = "Manche : $numeroManche"
    }
    fun afficherCarteTiree(colonne: Int, ligne: Int) {
        conteneurCarteTiree.children.clear() // On efface la carte du tour précédent
        conteneurCarteTiree.children.add(outilsCartes.getImageCarte(colonne, ligne))
    }
}