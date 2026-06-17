package iut.info1.flip7.Cartes

import iut.info1.flip7.cartes.CarteBonusMultiplie
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class testCarteBonusMultiplie{
    val carte = CarteBonusMultiplie()
    @Test
    fun testCarteBonusMultiplie1(){
        assertTrue(carte.estCarteBonusMultiplie())
    }

    @Test
    fun testCarteBonusMultiplie2(){
        assertFalse(carte.estCarteNum())
    }


    @Test
    fun testCarteBonusMultiplie3(){
        assertFalse(carte.estCarteBonusPlus())
    }

    @Test
    fun testCarteBonusMultiplie4(){
        assertFalse(carte.estCarteStop())
    }

    @Test
    fun testCarteBonusMultiplie5(){
        assertFalse(carte.estCarte3aLaSuite())
    }

    @Test
    fun testCarteBonusMultiplie6(){
        assertFalse(carte.estCarte2ndeChance())
    }

}