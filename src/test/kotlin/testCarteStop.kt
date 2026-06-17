import iut.info1.flip7.cartes.CarteStop
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class testCarteStop {
    val carte = CarteStop()
    @Test
    fun testCarteStop1(){
        assertTrue(carte.estCarteStop())
    }

    @Test
    fun testCarteStop2(){
        assertFalse(carte.estCarteNum())
    }


    @Test
    fun testCarteStop3(){
        assertFalse(carte.estCarteBonusPlus())
    }

    @Test
    fun testCarteStop4(){
        assertFalse(carte.estCarteBonusMultiplie())
    }

    @Test
    fun testCarteStop5(){
        assertFalse(carte.estCarte3aLaSuite())
    }

    @Test
    fun testCarteStop6(){
        assertFalse(carte.estCarte2ndeChance())
    }

}