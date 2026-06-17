package iut.info1.flip7

import iut.info1.flip7.cartes.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class testsEquals {

    @Test
    fun testCarteNum1() {
        val c1 = CarteNum(5)
        val c2 = CarteNum(5)
        assertTrue(c1 == c2)
    }

    @Test
    fun testCarteNum2() {
        val c1 = CarteNum(5)
        val c2 = CarteNum(3)
        assertFalse(c1 == c2)
    }

    @Test
    fun testCarteNum3() {
        val c1 = CarteNum(0)
        val c2 = CarteNum(0)
        assertTrue(c1 == c2)
    }

    @Test
    fun testCarteNum4() {
        val c1 = CarteNum(5)
        val c2 = CarteBonusPlus(4)
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarteNum5() {
        val c1 = CarteNum(5)
        val c2: Any? = null
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarteBonusPlus1() {
        val c1 = CarteBonusPlus(4)
        val c2 = CarteBonusPlus(4)
        assertTrue(c1 == c2)
    }

    @Test
    fun testCarteBonusPlus2() {
        val c1 = CarteBonusPlus(4)
        val c2 = CarteBonusPlus(6)
        assertFalse(c1 == c2)
    }

    @Test
    fun testCarteBonusPlus3() {
        val c1 = CarteBonusPlus(4)
        val c2 = CarteNum(4)
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarteBonusPlu4() {
        val c1 = CarteBonusPlus(4)
        val c2: Any? = null
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarteBonusMul1() {
        val c1 = CarteBonusMultiplie()
        val c2 = CarteBonusMultiplie()
        assertTrue(c1 == c2)
    }

    @Test
    fun testCarteBonusMul2() {
        val c1 = CarteBonusMultiplie()
        val c2 = CarteNum(2)
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarteBonusMul3() {
        val c1 = CarteBonusMultiplie()
        val c2: Any? = null
        assertFalse(c1.equals(c2))
    }


    @Test
    fun testCarteStop1() {
        val c1 = CarteStop()
        val c2 = CarteStop()
        assertTrue(c1 == c2)
    }

    @Test
    fun testCarteStop2() {
        val c1 = CarteStop()
        val c2 = Carte2ndeChance()
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarteStop3() {
        val c1 = CarteStop()
        val c2: Any? = null
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarteChance1() {
        val c1 = Carte2ndeChance()
        val c2 = Carte2ndeChance()
        assertTrue(c1 == c2)
    }

    @Test
    fun testCarteChance2() {
        val c1 = Carte2ndeChance()
        val c2 = CarteStop()
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarteChance3() {
        val c1 = Carte2ndeChance()
        val c2: Any? = null
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarte3aLaSuite1() {
        val c1 = Carte3aLaSuite()
        val c2 = Carte3aLaSuite()
        assertTrue(c1 == c2)
    }

    @Test
    fun testCarte3aLaSuite2() {
        val c1 = Carte3aLaSuite()
        val c2 = CarteStop()
        assertFalse(c1.equals(c2))
    }

    @Test
    fun testCarte3aLaSuite3() {
        val c1 = Carte3aLaSuite()
        val c2: Any? = null
        assertFalse(c1.equals(c2))
    }
}