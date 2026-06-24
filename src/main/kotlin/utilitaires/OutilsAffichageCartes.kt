package utilitaires

import iut.info1.flip7.cartes.*
import javafx.geometry.Rectangle2D
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class OutilsAffichageCartes {

    // 1. Chargement de l'image contenant toutes les cartes
    private val spriteSheet = Image(javaClass.getResourceAsStream("/images/Cartes.png"))

    private val LARGEUR_CARTE = 68.0
    private val HAUTEUR_CARTE = 86.0

    // Espacement entre chaque carte
    private val ESPACE_X = 14.0
    private val ESPACE_Y = 14.0

    // 3. Marge initiale : l'espace entre le bord de l'image globale et la première carte "0"
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



        return imageView
    }

fun obtenirCoordonneesCarte(carte: Carte): Pair<Int, Int> {
        return when (carte) {

            is CarteNum -> {
                if (carte.valeur <= 7) {
                    Pair(carte.valeur, 0)
                } else {
                    Pair(carte.valeur - 8, 1)
                }
            }

            is CarteBonusPlus -> {
                when (carte.valeur) {
                    2 -> Pair(5, 1)
                    4 -> Pair(6, 1)
                    6 -> Pair(7, 1)
                    8 -> Pair(0, 2)
                    10 -> Pair(1, 2)
                    else -> Pair(6, 2)
                }
            }

            is CarteBonusMultiplie -> Pair(2, 2)
            is CarteStop -> Pair(3, 2)
            is Carte2ndeChance -> Pair(4, 2)
            is Carte3aLaSuite -> Pair(5, 2)

            else -> Pair(5, 2)
        }
    }
}