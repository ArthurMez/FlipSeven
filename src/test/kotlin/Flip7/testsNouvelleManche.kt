package iut.info1.flip7

import iut.info1.flip7.cartes.Carte
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.etats.EtatJoueur
import iut.info1.flip7.etats.EtatPartie
import iut.info1.flip7.exceptions.EtatPartieInvalideException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class testsNouvelleManche {

    private fun joueurs(n: Int): List<IJoueur> {
        val listeJoueurs = mutableListOf<IJoueur>()
        for (i in 1..n) {
            listeJoueurs.add(Joueur("Bob $i"))
        }
        return listeJoueurs
    }

    @Test
    fun testNormal() {
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
        
        jeu.joueurCourantDitStop() // manche terminée
        jeu.scoreManche() // nouvelle manche

        assertEquals(EtatPartie.NOUVELLE_MANCHE, jeu.etatPartie)
        
        jeu.nouvelleManche()

        assertEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
        assertEquals(EtatJoueur.JOUE_ENCORE, jeu.etatJoueur[0])
        assertEquals(EtatJoueur.JOUE_ENCORE, jeu.etatJoueur[1])
    }


    @Test
    fun testMauvaisEtat() {
        val pioche = mutableListOf<Carte>(CarteNum(1))
        val jeu = Flip7(2, joueurs(2), pioche, debug = true, scoreFinPartie = 50)

        assertEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
        assertThrows<EtatPartieInvalideException> { jeu.nouvelleManche() }
    }


    @Test
    fun testNouvelleMancheAlorsQueTermine() {
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
        
        jeu.joueurCourantDitStop() // manche finie
        jeu.scoreManche() // partie terminee

        assertEquals(EtatPartie.PARTIE_TERMINEE, jeu.etatPartie)
        assertThrows<EtatPartieInvalideException> { jeu.nouvelleManche() }
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
        
        jeu.joueurCourantDitStop() // manche finie
        val scoresApresManche = jeu.scoreManche()
        
        assertEquals(8, scoresApresManche[0])
        assertEquals(0, scoresApresManche[1])
        
        jeu.nouvelleManche()
        assertEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
    }
}
