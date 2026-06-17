import iut.info1.flip7.cartes.CarteBonusPlus
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class testCarteBonusPlus {
    val carte = CarteBonusPlus(2)
    @Test
    fun testCarteBonusPlus1(){
        assertTrue(carte.estCarteBonusPlus())
    }

    @Test
    fun testCarteBonusvaleur1(){
        assertThrows<IllegalArgumentException>{ CarteBonusPlus(3) }
    }

    @Test
    fun testCarteBonusvaleur2(){
        assertDoesNotThrow {CarteBonusPlus(2)  }
    }

    @Test
    fun testCarteBonusPlus2(){
        assertFalse(carte.estCarteNum())
    }


    @Test
    fun testCarteBonusPlus3(){
        assertFalse(carte.estCarte3aLaSuite())
    }

    @Test
    fun testCarteBonusPlus4(){
        assertFalse(carte.estCarteBonusMultiplie())
    }

    @Test
    fun testCarteBonusPlus5(){
        assertFalse(carte.estCarteStop())
    }

    @Test
    fun testCarteBonusPlus6(){
        assertFalse(carte.estCarte2ndeChance())
    }

}