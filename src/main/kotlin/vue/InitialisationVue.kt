package iut.info1.flip7.flip7.vue

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class InitialisationVue : BorderPane() {

    val boutonRetour = Button("←")
    private val labelTitre = Label("Flip 7")


    private val bas = HBox()
    private val basAjouter = VBox()
    private val boutonAjouter = Button("Ajouter joueur")
    private val inputNom = TextField()


    val boutonDemarrer = Button("Démarrer partie")
    private val labelErreur = Label("")

    private val centre = HBox()

    private val joueurs = arrayOfNulls<VBox>(4)
    private val imagesJoueurs = arrayOfNulls<ImageView>(4)
    private val labelsNoms = arrayOfNulls<Label>(4)
    private val boutonsSupprimer = arrayOfNulls<Button>(4)



    init {
        inputNom.promptText = "Pseudo joueur"
        labelTitre.style = "-fx-font-family: 'Leckerli One'; -fx-font-size: 55px; -fx-text-fill: black;"
        for (i in 0 until 4) {
            val joueur = VBox()
            joueur.alignment = Pos.CENTER
            joueur.spacing = 5.0

            val image: Image = Image("file:src/main/resources/Images/person-icon.png")
            val imageView = ImageView(image)
            imageView.fitWidth = 300.0
            imageView.fitHeight = 300.0
            imageView.isPreserveRatio = true
            imageView.opacity = 0.35

            val labelNom = Label("")
            labelNom.isVisible = false

            val boutonSuppr = Button("X")
            boutonSuppr.isVisible = false
            boutonSuppr.userData = i
            boutonSuppr.style = "-fx-font-family: 'Inter'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-color: #E57373; -fx-text-fill: white; -fx-background-radius: 50; -fx-border-radius: 50; -fx-border-color: black; -fx-border-width: 2px; -fx-cursor: hand;"
            boutonSuppr.prefWidth = 36.0
            boutonSuppr.prefHeight = 36.0

            joueur.children.addAll(imageView, labelNom, boutonSuppr)

            joueurs[i] = joueur
            imagesJoueurs[i] = imageView
            labelsNoms[i] = labelNom
            boutonsSupprimer[i] = boutonSuppr
        }


        labelTitre.alignment = Pos.CENTER
        val topContainer = HBox(labelTitre)
        topContainer.alignment = Pos.CENTER
        BorderPane.setAlignment(topContainer, Pos.CENTER)
        this.top = topContainer

        boutonRetour.style = "-fx-font-family: 'Inter'; -fx-font-size: 18px; -fx-font-weight: bold; -fx-background-color: #A3A2C4; -fx-text-fill: black; -fx-background-radius: 12px; -fx-border-radius: 12px; -fx-border-color: black; -fx-border-width: 2px; -fx-cursor: hand;"
        boutonRetour.prefWidth = 50.0
        boutonRetour.prefHeight = 50.0
        this.left = boutonRetour

        centre.alignment = Pos.CENTER
        centre.spacing = 20.0

        for (j in joueurs) {
            centre.children.add(j)
        }

        this.center = centre

        boutonAjouter.style = "-fx-font-family: 'Inter'; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-color: #A3A2C4; -fx-text-fill: black; -fx-background-radius: 12px; -fx-border-radius: 12px; -fx-border-color: black; -fx-border-width: 2px; -fx-cursor: hand;"
        boutonAjouter.prefWidth = 200.0
        boutonAjouter.prefHeight = 45.0

        boutonDemarrer.style = "-fx-font-family: 'Inter'; -fx-font-size: 18px; -fx-font-weight: bold; -fx-background-color: #A3A2C4; -fx-text-fill: black; -fx-background-radius: 12px; -fx-border-radius: 12px; -fx-border-color: black; -fx-border-width: 2px; -fx-cursor: hand;"
        boutonDemarrer.prefWidth = 250.0
        boutonDemarrer.prefHeight = 50.0

        inputNom.prefWidth = 200.0
        inputNom.style = "-fx-font-family: 'Inter'; -fx-font-size: 14px;"

        labelErreur.style = "-fx-font-family: 'Inter'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #D32F2F;"
        labelErreur.isVisible = false

        basAjouter.spacing = 8.0
        basAjouter.alignment = Pos.CENTER
        basAjouter.children.addAll(inputNom, boutonAjouter)

        bas.alignment = Pos.CENTER
        bas.spacing = 100.0
        bas.children.addAll(basAjouter, boutonDemarrer)
        this.bottom = bas
    }

    fun fixeControleurBoutonAjouter(controleur: EventHandler<ActionEvent>) {
        boutonAjouter.onAction = controleur
    }

    fun fixeControleurBoutonSupprimer(controleur: EventHandler<ActionEvent>) {
        for (btn in boutonsSupprimer) {
            btn?.onAction = controleur
        }
    }

    fun getNomSaisi(): String = inputNom.text

    fun clearInput() {
        inputNom.clear()
    }

    fun afficherErreur(message: String) {
        labelErreur.text = message
        labelErreur.isVisible = true
    }

    fun masquerErreur() {
        labelErreur.text = ""
        labelErreur.isVisible = false
    }

    fun getIndexBouton(bouton: Button): Int {
        return bouton.userData as? Int ?: -1
    }

    fun mettreAJourAffichageJoueur(index: Int, nom: String?) {
        if (index >= 4) {
            return
        }

        val imageView = imagesJoueurs[index]
        val labelNom = labelsNoms[index]
        val boutonSuppr = boutonsSupprimer[index]

        if (nom != null) {
            imageView?.opacity = 1.0
            labelNom?.text = nom
            labelNom?.isVisible = true
            boutonSuppr?.isVisible = true
        } else {
            imageView?.opacity = 0.35
            labelNom?.text = ""
            labelNom?.isVisible = false
            boutonSuppr?.isVisible = false
        }
    }
}