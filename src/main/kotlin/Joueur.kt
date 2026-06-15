package iut.info1.flip7

class Joueur(val nom: String): IJoueur {

    override fun donneNom(): String {
        return nom
    }
}