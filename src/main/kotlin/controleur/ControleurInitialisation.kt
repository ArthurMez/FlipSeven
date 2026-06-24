package iut.info1.flip7.flip7.controleur

import iut.info1.flip7.flip7.modele.ModeleInitialisation
import iut.info1.flip7.flip7.vue.InitialisationVue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button

class ControleurAjouterJoueur(private val modele: ModeleInitialisation, private val vue: InitialisationVue) : EventHandler<ActionEvent> {

    override fun handle(event: ActionEvent) {
        val nom = vue.getNomSaisi()
        if (nom != "" && !modele.estPlein()) {
            val index = modele.ajouterJoueur(nom)
            if (index >= 0) {
                vue.mettreAJourAffichageJoueur(index, nom)
                vue.clearInput()
            }
        }
    }
}

class ControleurSupprimerJoueur(private val modele: ModeleInitialisation, private val vue: InitialisationVue) : EventHandler<ActionEvent> {

    override fun handle(event: ActionEvent) {
        val btn = event.source as? Button ?: return
        val index = vue.getIndexBouton(btn)
        if (index >= 0) {
            modele.retirerJoueur(index)
            vue.mettreAJourAffichageJoueur(index, null)
        }
    }
}