package Flip7

import iut.info1.flip7.Flip7
import iut.info1.flip7.Joueur
import iut.info1.flip7.cartes.Carte2ndeChance
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.cartes.CarteStop
import iut.info1.flip7.etats.EtatJoueur
import iut.info1.flip7.etats.EtatPartie
import iut.info1.flip7.exceptions.EtatPartieInvalideException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestJoueurCourantPiocheUneCarte {
    @Test
    fun ct1JoueurCourantPiocheUneCarte() {
        val carteAttendue = CarteNum(5)
        val pioche = listOf(carteAttendue, CarteNum(7), CarteNum(8))
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Bob"), Joueur("Boby")),
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
    fun ct2JoueurCourantPiocheUneCarte() {

        val pioche = listOf(CarteStop(), CarteNum(5))
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman")),
            cartes = pioche,
            debug = true
        )

        jeu.joueurCourantPiocheUneCarte()
        val indexJoueur = jeu.joueurCourant
        assertNotEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
        assertEquals(EtatJoueur.JOUE_ENCORE, jeu.etatJoueur[indexJoueur])

        assertThrows<EtatPartieInvalideException> {
            jeu.joueurCourantPiocheUneCarte()
        }
    }

    @Test
    fun ct3JoueurCourantPiocheUneCarte() {

        val pioche = listOf(CarteNum(5), CarteNum(5), CarteNum(5))
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman")),
            cartes = pioche,
            debug = true
        )

        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()

        assertEquals(EtatJoueur.PERDU, jeu.etatJoueur[0])

    }

    @Test
    fun ct4JoueurCourantPiocheUneCarteStop() {

        val pioche = listOf(CarteStop(), CarteNum(5), CarteNum(5))
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman")),
            cartes = pioche,
            debug = true
        )
        jeu.joueurCourantCibleStop(jeu.joueurCourantPiocheUneCarte(), 1)

        assertEquals(EtatJoueur.STOP, jeu.etatJoueur[1])
    }

    @Test
    fun ct5JoueurCourantPiocheUneCarte2ndeChance() {

        val pioche = listOf(Carte2ndeChance(), CarteNum(5), CarteNum(5), CarteNum(2), CarteNum(5))
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman")),
            cartes = pioche,
            debug = true
        )
        jeu.joueurCourantPiocheUneCarte()
        assertNotNull(jeu.main[0])
        assertTrue(jeu.main[0]!!.contains(Carte2ndeChance()), "La carte 2nde chance devrait être dans la main")
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        assertFalse(jeu.main[0]!!.contains(Carte2ndeChance()), "La carte 2nde chance devrait plus être dans la main")


        assertEquals(EtatJoueur.JOUE_ENCORE, jeu.etatJoueur[0])
    }
}