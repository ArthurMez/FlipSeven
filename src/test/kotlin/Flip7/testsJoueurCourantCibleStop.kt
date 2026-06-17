package iut.info1.flip7
import iut.info1.flip7.cartes.Carte
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.cartes.CarteStop
import iut.info1.flip7.etats.EtatJoueur
import iut.info1.flip7.etats.EtatPartie
import iut.info1.flip7.exceptions.CarteInvalideException
import iut.info1.flip7.exceptions.EtatPartieInvalideException
import iut.info1.flip7.exceptions.JoueurNonActifException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class testsJoueurCourantCibleStop {

    private fun joueurs(n: Int): List<IJoueur> {
        val listeJoueurs = mutableListOf<IJoueur>()
        for (i in 1..n) {
            listeJoueurs.add(Joueur("Bob $i"))
        }
        return listeJoueurs
    }


    @Test
    fun testNormal() {
        val pioche = mutableListOf<Carte>(CarteStop(), CarteNum(1), CarteNum(2))
        val jeu = Flip7(2, joueurs(2), pioche, debug = true)
        
        val cartePiochee = jeu.joueurCourantPiocheUneCarte()
        assertEquals(EtatPartie.ATTENTE_CIBLE_STOP, jeu.etatPartie)
        
        // Bob 0 cible Bob 1
        assertEquals(EtatJoueur.JOUE_ENCORE, jeu.etatJoueur[1])
        jeu.joueurCourantCibleStop(cartePiochee as CarteStop, 1)
        
        // Bob 1 est stoppé
        assertEquals(EtatJoueur.STOP, jeu.etatJoueur[1])
    }

    @Test
    fun testPasBonEtat() {
        val pioche = mutableListOf<Carte>(CarteNum(1), CarteNum(2))
        val jeu = Flip7(2, joueurs(2), pioche, debug = true)
        
        assertEquals(EtatPartie.ATTENTE_CHOIX_JOUEUR, jeu.etatPartie)
        assertThrows<EtatPartieInvalideException> { jeu.joueurCourantCibleStop(CarteStop(), 1) }
    }

    @Test
    fun testMauvaiseInstanceCarte() {
        val pioche = mutableListOf<Carte>(CarteStop(), CarteNum(1), CarteNum(2))
        val jeu = Flip7(2, joueurs(2), pioche, debug = true)
        
        jeu.joueurCourantPiocheUneCarte()
        assertEquals(EtatPartie.ATTENTE_CIBLE_STOP, jeu.etatPartie)
        
        // Carte non piochée
        assertThrows<CarteInvalideException> { jeu.joueurCourantCibleStop(CarteStop(), 1) }
    }


    @Test
    fun testCibleDejaStop() {
        val pioche = mutableListOf<Carte>(
            CarteStop(),
            CarteNum(2)
        )
        val jeu = Flip7(3, joueurs(3), pioche, debug = true)
        
        // Bob 0 stop
        jeu.joueurCourantDitStop()
        assertEquals(EtatJoueur.STOP, jeu.etatJoueur[0])
        
        // Bob 1 pioche stop
        val cartePiochee = jeu.joueurCourantPiocheUneCarte()
        assertEquals(EtatPartie.ATTENTE_CIBLE_STOP, jeu.etatPartie)
        
        // Bob 1 cible Bob 0
        assertThrows<JoueurNonActifException> { jeu.joueurCourantCibleStop(cartePiochee as CarteStop, 0) }
    }

    @Test
    fun testCibleDejaPerdu() {
        val pioche = mutableListOf<Carte>(
            CarteNum(5),    // Bob 0
            CarteNum(7),    // Bob 1
            CarteNum(9),    // Bob 2
            CarteNum(5),    // Bob 0 doublon
            CarteStop(),    // Bob 1 pioche stop
            CarteNum(2)
        )
        val jeu = Flip7(3, joueurs(3), pioche, debug = true)
        
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        jeu.joueurCourantPiocheUneCarte()
        
        assertEquals(EtatJoueur.PERDU, jeu.etatJoueur[0])
        
        val cartePiochee = jeu.joueurCourantPiocheUneCarte()
        assertEquals(EtatPartie.ATTENTE_CIBLE_STOP, jeu.etatPartie)
        // Bob 1 cible Bob 0 qui est déjà éliminé
        assertThrows<JoueurNonActifException> { jeu.joueurCourantCibleStop(cartePiochee as CarteStop, 0) }
    }
}
