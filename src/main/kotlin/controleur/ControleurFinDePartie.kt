package controleur

import Flip7Main
import iut.info1.flip7.flip7.controleur.ControleurInitialisation
import iut.info1.flip7.flip7.vue.InitialisationVue
import javafx.application.Platform
import vue.FinPartieVue

class ControleurFinDePartie(private val vue: FinPartieVue, private val application: Flip7Main) {
    init {
        vue.btnQuitter.setOnAction {
            Platform.exit()
        }
        vue.btnRejouer.setOnAction {
            val vueInitialisation = InitialisationVue()
            ControleurInitialisation(vueInitialisation, application)
            application.changerVue(vueInitialisation)
        }
    }
}