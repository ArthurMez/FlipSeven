package iut.info1.flip7
import iut.info1.flip7.cartes.Carte2ndeChance
import iut.info1.flip7.cartes.Carte3aLaSuite
import iut.info1.flip7.cartes.CarteBonusMultiplie
import iut.info1.flip7.cartes.CarteBonusPlus
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.cartes.CarteStop
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class testsCompareTo {

    @Test
    fun carteCompareToTest(){
        val c1 = CarteNum(0)
        val c2 = CarteNum(12)
        assertTrue(c1 < c2)
    }

    @Test
    fun carteCompareToTest2(){
        val c1 = CarteNum(6)
        val c2 = CarteNum(6)
        assertTrue(c1 == c2)
    }

    @Test
    fun carteCompareToTest3(){
        val c1 = CarteNum(12)
        val c2 = CarteNum(0)
        assertTrue(c1 > c2)
    }

    @Test
    fun carteCompareToTest4(){
        val c1 = CarteNum(6)
        val c2 = CarteBonusMultiplie()
        assertTrue(c1 < c2)
    }

    @Test
    fun carteCompareToTest5(){
        val c1 = CarteBonusMultiplie()
        val c2 = CarteBonusMultiplie()
        assertTrue(c1 == c2)
    }

    @Test
    fun carteCompareToTest6(){
        val c1 = CarteBonusMultiplie()
        val c2 = CarteBonusPlus(2)
        assertTrue(c1 < c2)
    }

    @Test
    fun carteCompareToTest7(){
        val c1 = CarteBonusPlus(2)
        val c2 = CarteBonusPlus(10)
        assertTrue(c1 < c2)
    }

    @Test
    fun carteCompareToTest8(){
        val c1 = CarteBonusPlus(10)
        val c2 = Carte2ndeChance()
        assertTrue(c1 < c2)
    }

    @Test
    fun carteCompareToTest9(){
        val c1 = Carte2ndeChance()
        val c2 = Carte2ndeChance()
        assertTrue(c1 == c2)
    }

    @Test
    fun carteCompareToTest10(){
        val c1 = Carte3aLaSuite()
        val c2 = Carte2ndeChance()
        assertTrue(c1 > c2)
    }

    @Test
    fun carteCompareToTest11(){
        val c1 = CarteStop()
        val c2 = CarteStop()
        assertTrue(c1 == c2)
    }

    @Test
    fun carteCompareToTest12(){
        val c1 = CarteStop()
        val c2 = CarteNum(0)
        assertTrue(c1 > c2)
    }

}