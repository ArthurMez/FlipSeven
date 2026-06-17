package iut.info1.flip7

import iut.info1.flip7.Flip7
import iut.info1.flip7.Joueur
import iut.info1.flip7.cartes.Carte
import iut.info1.flip7.cartes.Carte2ndeChance
import iut.info1.flip7.cartes.Carte3aLaSuite
import iut.info1.flip7.cartes.CarteBonusMultiplie
import iut.info1.flip7.cartes.CarteBonusPlus
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.cartes.CarteStop

import iut.info1.flip7.exceptions.ScoreFinPartieInvalideException
import iut.info1.flip7.exceptions.NombreJoueursInvalideException
import iut.info1.flip7.exceptions.ListeJoueursInvalideException
import iut.info1.flip7.exceptions.PiocheInvalideException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class TestConstructorFlip7 {
    val piocheValide : List<Carte> = listOf(
        CarteNum(0),
        CarteNum(1),
        CarteNum(2), CarteNum(2),
        CarteNum(3), CarteNum(3), CarteNum(3),
        CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4),
        CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5),
        CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6),
        CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7),
        CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8),
        CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9),
        CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10),
        CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11),
        CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12),
        CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10),
        CarteBonusMultiplie(),
        Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(),
        Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(),
        CarteStop(), CarteStop(), CarteStop()
    )
    val piocheInvalide : List<Carte> = listOf(
        CarteNum(0),
        CarteNum(1),
        CarteNum(2), CarteNum(2),
        CarteNum(3), CarteNum(3), CarteNum(3),
        CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4),
        CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5),
        CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6),
        CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7),
        CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8),
        CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9),
        CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10),
        CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11),
        CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12),
        CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8),
        CarteBonusMultiplie(),
        Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(),
        Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(),
        CarteStop(), CarteStop()
    )
    val piocheInvalide2 : List<Carte> = listOf(

    )
    val joueursValide : List<Joueur> = listOf(Joueur("Nicolas"),Joueur("Arthur"), Joueur("Mathis"))
    val joueurInvalide : List<Joueur> = listOf(Joueur("Nicolas"),Joueur("Arthur"), Joueur("Mathis"),Joueur("Nicolas"),Joueur("Arthur"), Joueur("Mathis"))
    @Test
    fun TestFlip7(){
        assertDoesNotThrow("Sa marche"){
            Flip7(3,joueursValide,piocheValide)
        }
    }
    @Test
    fun ct1ListeJoueursInvalideException(){
        assertThrows<ListeJoueursInvalideException> { Flip7(2,joueursValide,piocheValide) }
    }
    @Test
    fun ct1ListeJoueursInvalideException2(){
        assertThrows<ListeJoueursInvalideException> { Flip7(4,joueursValide,piocheValide) }
    }
    @Test
    fun ct2NombreJoueursInvalideException(){
        assertThrows<NombreJoueursInvalideException> { Flip7(6,joueurInvalide,piocheValide) }
    }
    @Test
    fun ct2NombreJoueursInvalideException2(){
        assertThrows<NombreJoueursInvalideException> { Flip7(0,joueurInvalide,piocheValide) }
    }
    @Test
    fun ct3PiocheInvalideException(){
        assertThrows<PiocheInvalideException> { Flip7(3,joueursValide,piocheInvalide) }
    }
    @Test
    fun ct3PiocheInvalideException2(){
        assertThrows<PiocheInvalideException> { Flip7(3,joueursValide,piocheInvalide2) }
    }
    @Test
    fun ct4ScoreFinPartieInvalideException(){
        assertThrows<ScoreFinPartieInvalideException> { Flip7(3,joueursValide,piocheValide,false,0) }
    }
    @Test
    fun ct4ScoreFinPartieInvalideException2(){
        assertThrows<ScoreFinPartieInvalideException> { Flip7(3,joueursValide,piocheValide,false,300) }
    }
}