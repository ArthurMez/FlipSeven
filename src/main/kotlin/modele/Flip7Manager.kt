package iut.info1.flip7.flip7.modele

import iut.info1.flip7.Flip7
import iut.info1.flip7.Joueur

class Flip7Manager {

    // On stocke les joueurs temporairement pendant l'écran d'initialisation
    private val joueursEnAttente = mutableListOf<Joueur>()

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
            // Il faudra ajuster cette ligne avec les vrais paramètres obligatoires de ton constructeur Flip7
            // partieEnCours = Flip7(nbJoueurs = joueursEnAttente.size, joueurs = joueursEnAttente, ...)

            println("La partie commence avec ${joueursEnAttente.size} joueurs !")
        } else {
            println("Impossible de démarrer, il faut au moins 2 joueurs.")
        }
    }
}