
import iut.info1.flip7.cartes.Carte3aLaSuite
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class testCarte3aLaSuite {
    val carte = Carte3aLaSuite()
    @Test
    fun testCarte3aLaSuite1(){
        assertTrue(carte.estCarte3aLaSuite())
    }

    @Test
    fun testCarte3aLaSuite2(){
        assertFalse(carte.estCarteNum())
    }


    @Test
    fun testCarte3aLaSuite3(){
        assertFalse(carte.estCarteBonusPlus())
    }

    @Test
    fun testCarte3aLaSuite4(){
        assertFalse(carte.estCarteBonusMultiplie())
    }

    @Test
    fun testCarte3aLaSuite5(){
        assertFalse(carte.estCarteStop())
    }

    @Test
    fun testCarte3aLaSuite6(){
        assertFalse(carte.estCarte2ndeChance())
    }

}