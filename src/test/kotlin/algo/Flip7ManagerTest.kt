package iut.info1.flip7.flip7.modele

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Flip7ManagerTest {

    private lateinit var manager: Flip7Manager

    @BeforeEach
    fun setUp() {
        manager = Flip7Manager()
    }



    @Test
    fun verifieDemarragePartie1() {
        assertNull(manager.partieEnCours)
    }
    //partieEnCours est null au depart


    @Test
    fun verifieDemarragePartie2() {
        manager.demarrerPartie()
        assertNull(manager.partieEnCours)
    }
    //demarrerPartie sans joueur ne cree pas de partie

    @Test
    fun verifieDemarragePartie3() {
        manager.ajouterJoueur("1")
        manager.demarrerPartie()
        assertNull(manager.partieEnCours)
    }
    //demarrerPartie avec un seul joueur ne cree pas de partie


    @Test
    fun verifieDemarragePartie4() {
        manager.ajouterJoueur("Roman")
        manager.ajouterJoueur("Arthur")
        manager.demarrerPartie()
        assertNotNull(manager.partieEnCours)
    }
    //demarrerPartie avec 2 joueurs cree une partie

    @Test
    fun verifieDemarragePartie5() {
        manager.ajouterJoueur("Roman")
        manager.ajouterJoueur("Arthur")
        manager.ajouterJoueur("Luka")
        manager.ajouterJoueur("Isac")
        manager.demarrerPartie()
        assertNotNull(manager.partieEnCours)
    }
    //demarrerPartie avec 4 joueurs cree une partie




    @Test
    fun verifieDemarragePartie6() {

        manager.ajouterJoueur("Roman")
        manager.ajouterJoueur("Arthur")
        manager.ajouterJoueur("Luka")
        manager.ajouterJoueur("Isac")
        manager.ajouterJoueur("Nicolas")
        manager.demarrerPartie()

        val partie = manager.partieEnCours
        assertNotNull(partie)
        assertEquals(4, partie!!.joueurs.size)
    }
    //demarrerPartie avec 4 joueurs au max pour une partie

    @Test
    fun verifieDemarragePartie7() {
        manager.ajouterJoueur("Roman")
        manager.ajouterJoueur("Arthur")
        manager.demarrerPartie()

        val noms = manager.partieEnCours!!.joueurs.map { it.donneNom() }
        assertEquals(listOf("Roman", "Arthur"), noms)
    }
    //les noms des joueurs sont affiches dans la partie




}