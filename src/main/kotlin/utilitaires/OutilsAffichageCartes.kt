package utilitaires

import javafx.geometry.Rectangle2D
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class OutilsAffichageCartes {

    // 1. Chargement de l'image contenant toutes les cartes (à faire une seule fois)
    private val spriteSheet = Image(javaClass.getResourceAsStream("/images/Cartes.png"))

    // 2. Tes dimensions exactes
    private val LARGEUR_CARTE = 68.0
    private val HAUTEUR_CARTE = 86.0

    // Espacement entre chaque carte
    private val ESPACE_X = 14.0
    private val ESPACE_Y = 14.0

    // 3. Marge initiale : l'espace entre le bord de l'image globale et la première carte "0"
    // (Si la carte "0" commence tout à fait au bord du fichier PNG, passe ces valeurs à 0.0)
    private val OFFSET_INITIAL_X = 14.0 // Valeur suggérée à tester
    private val OFFSET_INITIAL_Y = 14.0 // Valeur suggérée à tester

    /**
     * Découpe et retourne l'image d'une carte spécifique.
     * @param colonne L'index de la colonne (de 0 à 7 pour tes deux premières lignes)
     * @param ligne L'index de la ligne (de 0 à 2)
     */
    fun getImageCarte(colonne: Int, ligne: Int): ImageView {
        val imageView = ImageView(spriteSheet)

        // Calcul exact du coin supérieur gauche de la carte voulue
        val positionX = OFFSET_INITIAL_X + (colonne * (LARGEUR_CARTE + ESPACE_X))
        val positionY = OFFSET_INITIAL_Y + (ligne * (HAUTEUR_CARTE + ESPACE_Y))

        // Le Viewport masque tout le reste de l'image
        imageView.viewport = Rectangle2D(positionX, positionY, LARGEUR_CARTE, HAUTEUR_CARTE)

        // Si tes cartes (68x86) rendent un peu trop petit sur ta grande vue,
        // tu peux les redimensionner ici, JavaFX gardera la netteté :
        // imageView.fitWidth = 100.0
        // imageView.isPreserveRatio = true

        return imageView
    }
}