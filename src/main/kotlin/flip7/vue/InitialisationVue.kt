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

    val boutonRetour = Button("<--")
    private val labelTitre = Label("Flip 7")

    private val bas = HBox()
    private val basAjouter = VBox()
    private val boutonAjouter = Button("Ajouter joueur")
    private val inputNom = TextField()

    val boutonDemarrer = Button("Démarrer partie")

    private val centre = HBox()

    private val joueurs = arrayOfNulls<VBox>(4)
    private val imagesJoueurs = arrayOfNulls<ImageView>(4)
    private val labelsNoms = arrayOfNulls<Label>(4)
    private val boutonsSupprimer = arrayOfNulls<Button>(4)



    init {
        for (i in 0 until 4) {
            val joueur = VBox()
            joueur.alignment = Pos.CENTER
            joueur.spacing = 5.0

            val image: Image = Image("file:media/person-icon.png")
            val imageView = ImageView(image)
            imageView.fitWidth = 50.0
            imageView.fitHeight = 50.0
            imageView.isPreserveRatio = true
            imageView.opacity = 0.35 // start grayed out

            val labelNom = Label("")
            labelNom.isVisible = false

            val boutonSuppr = Button("X")
            boutonSuppr.isVisible = false
            boutonSuppr.userData = i

            joueur.children.addAll(imageView, labelNom, boutonSuppr)

            joueurs[i] = joueur
            imagesJoueurs[i] = imageView
            labelsNoms[i] = labelNom
            boutonsSupprimer[i] = boutonSuppr
        }

        inputNom.promptText = "Pseudo joueur:"

        // Center the title in the top region of BorderPane
        labelTitre.alignment = Pos.CENTER
        val topContainer = HBox(labelTitre)
        topContainer.alignment = Pos.CENTER
        BorderPane.setAlignment(topContainer, Pos.CENTER)
        this.top = topContainer
        this.left = boutonRetour

        centre.alignment = Pos.CENTER
        centre.spacing = 20.0

        for (j in joueurs) {
            centre.children.add(j)
        }

        this.center = centre

        basAjouter.spacing = 5.0
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
            // Player added: full opacity, show name and delete button
            imageView?.opacity = 1.0
            labelNom?.text = nom
            labelNom?.isVisible = true
            boutonSuppr?.isVisible = true
        } else {
            // Player removed: grayed out, hide name and delete button
            imageView?.opacity = 0.35
            labelNom?.text = ""
            labelNom?.isVisible = false
            boutonSuppr?.isVisible = false
        }
    }
}