package iut.info1.flip7

import iut.info1.flip7.cartes.Carte
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.etats.EtatJoueur
import iut.info1.flip7.etats.EtatPartie
import iut.info1.flip7.exceptions.EtatPartieInvalideException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class testsScoreManche {

    private fun joueurs(n: Int): List<IJoueur> {
        val listeJoueurs = mutableListOf<IJoueur>()
        for (i in 1..n) {
            listeJoueurs.add(Joueur("Bob $i"))
        }
        return listeJoueurs
    }

    // CT1 : J0 STOP main=[CarteNum(3),CarteNum(5)], J1 PERDU → `{0→8, 1→0}`
    @Test
    fun testNormal() {
        val pioche = mutableListOf<Carte>(
            CarteNum(3), // Bob 0
            CarteNum(1), // Bob 1
            CarteNum(5), // Bob 0
            CarteNum(1)  // Bob 1 doublon perdu
        )
        val jeu = Flip7(2, joueurs(2), pioche, debug = true, scoreFinPartie = 200)

        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()

        assertEquals(EtatJoueur.PERDU, jeu.etatJoueur[1])
        
        jeu.joueurCourantDitStop() // Manche terminé
        assertEquals(EtatPartie.MANCHE_TERMINEE, jeu.etatPartie)

        val scores = jeu.scoreManche()
        assertEquals(8, scores[0])
        assertEquals(0, scores[1])
        assertEquals(EtatPartie.NOUVELLE_MANCHE, jeu.etatPartie)
    }


    @Test
    fun testMauvaisEtat() {
        val pioche = mutableListOf<Carte>(CarteNum(1))
        val jeu = Flip7(2, joueurs(2), pioche, debug = true, scoreFinPartie = 200)

        assertEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
        assertThrows<EtatPartieInvalideException> { jeu.scoreManche() }  //Score pendant attente choix
    }

    @Test
    fun testBonusFlip7() {
        val pioche = mutableListOf<Carte>(
            CarteNum(0), // Bob 0
            CarteNum(10), // Bob 1
            CarteNum(1), // Bob 0
            CarteNum(10), // Bob 1 perdu
            CarteNum(2), // Bob 0
            CarteNum(3), // Bob 0
            CarteNum(4), // Bob 0
            CarteNum(5), // Bob 0
            CarteNum(6) // Bob 0 flip7
        )
        val jeu = Flip7(2, joueurs(2), pioche, debug = true, scoreFinPartie = 200)

        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()

        assertEquals(EtatPartie.MANCHE_TERMINEE, jeu.etatPartie)

        val scores = jeu.scoreManche()
        assertEquals(36, scores[0])
        assertEquals(EtatPartie.NOUVELLE_MANCHE, jeu.etatPartie)
    }

    @Test
    fun testPartieFinie() {
        val pioche = mutableListOf<Carte>(
            CarteNum(10), // Bob 0
            CarteNum(1),  // Bob 1
            CarteNum(11), // Bob 0
            CarteNum(1),  // Bob 1 perdu
            CarteNum(12), // Bob 0
            iut.info1.flip7.cartes.CarteBonusMultiplie() // Bob 0
        )

        val jeu = Flip7(2, joueurs(2), pioche, debug = true, scoreFinPartie = 50)

        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        
        jeu.joueurCourantDitStop() // Bob 0 Stop

        val scores = jeu.scoreManche()
        //(10 + 11 + 12)*2=66
        assertEquals(66, scores[0])
        assertEquals(0, scores[1])
        assertEquals(EtatPartie.PARTIE_TERMINEE, jeu.etatPartie)
    }


    @Test
    fun testNouvelleManche() {
        val pioche = mutableListOf<Carte>(
            CarteNum(3), // Bob 0
            CarteNum(1), // Bob 1
            CarteNum(5), // Bob 0
            CarteNum(1)  // Bob 1 perdu
        )

        val jeu = Flip7(2, joueurs(2), pioche, debug = true, scoreFinPartie = 50)

        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        
        jeu.joueurCourantDitStop() // Bob 0 stop, fin de manche, mais pas score suffisant

        val scores = jeu.scoreManche()
        assertEquals(8, scores[0])
        assertEquals(EtatPartie.NOUVELLE_MANCHE, jeu.etatPartie)
    }
}
