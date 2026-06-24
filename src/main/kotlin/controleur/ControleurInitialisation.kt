package iut.info1.flip7.flip7.controleur

import Flip7Main
import iut.info1.flip7.flip7.vue.MenuPrincipalVue
import iut.info1.flip7.flip7.vue.InitialisationVue

class ControleurInitialisation(
    vue: InitialisationVue,
    application: Flip7Main
) {
    init {
        // Quand on clique sur retour, on recrée le menu principal et son contrôleur
        vue.boutonRetour.setOnAction {
            val menuVue = MenuPrincipalVue()
            ControleurMenu(menuVue, application)
            application.changerVue(menuVue)
        }
    }
}