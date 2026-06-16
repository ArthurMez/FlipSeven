package iut.info1.flip7
import iut.info1.flip7.cartes.Carte2ndeChance
import iut.info1.flip7.cartes.Carte3aLaSuite
import iut.info1.flip7.cartes.CarteBonusMultiplie
import iut.info1.flip7.cartes.CarteBonusPlus
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.cartes.CarteStop
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class testsEquals {

    @Test
    fun testEquals() {
        var c1 = CarteNum(5)
        var c2 = CarteNum(5)
        assertTrue(c1 == c2)
    }

    @Test
    fun testEquals1() {
        var c1 = CarteNum(5)
        var c2 = CarteNum(3)
        assertTrue(c1 != c2)
    }

    @Test
    fun testEquals2() {
        var c1 = CarteNum(0)
        var c2 = CarteNum(0)
        assertTrue(c1 == c2)
    }

    @Test
    fun testEquals3() {
        var c1 = CarteNum(5)
        var c2 = CarteBonusPlus(4)
        assertTrue(c1 != c2)
    }

    @Test
    fun testEquals4() {
        var c1 = CarteNum(5)
        var c2 = null
        assertTrue(c1 != c2)
    }

}