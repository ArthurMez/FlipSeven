package iut.info1.flip7

class JoueurTest(val nom: String): IJoueur {

    override fun donneNom(): String {
        return nom
    }
}