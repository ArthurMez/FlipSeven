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
    fun verifieMainPossibleVide(){
        assertDoesNotThrow{outil.verifieMainCorrecte(listOf())}
    }

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
        assertDoesNotThrow { outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5),CarteNum(6),CarteNum(7),CarteNum(8), CarteBonusMultiplie(),CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10),Carte2ndeChance(), Carte2ndeChance(),Carte2ndeChance(),Carte3aLaSuite(),Carte3aLaSuite(),Carte3aLaSuite(), CarteStop())) }
    }

    @Test
    fun verifieMainPossibleDoublonStop(){
        assertThrows<MainInvalideException>{ outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(2), CarteStop())) }
    }

    @Test
    fun verifieMainPossibleDoublonVie(){
        assertThrows<MainInvalideException>{ outil.verifieMainCorrecte(listOf(CarteNum(2),CarteNum(2), Carte2ndeChance())) }
    }

    @Test
    fun verifieMainPossibleFlip7Stop(){
        assertThrows<MainInvalideException>{ outil.verifieMainCorrecte(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteNum(10), CarteNum(7), CarteStop())) }
    }

    @Test
    fun verifieMainPossibleFlip7Doublon(){
        assertThrows<MainInvalideException>{ outil.verifieMainCorrecte(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteNum(10), CarteNum(7), CarteNum(7))) }
    }



    @Test
    fun verifiePiocheInitialeVide(){
        assertThrows<PiocheInvalideException>{ outil.verifiePiocheInitiale(listOf()) }
    }

    @Test
    fun verifiePiocheInitialeValide(){
        assertDoesNotThrow{ outil.verifiePiocheInitiale(listOf(CarteNum(0), CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop(), CarteStop())) }
    }

    @Test
    fun verifiePiocheInitiale93cartes(){
        assertThrows<PiocheInvalideException>{ outil.verifiePiocheInitiale(listOf(CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop(), CarteStop())) }
    }

    @Test
    fun verifiePiocheInitiale95cartes(){
        assertThrows<PiocheInvalideException>{ outil.verifiePiocheInitiale(listOf(CarteNum(0),CarteNum(0), CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop(), CarteStop())) }
    }

    @Test
    fun verifiePiocheInitialeMauvaisNum(){
        assertThrows<PiocheInvalideException>{ outil.verifiePiocheInitiale(listOf(CarteNum(1), CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop(), CarteStop())) }
    }

    @Test
    fun verifiePiocheInitiale2mult_PasDe0(){
        assertThrows<PiocheInvalideException>{ outil.verifiePiocheInitiale(listOf(CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10), CarteBonusMultiplie(), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop(), CarteStop())) }
    }

    @Test
    fun verifiePiocheInitialeDoublonBonus(){
        assertThrows<PiocheInvalideException>{ outil.verifiePiocheInitiale(listOf(CarteNum(0),CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(10), CarteBonusPlus(10), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop(), CarteStop())) }
    }

    @Test
    fun verifiePiocheInitiale2Vie4troisAlaSuite(){
        assertThrows<PiocheInvalideException>{ outil.verifiePiocheInitiale(listOf(CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10), CarteBonusPlus(10), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop(), CarteStop())) }
    }

    @Test
    fun verifiePiocheInitiale2troisAlaSuite4Stop(){
        assertThrows<PiocheInvalideException>{ outil.verifiePiocheInitiale(listOf(CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10), CarteBonusPlus(10), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop(), CarteStop(), CarteStop())) }
    }

    @Test
    fun verifiePiocheInitiale2Stop4Vie(){
        assertThrows<PiocheInvalideException>{ outil.verifiePiocheInitiale(listOf(CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10), CarteBonusPlus(10), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop())) }
    }



    @Test
    fun calculScoreMainInvalide(){
        assertThrows<MainInvalideException>{ outil.calculScore(listOf(CarteNum(2),CarteNum(2),CarteNum(2))) }
    }

    @Test
    fun calculScoreMainValide(){
        assertDoesNotThrow{ outil.calculScore(listOf(CarteNum(2),CarteNum(3))) }
    }

    @Test
    fun calculScore5Num(){
        assertEquals(15,outil.calculScore(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5))) )
    }

    @Test
    fun calculScore5NumDoublon(){
        assertEquals(0,outil.calculScore(listOf(CarteNum(2),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5))) )
    }

    @Test
    fun calculScore5NumPlusCartesSpeciales(){
        assertEquals(15,outil.calculScore(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), Carte3aLaSuite(), CarteStop(), Carte2ndeChance())) )
    }

    @Test
    fun calculScore5NumBonus(){
        assertEquals(17,outil.calculScore(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteBonusPlus(2))) )
    }

    @Test
    fun calculScore5Num5Bonus(){
        assertEquals(45,outil.calculScore(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10))) )
    }

    @Test
    fun calculScore5NumMult(){
        assertEquals(30,outil.calculScore(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteBonusMultiplie())) )
    }

    @Test
    fun calculScore5NumMultBonus(){
        assertEquals(32,outil.calculScore(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteBonusPlus(2), CarteBonusMultiplie())) )
    }

    @Test
    fun calculScoreFlip7(){
        assertEquals(47,outil.calculScore(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteNum(10), CarteNum(7))) )
    }

    @Test
    fun calculScoreFlip7Mult(){
        assertEquals(79,outil.calculScore(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteNum(10), CarteNum(7), CarteBonusMultiplie())) )
    }

    @Test
    fun calculScore5NumDoublonBonus(){
        assertEquals(0,outil.calculScore(listOf(CarteNum(2),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteBonusPlus(2))) )
    }

    @Test
    fun calculScore5NumDoublonMult(){
        assertEquals(0,outil.calculScore(listOf(CarteNum(2),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteBonusMultiplie())) )
    }



    @Test
    fun estFlip7ok(){
        assertTrue(outil.estFlip7(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteNum(10), CarteNum(7))) )
    }

    @Test
    fun estFlip7ok_autresCartes(){
        assertTrue(outil.estFlip7(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteNum(10), CarteNum(7), Carte2ndeChance(), CarteBonusPlus(2), CarteBonusMultiplie(), CarteStop(), Carte3aLaSuite())) )
    }

    @Test
    fun estFlip7non7Num(){
        assertFalse(outil.estFlip7(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteNum(10), CarteNum(10))) )
    }

    @Test
    fun estFlip7non6Num(){
        assertFalse(outil.estFlip7(listOf(CarteNum(1),CarteNum(2),CarteNum(3),CarteNum(4),CarteNum(5), CarteNum(10))) )
    }

}

