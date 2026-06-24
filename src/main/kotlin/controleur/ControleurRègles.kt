package iut.info1.flip7.flip7.controleur

import Flip7Main
import iut.info1.flip7.flip7.vue.MenuPrincipalVue
import iut.info1.flip7.flip7.vue.ReglesVue

class ControleurRegles(
    vue: ReglesVue,
    application: Flip7Main
) {
    init {
        vue.boutonRetour.setOnAction {
            val menuVue = MenuPrincipalVue()
            ControleurMenu(menuVue, application)
            application.changerVue(menuVue)
        }
    }
}