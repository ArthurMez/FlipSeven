package Flip7

import iut.info1.flip7.Flip7
import iut.info1.flip7.Joueur
import iut.info1.flip7.cartes.Carte3aLaSuite
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.cartes.CarteStop
import iut.info1.flip7.etats.EtatJoueur
import iut.info1.flip7.exceptions.CarteInvalideException
import iut.info1.flip7.exceptions.EtatPartieInvalideException
import iut.info1.flip7.exceptions.JoueurNonActifException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestJoueurCourantCible3aLaSuite {
    @Test
    fun ct1joueurCourantCible3aLaSuite() {
        val pioche = listOf(Carte3aLaSuite(), CarteNum(5), CarteNum(4), CarteNum(3), CarteStop())
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman")),
            cartes = pioche,
            debug = true
        )
        val cartesAttendues = listOf(Carte3aLaSuite(), CarteNum(5), CarteNum(4), CarteNum(3))
        jeu.joueurCourantCible3aLaSuite(jeu.joueurCourantPiocheUneCarte(), 1)
        assertEquals(4, jeu.main[1]?.size)
        assertEquals(cartesAttendues, jeu.main[1])

        assertEquals(EtatJoueur.JOUE_ENCORE, jeu.etatJoueur[1])
    }

    @Test
    fun ct2joueurCourantCible3aLaSuite() {
        val pioche = listOf(CarteNum(5), CarteNum(5), CarteNum(4), CarteNum(3), CarteStop())
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman")),
            cartes = pioche,
            debug = true
        )
        assertThrows<EtatPartieInvalideException> {
            jeu.joueurCourantCible3aLaSuite(jeu.joueurCourantPiocheUneCarte(), 1)
        }
    }

    @Test
    fun ct3joueurCourantCible3aLaSuite() {
        val pioche = listOf(Carte3aLaSuite(), CarteNum(5), CarteNum(5), CarteNum(4), CarteNum(3), CarteStop())
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman")),
            cartes = pioche,
            debug = true
        )
        jeu.joueurCourantPiocheUneCarte()
        assertThrows<CarteInvalideException> {
            jeu.joueurCourantCible3aLaSuite(Carte3aLaSuite(), 1)
        }
    }

    @Test
    fun ct4joueurCourantCible3aLaSuite() {
        val pioche = listOf(CarteStop(), Carte3aLaSuite(), CarteNum(5), CarteNum(4), CarteNum(3), CarteStop())
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman")),
            cartes = pioche,
            debug = true
        )
        jeu.joueurCourantCibleStop(jeu.joueurCourantPiocheUneCarte(), 1)
        assertThrows<JoueurNonActifException> {
            jeu.joueurCourantCible3aLaSuite(jeu.joueurCourantPiocheUneCarte(), 1)
        }
    }
    @Test
    fun ct5joueurCourantCible3aLaSuite() {
        val pioche = listOf(CarteNum(5),CarteNum(4),CarteNum(3),CarteNum(5), Carte3aLaSuite(), CarteNum(1))
        val jeu = Flip7(
            nbJoueurs = 3,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman"), Joueur("Nicolas")),
            cartes = pioche,
            debug = true
        )
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantDitStop()
        jeu.joueurCourantDitStop()
        jeu.scoreManche()
        jeu.nouvelleManche()
        jeu.joueurCourantCible3aLaSuite(jeu.joueurCourantPiocheUneCarte(),2)
        assertEquals(4,jeu.main[2]?.size)
    }
    @Test
    fun ct6joueurCourantCible3aLaSuite() {
        val pioche = listOf(Carte3aLaSuite(), CarteNum(5), CarteNum(5), CarteNum(3))
        val jeu = Flip7(
            nbJoueurs = 2,
            joueurs = listOf(Joueur("Isac"), Joueur("Roman")),
            cartes = pioche,
            debug = true
        )
        jeu.joueurCourantCible3aLaSuite(jeu.joueurCourantPiocheUneCarte(),1)
        assertEquals(EtatJoueur.PERDU ,jeu.etatJoueur[1])
        //On vérifie que la dernière carte n'a pas été disstribué par le 3 à la suite
        assertEquals(1, jeu.taillePioche)
    }
}