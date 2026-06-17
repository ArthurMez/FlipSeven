import iut.info1.flip7.cartes.Carte2ndeChance
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class testCarte2ndeChance {
    val carte = Carte2ndeChance()
    @Test
    fun test2ndChance1(){
        assertTrue(carte.estCarte2ndeChance())
    }

    @Test
    fun test2ndChance2(){
        assertFalse(carte.estCarteNum())
    }


    @Test
    fun test2ndChance3(){
        assertFalse(carte.estCarteBonusPlus())
    }

    @Test
    fun test2ndChance4(){
        assertFalse(carte.estCarteBonusMultiplie())
    }

    @Test
    fun test2ndChance5(){
        assertFalse(carte.estCarteStop())
    }

    @Test
    fun test2ndChance6(){
        assertFalse(carte.estCarte3aLaSuite())
    }

}