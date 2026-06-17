package iut.info1.flip7
import iut.info1.flip7.Flip7
import iut.info1.flip7.IJoueur
import iut.info1.flip7.Joueur
import iut.info1.flip7.cartes.Carte
import iut.info1.flip7.cartes.CarteStop
import iut.info1.flip7.etats.EtatJoueur
import iut.info1.flip7.etats.EtatPartie
import iut.info1.flip7.exceptions.EtatPartieInvalideException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import iut.info1.flip7.cartes.CarteBonusPlus
import iut.info1.flip7.cartes.CarteNum
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class testsJoueurCourantDitStop {

    private fun joueurs(n: Int): List<IJoueur> {
        val listeJoueurs = mutableListOf<IJoueur>()
        for (i in 1..n) {
            listeJoueurs.add(Joueur("Bob $i"))
        }
        return listeJoueurs
    }


    @Test
    fun testStopNormal() {
        val pioche = mutableListOf<Carte>(CarteNum(1), CarteNum(2), CarteNum(3), CarteNum(4), CarteNum(5))
        val jeu = Flip7(2, joueurs(2), pioche, debug = true)
        
        assertEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
        assertEquals(0, jeu.joueurCourant)
        assertEquals(EtatJoueur.JOUE_ENCORE, jeu.etatJoueur[0])
        
        jeu.joueurCourantDitStop()
        
        assertEquals(EtatJoueur.STOP, jeu.etatJoueur[0])
        assertEquals(1, jeu.joueurCourant)
        assertEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
    }

    @Test
    fun testStopPendantAttenteCible() {
        val pioche = mutableListOf<Carte>(CarteStop(), CarteNum(1), CarteNum(2))
        val jeu = Flip7(2, joueurs(2), pioche, debug = true)

        jeu.joueurCourantPiocheUneCarte()
        assertEquals(EtatPartie.ATTENTE_CIBLE_STOP, jeu.etatPartie)
        assertThrows<EtatPartieInvalideException> { jeu.joueurCourantDitStop() }
    }

    @Test
    fun testStopAlorsQueDejaStop() {
        val pioche = mutableListOf<Carte>(CarteNum(1), CarteNum(2), CarteNum(3))
        val jeu = Flip7(2, joueurs(2), pioche, debug = true)

        jeu.joueurCourantDitStop()
        jeu.joueurCourantDitStop()
        
        assertEquals(EtatPartie.MANCHE_TERMINEE, jeu.etatPartie)
        assertThrows<EtatPartieInvalideException> { jeu.joueurCourantDitStop() }
    }

    @Test
    fun testStopDernierFin() {
        val pioche = mutableListOf<Carte>(CarteNum(1), CarteNum(2), CarteNum(3))
        val jeu = Flip7(2, joueurs(2), pioche, debug = true)

        jeu.joueurCourantDitStop() // Bob 1 est maintenant le dernier joueur actif
        assertEquals(EtatJoueur.STOP, jeu.etatJoueur[0])
        assertEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
        assertEquals(1, jeu.joueurCourant)
        
        // Bob 1 stop, fin de partie
        jeu.joueurCourantDitStop()
        
        assertEquals(EtatJoueur.STOP, jeu.etatJoueur[1])
        assertEquals(EtatPartie.MANCHE_TERMINEE, jeu.etatPartie)
    }
}