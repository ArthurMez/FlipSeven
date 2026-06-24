package iut.info1.flip7.flip7.vue
import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.stage.Stage


class ReglesVue(root: BorderPane) : BorderPane() {

    val boutonRetour = Button("←")

    init {

        val titre = Label("Règles Flip 7")
        titre.font = Font.font("Arial", FontWeight.NORMAL, 22.0)

        boutonRetour.style = "-fx-background-radius: 50; -fx-min-width: 42; -fx-min-height: 42;"




        val barreHaut = BorderPane()
        barreHaut.left = boutonRetour
        barreHaut.center = titre
        barreHaut.padding = Insets(12.0)
        this.top = barreHaut


        val contenu = VBox(20.0)
        contenu.padding = Insets(20.0, 30.0, 30.0, 30.0)


        contenu.children.add(creerTitre("Principe du jeu"))
        contenu.children.add(creerBloc(
            "Dans Flip 7, vous jouez manche après manche jusqu'à ce que l'un des " +
                    "joueurs atteigne 200 points et remporte la partie ! À chaque manche, " +
                    "collectionnez des cartes pour marquer autant de points que leur valeur " +
                    "totale. Mais vous devrez savoir dire STOP avant de recevoir un numéro " +
                    "que vous avez déjà ! Sinon, vous sautez et quittez la manche sans gagner " +
                    "de point. Plus une carte a un numéro élevé, plus il y en a dans la pioche. " +
                    "Si vous parvenez à collectionner 7 cartes Numéro différentes, vous réalisez " +
                    "un Flip 7 : vous mettez fin à la manche et gagnez 15 points supplémentaires."
        ))


        contenu.children.add(creerTitre("Les cartes"))
        contenu.children.add(creerBloc(
            "Le paquet contient 79 cartes Numéro (douze 12, onze 11, dix 10… jusqu'à " +
                    "un seul 1) et un seul 0. La carte 0 est une carte Numéro ne valant pas de " +
                    "point. Il y a aussi 6 cartes Bonus (+2, +4, +6, +8, +10 et x2) et 9 cartes " +
                    "Spéciales : Stop, Seconde Chance et Trois à la suite, en 3 exemplaires chacune."
        ))


        contenu.children.add(creerTitre("Mise en place"))
        contenu.children.add(creerBloc(
            "Mélangez le paquet de cartes. Désignez aléatoirement un joueur qui sera le " +
                    "Donneur lors de la première manche. Si vous jouez à plus de 18 personnes, " +
                    "il est recommandé d'utiliser un second paquet."
        ))


        contenu.children.add(creerTitre("Comment jouer ?"))
        contenu.children.add(creerBloc(
            "En commençant par le joueur à sa gauche puis dans le sens des aiguilles " +
                    "d'une montre, le Donneur offre un choix à chaque joueur, lui-même compris : " +
                    "STOP ou ENCORE. STOP : vous sortez de la manche, retournez vos cartes face " +
                    "cachée. Vous ajouterez vos points à votre total en fin de manche. ENCORE : " +
                    "le Donneur vous distribue une nouvelle carte face visible."
        ))
        contenu.children.add(creerBloc(
            "Si vous recevez une carte Numéro que vous ne possédiez pas déjà, tout va " +
                    "bien : vous restez dans la manche. Si vous recevez un Numéro que vous " +
                    "possédiez déjà, vous sautez : la manche s'arrête là pour vous et vous ne " +
                    "gagnez aucun point. Si vous possédez 7 cartes Numéro différentes, vous " +
                    "réalisez un Flip 7 : la manche s'arrête pour tout le monde et vous gagnez " +
                    "15 points supplémentaires."
        ))
        contenu.children.add(creerBloc(
            "Placez vos cartes Numéro en une ligne devant vous pour en tenir le compte. " +
                    "Quand vous recevez un Bonus, placez-le au-dessus de votre ligne : il sera " +
                    "compté quand vous sortirez de la manche, sauf si vous sautez. Les Bonus ne " +
                    "sont pas des Numéros : ils ne permettent pas de faire un Flip 7, mais ne " +
                    "risquent pas de vous faire sauter. Si vous recevez une carte Spéciale, vous " +
                    "devez appliquer son effet."
        ))


        contenu.children.add(creerTitre("Fin de manche"))
        contenu.children.add(creerBloc(
            "La manche continue jusqu'à ce que tous les joueurs soient sortis (stop ou " +
                    "saut), ou qu'un joueur réalise un Flip 7. Les joueurs qui n'ont pas sauté " +
                    "calculent leur score : totalisez d'abord la valeur de vos cartes Numéro. Si " +
                    "vous avez la carte Bonus x2, doublez ce total. Ajoutez ensuite les points " +
                    "des autres cartes Bonus. Enfin, si vous avez réalisé un Flip 7, marquez " +
                    "15 points supplémentaires."
        ))


        contenu.children.add(creerTitre("Nouvelle manche & paquet vide"))
        contenu.children.add(creerBloc(
            "Mettez de côté toutes les cartes utilisées pendant la manche précédente, " +
                    "sans les remélanger dans le paquet. Le Donneur passe le restant du paquet " +
                    "au joueur à sa gauche, qui devient le nouveau Donneur. Lorsque le paquet " +
                    "est vide, mélangez toutes les cartes défaussées pour former un nouveau paquet. " +
                    "Si vous devez refaire le paquet en pleine manche, laissez les cartes devant " +
                    "les joueurs là où elles sont."
        ))


        contenu.children.add(creerTitre("Fin de la partie"))
        contenu.children.add(creerBloc(
            "À la fin d'une manche, si au moins un joueur a atteint ou dépassé 200 points, " +
                    "la partie prend fin. Le joueur avec le score le plus élevé est déclaré " +
                    "vainqueur. En cas d'égalité, jouez une nouvelle manche pour départager les " +
                    "joueurs à égalité."
        ))


        contenu.children.add(creerTitre("Cartes spéciales"))
        contenu.children.add(creerBloc(
            "Stop : ciblez un joueur encore dans la manche. Il sort immédiatement et " +
                    "retourne ses cartes face cachée (il garde ses points pour la fin de manche). " +
                    "Si vous êtes le seul joueur restant, vous devez vous cibler vous-même."
        ))
        contenu.children.add(creerBloc(
            "Seconde Chance : gardez cette carte devant vous. Si plus tard dans la manche " +
                    "vous recevez une carte Numéro qui vous ferait sauter, défaussez-la avec la " +
                    "Seconde Chance : cela vous évite de sauter. Un joueur ne peut avoir qu'une " +
                    "seule Seconde Chance ; une deuxième doit être donnée à un autre joueur encore " +
                    "en jeu, sinon elle est défaussée. Toutes les Seconde Chance sont défaussées " +
                    "en fin de manche, même inutilisées."
        ))
        contenu.children.add(creerBloc(
            "Trois à la suite : ciblez un joueur encore dans la manche (cela peut être " +
                    "vous). Le Donneur lui distribue les 3 prochaines cartes du paquet. " +
                    "Interrompez la distribution s'il saute ou réalise un Flip 7. Si une carte " +
                    "Stop ou Trois à la suite apparaît, elle compte parmi les 3 mais n'est " +
                    "appliquée qu'après la distribution."
        ))


        contenu.children.add(creerTitre("Cartes bonus"))
        contenu.children.add(creerBloc(
            "Les cartes +2, +4, +6, +8 et +10 ajoutent leur valeur à vos points. La " +
                    "carte x2 double les points de toutes vos cartes Numéro, mais ne double ni " +
                    "les points des cartes Bonus, ni les 15 points d'un Flip 7."
        ))


        val scroll = ScrollPane(contenu)
        scroll.vbarPolicy = ScrollPane.ScrollBarPolicy.AS_NEEDED
        scroll.hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
        scroll.isFitToWidth = true
        scroll.style = "-fx-background-color: #d4d4d4; -fx-background: #d4d4d4;"

        this.center = scroll
        this.style = "-fx-background-color: #d4d4d4;"
    }


    private fun creerTitre(texte: String): Label {
        val label = Label(texte)
        label.font = Font.font("Arial", FontWeight.BOLD, 17.0)
        label.style = "-fx-text-fill: #2a2a4a;"
        return label
    }


    private fun creerBloc(texte: String): Label {
        val label = Label(texte)
        label.isWrapText = true
        label.maxWidth = 760.0
        label.style =
            "-fx-background-color: #9fa0d8;" +
                    "-fx-text-fill: #1a1a2e;" +
                    "-fx-padding: 18 22 18 22;" +
                    "-fx-font-size: 15px;"
        return label
    }
}
