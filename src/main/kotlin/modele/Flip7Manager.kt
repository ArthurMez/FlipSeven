package iut.info1.flip7.flip7.modele

import iut.info1.flip7.Flip7
import iut.info1.flip7.Joueur
import iut.info1.flip7.cartes.Carte
import iut.info1.flip7.cartes.Carte2ndeChance
import iut.info1.flip7.cartes.Carte3aLaSuite
import iut.info1.flip7.cartes.CarteBonusMultiplie
import iut.info1.flip7.cartes.CarteBonusPlus
import iut.info1.flip7.cartes.CarteNum
import iut.info1.flip7.cartes.CarteStop

class Flip7Manager {

    // On stocke les joueurs temporairement pendant l'écran d'initialisation
    private var joueursEnAttente = mutableListOf<Joueur>()

    // C'est ici qu'on gardera la vraie partie une fois lancée
    var partieEnCours: Flip7? = null
        private set // Le "private set" empêche les autres classes de modifier cette variable directement

    /**
     * Ajoute un joueur pour la future partie (limité à 4 selon ta maquette).
     */
    fun ajouterJoueur(nom: String) {
        if (joueursEnAttente.size < 4) {
            val nouveauJoueur = Joueur(nom = nom)
            joueursEnAttente.add(nouveauJoueur)
            println("Joueur $nom ajouté !")
        }
    }

    /**
     * Lance la partie si on a assez de joueurs.
     */
    fun demarrerPartie() {
        if (joueursEnAttente.size >= 2) {
            val pioche: List<Carte> = listOf(CarteNum(0), CarteNum(1), CarteNum(2), CarteNum(2), CarteNum(3), CarteNum(3), CarteNum(3), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(4), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(5), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(6), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(7), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(8), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(9), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(10), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(11), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteNum(12), CarteBonusPlus(2), CarteBonusPlus(4), CarteBonusPlus(6), CarteBonusPlus(8), CarteBonusPlus(10), CarteBonusMultiplie(), Carte2ndeChance(), Carte2ndeChance(), Carte2ndeChance(), Carte3aLaSuite(), Carte3aLaSuite(), Carte3aLaSuite(), CarteStop(), CarteStop(), CarteStop())
            partieEnCours = Flip7(joueursEnAttente.size, joueursEnAttente, pioche)

        }
    }
}