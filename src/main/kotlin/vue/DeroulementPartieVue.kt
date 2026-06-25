package iut.info1.flip7.flip7.vue

import iut.info1.flip7.cartes.Carte
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.effect.DropShadow
import javafx.scene.layout.BorderPane
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.RowConstraints
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import utilitaires.OutilsAffichageCartes

class DeroulementPartieVue : BorderPane() {

    // --- ÉLÉMENTS EXPOSÉS AU CONTRÔLEUR ---
    private val outilsCartes = OutilsAffichageCartes()
    // Le contrôleur aura besoin d'accéder à ces boutons pour leur donner une action
    val btnTirer = Button("Tirer")
    val btnStop = Button("Stop")
    private val conteneurCarteTiree = HBox()//Reservation de l'emplacement pour la carte tiré
    // Labels qui seront mis à jour par le contrôleur
    private var labelManche = Label("Manche : 1")
    private val labelScoreTotal = Label("Score total:")
    // Tu peux stocker les labels de score des joueurs dans une liste pour y accéder facilement par index
    private val labelsScoresJoueurs = mutableListOf<Label>()
    private val zonesCartesJoueurs = mutableListOf<HBox>()
    private val casesJoueurs = mutableListOf<VBox>()
    private val NomsGrille = mutableListOf<Label>()
    private val NomsScores = mutableListOf<Label>()

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
        val imagePioche = outilsCartes.getImageCarte(6, 2)
        zonePioche.children.addAll(imagePioche, conteneurCarteTiree)

        // Section Scores
        val zoneScores = HBox(15.0)
        zoneScores.alignment = Pos.CENTER
        zoneScores.style = "-fx-background-color: #f0f0f0; -fx-background-radius: 10; -fx-padding: 10 20 10 20;"
        labelScoreTotal.style = "-fx-text-fill: black; -fx-font-weight: bold;"
        zoneScores.children.add(labelScoreTotal)

        for (i in 0 until 4) {
            val nomJoueurLabel = Label("Absent")
            val scoreLabel = Label("0")
            nomJoueurLabel.style = "-fx-text-fill: black;"
            scoreLabel.style = "-fx-text-fill: black;"
            NomsScores.add(nomJoueurLabel)
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
        val nomJoueur = Label("Absent")
        NomsGrille.add(nomJoueur)
        val zoneBonus = HBox(5.0) // Contiendrait les cœurs, x2, etc.
        infoJoueur.children.addAll(nomJoueur, zoneBonus)

        // cartes numéros possédées
        val zoneCartes = HBox(-15.0) // Marge négative pour superposer légèrement les cartes
        zonesCartesJoueurs.add(zoneCartes)

        boxJoueur.children.addAll(infoJoueur, zoneCartes)
        casesJoueurs.add(boxJoueur)
        return boxJoueur
    }

    // --- MÉTHODES DE MISE À JOUR POUR LE CONTRÔLEUR ---

    fun initialisationNomJoueur(index: Int, nom: String) {
        if (index < NomsGrille.size) {
            NomsGrille[index].text = nom
        }
        if (index < NomsScores.size) {
            NomsScores[index].text = nom
        }
    }

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
    fun joueurElimine(indexJoueur: Int){
        casesJoueurs[indexJoueur].style = "-fx-background-color: #2c1a1a; -fx-background-radius: 5;"
    }
    fun joueurStop(indexJoueur: Int){
        casesJoueurs[indexJoueur].style = "-fx-background-color: #808080; -fx-background-radius: 5;"
    }
    fun fixeActionSurCaseJoueur(indexJoueur: Int, action: () -> Unit) {
        casesJoueurs[indexJoueur].setOnMouseClicked {
            action()
        }
    }
    fun preparerNouvelleManche(numeroManche: Int) {
        mettreAJourManche(numeroManche)

        // 1. On efface la dernière carte piochée au centre
        conteneurCarteTiree.children.clear()

        for (i in casesJoueurs.indices) {
            zonesCartesJoueurs[i].children.clear()
            casesJoueurs[i].style = "-fx-background-color: #4a548c; -fx-padding: 10; -fx-background-radius: 10;"
        }
    }
    fun rafraichirMainJoueur(indexJoueur: Int, listeCartes: List<Carte>) {
        val zone = zonesCartesJoueurs[indexJoueur]
        zone.children.clear() // On vide tout

        for (carte in listeCartes) {
            val coordonnees = outilsCartes.obtenirCoordonneesCarte(carte)
            zone.children.add(outilsCartes.getImageCarte(coordonnees.first, coordonnees.second))
        }
    }
    fun changerModeCiblage(actif: Boolean, indicesValides: List<Int> = emptyList()) {
        for (i in casesJoueurs.indices) {
            val case = casesJoueurs[i]
            if (actif) {
                if (indicesValides.contains(i)) {
                    case.userData = case.style
                    case.setOnMouseEntered {
                        case.style = "-fx-background-color: #7986cb; -fx-padding: 10; -fx-background-radius: 10; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 10;"
                    }
                    case.setOnMouseExited {
                        case.style = "-fx-background-color: #4a548c; -fx-padding: 10; -fx-background-radius: 10;"
                    }
                }
            } else {
                // --- ON DÉSACTIVE POUR TOUT LE MONDE ---
                case.cursor = javafx.scene.Cursor.DEFAULT
                case.onMouseEntered = null
                case.onMouseExited = null
            }
        }

    }
    fun mettreEnEvidenceJoueurCourant(indexJoueurCourant: Int) {
        val lueurDoree = DropShadow()
        lueurDoree.color = Color.BLACK
        lueurDoree.radius = 25.0
        lueurDoree.spread = 0.6 // Règle l'intensité de la lueur


        for (i in casesJoueurs.indices) {
            if (i == indexJoueurCourant) {
                // On applique la lueur uniquement au joueur qui doit jouer
                casesJoueurs[i].effect = lueurDoree
            } else {
                // On retire l'effet pour tous les autres joueurs
                casesJoueurs[i].effect = null
            }
        }
    }
}