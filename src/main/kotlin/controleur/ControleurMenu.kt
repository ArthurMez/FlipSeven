package iut.info1.flip7.flip7.controleur

import Flip7Main
import iut.info1.flip7.flip7.vue.MenuPrincipalVue
import iut.info1.flip7.flip7.vue.ReglesVue
import iut.info1.flip7.flip7.vue.InitialisationVue
import javafx.application.Platform

class ControleurMenu(
     vue: MenuPrincipalVue,
     application: Flip7Main
) {

    init {
        vue.boutonRegles.setOnAction {
            val vueRegles = ReglesVue()
            ControleurRegles(vueRegles, application)
            application.changerVue(vueRegles)
        }

        vue.boutonPartie.setOnAction {
            val vueInitialisation = InitialisationVue()
            ControleurInitialisation(vueInitialisation, application)
            application.changerVue(vueInitialisation)
        }

        vue.boutonQuitter.setOnAction {
            Platform.exit()
        }
    }
}