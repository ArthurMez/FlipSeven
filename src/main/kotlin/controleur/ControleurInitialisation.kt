package iut.info1.flip7.flip7.controleur

import Flip7Main
import iut.info1.flip7.flip7.modele.Flip7Manager
import iut.info1.flip7.flip7.modele.ModeleInitialisation
import iut.info1.flip7.flip7.vue.DeroulementPartieVue
import iut.info1.flip7.flip7.vue.InitialisationVue
import iut.info1.flip7.flip7.vue.MenuPrincipalVue
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

class ControleurInitialisation(
    vue: InitialisationVue,
    application: Flip7Main
) {
    init {

        val modeleInitialisation = ModeleInitialisation()
        val modeleFlip7 = Flip7Manager()


        val controleurAjouter = ControleurAjouterJoueur(modeleInitialisation, vue)
        vue.fixeControleurBoutonAjouter(controleurAjouter)


        val controleurSupprimer = ControleurSupprimerJoueur(modeleInitialisation, vue)
        vue.fixeControleurBoutonSupprimer(controleurSupprimer)

        vue.boutonRetour.setOnAction {
            val menuVue = MenuPrincipalVue()
            ControleurMenu(menuVue, application)
            application.changerVue(menuVue)
        }

        vue.boutonDemarrer.setOnAction {
            val menuJeu = DeroulementPartieVue()
            ControleurJeu(menuJeu, modeleFlip7)
            application.changerVue(menuJeu)
        }
    }
}
