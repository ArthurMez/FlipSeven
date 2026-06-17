import iut.info1.flip7.cartes.CarteNum
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class testCarteNum {
    val carte = CarteNum(2)
    @Test
    fun testCarteNumvaleur1(){
        assertThrows<IllegalArgumentException>{ CarteNum(20) }
    }

    @Test
    fun testCarteNumvaleur2(){
        assertDoesNotThrow {CarteNum(5)  }
    }

    @Test
    fun testCarteNum1(){
        assertTrue(carte.estCarteNum())
    }



    @Test
    fun testCarteNum2(){
        assertFalse(carte.estCarteBonusPlus())
    }


    @Test
    fun testCarteNum3(){
        assertFalse(carte.estCarte3aLaSuite())
    }

    @Test
    fun testCarteNum4(){
        assertFalse(carte.estCarteBonusMultiplie())
    }

    @Test
    fun testCarteNum5(){
        assertFalse(carte.estCarteStop())
    }

    @Test
    fun testCarteNum6(){
        assertFalse(carte.estCarte2ndeChance())
    }

}