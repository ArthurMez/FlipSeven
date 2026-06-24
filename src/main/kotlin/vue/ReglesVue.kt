package iut.info1.flip7.flip7.vue
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment


class ReglesVue : BorderPane() {

    val boutonRetour = Button("←")

    init {

        boutonRetour.style = "-fx-background-radius: 50; -fx-min-width: 42; -fx-min-height: 42;"

        val titre = Label("Règles Flip 7")
        titre.font = Font.font("Arial", FontWeight.NORMAL, 22.0)

        val barreHaut = BorderPane()
        barreHaut.left = boutonRetour
        barreHaut.center = titre
        barreHaut.padding = Insets(12.0)
        barreHaut.style = "-fx-background-color: #6a6bb5;"
        this.top = barreHaut


        val contenu = VBox(20.0)
        contenu.padding = Insets(20.0, 30.0, 30.0, 30.0)
        contenu.alignment = Pos.CENTER



        val text1 = Label("Principe du jeu\n\nDans Flip 7, vous jouez manche après manche jusqu'à ce que l'un des joueurs atteigne 200 points et remporte la partie ! À chaque manche, collectionnez des cartes pour marquer autant de points que leur valeur totale. Mais vous devrez savoir dire STOP avant de recevoir un numéro que vous avez déjà ! Sinon, vous sautez et quittez la manche sans gagner de point. Si vous collectionnez 7 cartes Numéro différentes, vous réalisez un Flip 7 : vous mettez fin à la manche et gagnez 15 points supplémentaires.")
        text1.isWrapText = true
        text1.maxWidth = 850.0
        text1.textAlignment = TextAlignment.LEFT
        text1.alignment = Pos.CENTER_LEFT
        text1.style = "-fx-background-color: #9fa0d8; -fx-text-fill: black; -fx-padding: 22 22 22 22; -fx-font-size: 20px;"
        contenu.children.add(text1)

        val text2 = Label("Les cartes\n\nLe paquet contient 79 cartes Numéro (douze 12, onze 11, dix 10… jusqu'à un seul 1) et un seul 0. La carte 0 est une carte Numéro ne valant pas de point. Il y a aussi 6 cartes Bonus (+2, +4, +6, +8, +10 et x2) et 9 cartes Spéciales : Stop, Seconde Chance et Trois à la suite, en 3 exemplaires chacune.")
        text2.isWrapText = true
        text2.maxWidth = 850.0
        text2.textAlignment = TextAlignment.LEFT
        text2.alignment = Pos.CENTER_LEFT
        text2.style = "-fx-background-color: #9fa0d8; -fx-text-fill: black; -fx-padding: 22 22 22 22; -fx-font-size: 20px;"
        contenu.children.add(text2)

        val text3 = Label("Mise en place\n\nMélangez le paquet de cartes. Désignez aléatoirement un joueur qui sera le Donneur lors de la première manche. Si vous jouez à plus de 18 personnes, il est recommandé d'utiliser un second paquet.")
        text3.isWrapText = true
        text3.maxWidth = 850.0
        text3.textAlignment = TextAlignment.LEFT
        text3.alignment = Pos.CENTER_LEFT
        text3.style = "-fx-background-color: #9fa0d8; -fx-text-fill: black; -fx-padding: 22 22 22 22; -fx-font-size: 20px;"
        contenu.children.add(text3)

        val text4 = Label("Comment jouer ?\n\nEn commençant par le joueur à sa gauche puis dans le sens des aiguilles d'une montre, le Donneur offre un choix à chaque joueur : STOP ou ENCORE. STOP : vous sortez de la manche, retournez vos cartes face cachée et ajouterez vos points en fin de manche. ENCORE : le Donneur vous distribue une nouvelle carte face visible.\n\nSi vous recevez un Numéro non possédé, vous restez dans la manche. Si vous recevez un Numéro déjà possédé, vous sautez sans aucun point. Avec 7 cartes Numéro différentes, vous réalisez un Flip 7 : la manche s'arrête pour tous et vous gagnez 15 points.\n\nPlacez vos Numéros en ligne devant vous. Un Bonus se place au-dessus : il compte si vous sortez, pas si vous sautez. Les Bonus ne sont pas des Numéros. Une carte Spéciale doit être appliquée.")
        text4.isWrapText = true
        text4.maxWidth = 850.0
        text4.textAlignment = TextAlignment.LEFT
        text4.alignment = Pos.CENTER_LEFT
        text4.style = "-fx-background-color: #9fa0d8; -fx-text-fill: black; -fx-padding: 22 22 22 22; -fx-font-size: 20px;"
        contenu.children.add(text4)

        val text5 = Label("Fin de manche\n\nLa manche continue jusqu'à ce que tous les joueurs soient sortis, ou qu'un joueur réalise un Flip 7. Pour le score : totalisez vos cartes Numéro, doublez si vous avez le x2, ajoutez les autres Bonus, puis 15 points si Flip 7.")
        text5.isWrapText = true
        text5.maxWidth = 850.0
        text5.textAlignment = TextAlignment.LEFT
        text5.alignment = Pos.CENTER_LEFT
        text5.style = "-fx-background-color: #9fa0d8; -fx-text-fill: black; -fx-padding: 22 22 22 22; -fx-font-size: 20px;"
        contenu.children.add(text5)

        val text6 = Label("Nouvelle manche & paquet vide\n\nMettez de côté les cartes utilisées sans les remélanger. Le Donneur passe le paquet au joueur à sa gauche, qui devient le nouveau Donneur. Quand le paquet est vide, mélangez toutes les défausses pour reformer un paquet.")
        text6.isWrapText = true
        text6.maxWidth = 850.0
        text6.textAlignment = TextAlignment.LEFT
        text6.alignment = Pos.CENTER_LEFT
        text6.style = "-fx-background-color: #9fa0d8; -fx-text-fill: black; -fx-padding: 22 22 22 22; -fx-font-size: 20px;"
        contenu.children.add(text6)

        val text7 = Label("Fin de la partie\n\nEn fin de manche, si au moins un joueur atteint 200 points, la partie s'arrête. Le joueur au score le plus élevé gagne. En cas d'égalité, jouez une manche supplémentaire pour départager.")
        text7.isWrapText = true
        text7.maxWidth = 850.0
        text7.textAlignment = TextAlignment.LEFT
        text7.alignment = Pos.CENTER_LEFT
        text7.style = "-fx-background-color: #9fa0d8; -fx-text-fill: black; -fx-padding: 22 22 22 22; -fx-font-size: 20px;"
        contenu.children.add(text7)

        val text8 = Label("Cartes spéciales\n\nStop : ciblez un joueur encore en jeu, il sort immédiatement (il garde ses points). Seul restant, vous devez vous cibler vous-même.\n\nSeconde Chance : gardez-la devant vous. Si un Numéro vous ferait sauter, défaussez-le avec elle pour rester en jeu. Une seule par joueur. Toutes sont défaussées en fin de manche.\n\nTrois à la suite : ciblez un joueur (vous compris). Le Donneur lui distribue les 3 prochaines cartes. Arrêtez s'il saute ou fait un Flip 7.")
        text8.isWrapText = true
        text8.maxWidth = 850.0
        text8.textAlignment = TextAlignment.LEFT
        text8.alignment = Pos.CENTER_LEFT
        text8.style = "-fx-background-color: #9fa0d8; -fx-text-fill: black; -fx-padding: 22 22 22 22; -fx-font-size: 20px;"
        contenu.children.add(text8)

        val text9 = Label("Cartes bonus\n\nLes cartes +2, +4, +6, +8 et +10 ajoutent leur valeur. La carte x2 double les points des cartes Numéro, mais pas ceux des Bonus ni les 15 points d'un Flip 7.")
        text9.isWrapText = true
        text9.maxWidth = 850.0
        text9.textAlignment = TextAlignment.LEFT
        text9.alignment = Pos.CENTER_LEFT
        text9.style = "-fx-background-color: #9fa0d8; -fx-text-fill: black; -fx-padding: 22 22 22 22; -fx-font-size: 20px;"
        contenu.children.add(text9)


        val scroll = ScrollPane(contenu)
        scroll.isFitToWidth = true


        this.center = scroll
        this.style = "-fx-background-color: #d4d4d4;"
    }
}