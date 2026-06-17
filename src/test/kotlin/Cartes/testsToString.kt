package iut.info1.flip7

import iut.info1.flip7.cartes.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class testsToString {

    @Test
    fun testToString_CT1() {
        val carte = CarteNum(0)
        assertEquals("[Carte n°0]", carte.toString())
    }

    @Test
    fun testToString_CT2() {
        val carte = CarteNum(5)
        assertEquals("[Carte n°5]", carte.toString())
    }

    @Test
    fun testToString_CT3() {
        val carte = CarteNum(12)
        assertEquals("[Carte n°12]", carte.toString())
    }

    @Test
    fun testToString_CT4() {
        val carte = CarteBonusPlus(2)
        assertEquals("[Carte Bonus +2]", carte.toString())
    }

    @Test
    fun testToString_CT5() {
        val carte = CarteBonusPlus(10)
        assertEquals("[Carte Bonus +10]", carte.toString())
    }

    @Test
    fun testToString_CT6() {
        val carte = CarteBonusMultiplie()
        assertEquals("[Carte Bonus x2]", carte.toString())
    }

    @Test
    fun testToString_CT7() {
        val carte = CarteStop()
        assertEquals("[Carte Stop]", carte.toString())
    }

    @Test
    fun testToString_CT8() {
        val carte = Carte2ndeChance()
        assertEquals("[Carte 2nde chance]", carte.toString())
    }

    @Test
    fun testToString_CT9() {
        val carte = Carte3aLaSuite()
        assertEquals("[Carte 3 à la suite]", carte.toString())
    }
}
