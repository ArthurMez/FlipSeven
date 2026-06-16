package iut.info1.flip7

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import iut.info1.flip7.cartes.*
import iut.info1.flip7.exceptions.MainInvalideException
import iut.info1.flip7.exceptions.PiocheInvalideException
import org.junit.jupiter.api.assertThrows

class TestOutilsCarte {
    val outil = OutilsCarte()

    @Test
    fun verifieMainPossible2Mult(){
        assertThrows<MainInvalideException>{outil.verifieMainCorrecte(listOf(CarteBonusMultiplie(), CarteBonusMultiplie()))}
    }

    @Test
    fun verifieMainPossible2BonusEgaux(){
        assertThrows<MainInvalideException>{outil.verifieMainCorrecte(listOf(CarteBonusPlus(2), CarteBonusPlus(2)))}
    }

    @Test
    fun verifieMainPossible5Bonus(){
        assertDoesNotThrow { outil.verifieMainCorrecte(listOf(CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10))) }
    }

    @Test
    fun verifieMainPossible4vie(){
        assertThrows<MainInvalideException>{outil.verifieMainCorrecte(listOf(Carte2ndeChance(), Carte2ndeChance(),Carte2ndeChance(),Carte2ndeChance()))}
    }

    @Test
    fun verifieMainPossible4troisALaSuite(){
        assertThrows<MainInvalideException>{outil.verifieMainCorrecte(listOf(Carte3aLaSuite(),Carte3aLaSuite(),Carte3aLaSuite(),Carte3aLaSuite()))}
    }

    @Test
    fun verifieMainPossible2Stop(){
        assertThrows<MainInvalideException>{outil.verifieMainCorrecte(listOf(CarteStop(),CarteStop()))}
    }

    @Test
    fun verifieMainPossible7numOk(){
        assertDoesNotThrow { outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5),CarteNum(6),CarteNum(7),CarteNum(8))) }
    }

    @Test
    fun verifieMainPossible8num(){
        assertThrows<MainInvalideException>{outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5),CarteNum(6),CarteNum(7),CarteNum(8),CarteNum(9)))}
    }

    @Test
    fun verifieMainPossible8numDoublon(){
        assertThrows<MainInvalideException>{outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(2),CarteNum(4),CarteNum(5),CarteNum(6),CarteNum(7),CarteNum(8),CarteNum(9)))}
    }

    @Test
    fun verifieMainPossible5num1doublon(){
        assertDoesNotThrow { outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(2),CarteNum(4),CarteNum(5),CarteNum(6))) }
    }

    @Test
    fun verifieMainPossible5num2doublon(){
        assertThrows<MainInvalideException>{ outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(2),CarteNum(4),CarteNum(4),CarteNum(6))) }
    }

    @Test
    fun verifieMainPossibleMaxCartes(){
        assertDoesNotThrow { outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5),CarteNum(6),CarteNum(7),CarteNum(8),
            CarteBonusMultiplie(),CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10),Carte2ndeChance(), Carte2ndeChance(),Carte2ndeChance(),Carte3aLaSuite(),Carte3aLaSuite(),Carte3aLaSuite(),
            CarteStop())) }
    }

    @Test
    fun verifieMainPossibleDoublonStop(){
        assertThrows<MainInvalideException>{ outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(2), CarteStop())) }
    }


}