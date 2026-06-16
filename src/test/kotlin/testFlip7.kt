import iut.info1.flip7.Flip7
import iut.info1.flip7.IJoueur
import iut.info1.flip7.Joueur
import iut.info1.flip7.cartes.Carte
import iut.info1.flip7.cartes.Carte2ndeChance
import iut.info1.flip7.cartes.Carte3aLaSuite
import iut.info1.flip7.cartes.CarteBonusMultiplie
import iut.info1.flip7.cartes.CarteBonusPlus
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.cartes.CarteStop
import iut.info1.flip7.etats.EtatJoueur
import iut.info1.flip7.etats.EtatPartie
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TestFlip7   {
    @Test
    fun ct1JoueurCourantPiocheUneCarte() {
        val carteAttendue = CarteNum(5)
        val pioche = listOf(carteAttendue, CarteNum(7), CarteNum(8))
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Bob"),Joueur("Boby")),
            cartes = pioche,
            debug = true
        )
        val indexJoueur = jeu.joueurCourant
        val carteTiree = jeu.joueurCourantPiocheUneCarte()

        assertEquals(carteAttendue, carteTiree)
        assertTrue(carteTiree is CarteNum)

        val mainDuJoueur = jeu.main[indexJoueur]
        assertNotNull(mainDuJoueur)
        assertTrue(mainDuJoueur!!.contains(carteTiree))
        assertEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
        assertEquals(EtatJoueur.JOUE_ENCORE, jeu.etatJoueur[indexJoueur])
    }

    @Test
    fun ct2JoueurCourantPiocheUneCarte(){}

}