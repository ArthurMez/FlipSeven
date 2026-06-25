package iut.info1.flip7.flip7.modele

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ModeleInitialisationTest {

    private lateinit var modele: ModeleInitialisation

    @BeforeEach
    fun setUp() {
        modele = ModeleInitialisation()
    }



    @Test
    fun verefieAjouterJoueur1() {
        assertEquals(0, modele.ajouterJoueur("Roman"))
    }
    //ajouterJoueur sur modele vide renvoie index 0


    @Test
    fun verefieAjouterJoueur2() {
        assertEquals(0, modele.ajouterJoueur("Roman"))
        assertEquals(1, modele.ajouterJoueur("Arthur"))
        assertEquals(2, modele.ajouterJoueur("Luka"))
        assertEquals(3, modele.ajouterJoueur("Isac"))
    }
    //ajouterJoueur remplit les index dans l ordre


    @Test
    fun verefieAjouterJoueur3() {
        modele.ajouterJoueur("Roman")
        modele.ajouterJoueur("Arthur")
        modele.ajouterJoueur("Luka")
        modele.ajouterJoueur("Isac")
        assertEquals(-1, modele.ajouterJoueur("Nicolas"))
    }
    //ajouterJoueur au dela de 4 renvoie -1


    @Test
    fun verefieAjouterJoueur4() {
        modele.ajouterJoueur("Roman")
        modele.ajouterJoueur("Arthur")
        modele.retirerJoueur(0)
        assertEquals(0, modele.ajouterJoueur("Luka"))
    }
    //ajouterJoueur reutilise un index libere

    @Test
    fun verefieAjouterJoueur5() {
        assertEquals(0, modele.ajouterJoueur(""))
    }
    //ajouterJoueur accepte une chaine vide


    @Test
    fun verefieRetirerJoueur1() {
        modele.ajouterJoueur("Roman")
        modele.ajouterJoueur("Arthur")
        modele.retirerJoueur(0)
        assertEquals(listOf("Arthur"), modele.getJoueursValides())
    }
    //retirerJoueur libere effectivement le slot

    @Test
    fun verefieRetirerJoueur12() {
        modele.ajouterJoueur("Roman")
        assertDoesNotThrow {
            modele.retirerJoueur(-1)
            modele.retirerJoueur(4)
            modele.retirerJoueur(100)
        }
        assertEquals(listOf("Roman"), modele.getJoueursValides())
    }
    //retirerJoueur avec index hors borne ne plante pas

    @Test
    fun verefieRetirerJoueur3() {
        modele.ajouterJoueur("Roman") // index 0
        modele.retirerJoueur(2)   // slot 2 deja vide
        assertEquals(listOf("Roman"), modele.getJoueursValides())
    }
    //retirerJoueur sur slot deja vide est sans effet



    @Test
    fun verefieEstPlein1() {
        assertFalse(modele.estPlein())
    }
    //estPlein est faux au depart

    @Test
    fun verefieEstPlein2() {
        modele.ajouterJoueur("Roman")
        modele.ajouterJoueur("Arthur")
        modele.ajouterJoueur("Luka")
        modele.ajouterJoueur("Isac")
        assertTrue(modele.estPlein())
    }
    //estPlein est vrai avec 4 joueurs

    @Test
    fun verefieEstPlein3() {
        modele.ajouterJoueur("Roman")
        modele.ajouterJoueur("Arthur")
        modele.ajouterJoueur("Luka")
        modele.ajouterJoueur("Isac")
        modele.retirerJoueur(1)
        assertFalse(modele.estPlein())
    }
    //estPlein redevient faux apres un retrait



    @Test
    fun verefieGetJoueursValides1() {
        assertTrue(modele.getJoueursValides().isEmpty())
    }
    //getJoueursValides vide au depart

    @Test
    fun verefieGetJoueursValides2() {
        modele.ajouterJoueur("Roman")
        modele.ajouterJoueur("Arthur")
        modele.ajouterJoueur("Luka")
        modele.retirerJoueur(1)
        assertEquals(listOf("Roman", "Luka"), modele.getJoueursValides())
    }
    //getJoueursValides ignore les trous

    @Test
    fun verefieGetJoueursValides3() {
        modele.ajouterJoueur("Roman")
        modele.ajouterJoueur("Arthur")
        modele.ajouterJoueur("Luka")
        modele.ajouterJoueur("Isac")
        assertEquals(listOf("Roman", "Arthur", "Luka", "Isac"), modele.getJoueursValides())
    }
    //getJoueursValides renvoie tous les noms quand plein
}