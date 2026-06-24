package iut.info1.flip7.flip7.modele

class Flip7Manager {
}


class ModeleInitialisation {
    private val nomsJoueurs = arrayOfNulls<String>(4)

    fun ajouterJoueur(nom: String): Int {
        for (i in nomsJoueurs.indices) {
            if (nomsJoueurs[i] == null) {
                nomsJoueurs[i] = nom
                return i
            }
        }
        return -1
    }

    fun retirerJoueur(index: Int) {
        if (index in 0..3) {
            nomsJoueurs[index] = null
        }
    }

    fun estPlein(): Boolean = nomsJoueurs.all { it != null }

}