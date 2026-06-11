# Rapport de Conception UML - Flip7

Ce document détaille les principaux choix d'analyse et d'architecture orientée objet réalisés pour la modélisation du jeu Flip7.

## 1 Séparation des responsabilités : Jeu et Manche
Nous avons choisi de créer deux classes : une `Jeu` et une `Manche`. 
La classe `Jeu` gère la logique globale du jeu (liste des joueurs, la pioche car elle ne se réinitialise pas entre les manches...). 
La classe `Manche` gère les actions qui sont spécifiques à chaque manche.

## 2 Cycle de vie de la Pioche
La classe `Pioche` est créée par la classe `Jeu` et non par la classe `Manche`.
Les règles du Flip7 expliquent que le paquet de cartes n'est pas réinitialisé à chaque nouvelle manche. La `Pioche` devait donc rester d'une `Manche` à l'autre. La classe `Jeu` possède la pioche et la prête à la `Manche` en cours.

## 3 Modélisation des Cartes par Héritage
Nous avons choisi de créer une classe abstraite `Carte` dont héritent les trois autres types de cartes, afin de bien séparer chaque fonctionnement : `CarteNuméro`, `CarteBonus`, `CarteSpéciale`. 

## 4 Gestion dynamique des Cartes Spéciales
Les effets des cartes spéciales (Stop, Vie, Pioche x3) sont gérés via des sous-classes de `CarteSpéciale`.       
L'effet est déclenché via `appliquerEffet(joueurCible: Joueur, mancheActuelle: Manche)`.  
Une carte seule ne connaît pas l'état de la partie. Pour appliquer un effet comme "arrêter le tour" ou "piocher 3 cartes supplémentaires", la carte a besoin d'interagir avec le reste du jeu. Lui passer la `Manche` en paramètre lui donne les informations nécessaires pour modifier l'ordre de jeu ou interagir avec la pioche.

## 5 Gestion de la mécanique éliminé ou stop
La classe `Joueur` a deux attributs : `estActif` et `estEliminé`. Ce sont deux booléens qui permettent de gérer la fin de la manche et si l'on doit compter ou non les points du joueur.

## 6 Déroulé d'une manche
`Manche` est créée en prenant en entrée une pioche et une liste de joueurs qui viennent de la classe `Jeu`, pour pouvoir conserver l’état de la pioche, de la défausse et des scores des joueurs d’une manche à l’autre. La manche a une méthode `jouerManche` qui permet de gérer la boucle de jeu principale, c'est-à-dire le tour des joueurs, jusqu’au comptage des points de la manche. Cette méthode va appeler `choixAction` prenant en entrée le joueur actif à chaque tour, et en fonction de son choix, piocher ou s’arrêter, elle va appliquer la méthode correspondante sur le joueur. Une fois que tous les joueurs sont inactifs, elle va appeler la méthode `calculPoints` sur chacun des joueurs, puis s’arrêter. La méthode `défausserCartes` est appelée lors de ce calcul des points pour placer les cartes des joueurs dans la défausse. 

## 7 Contenu de la classe Pioche
La classe `Pioche` fonctionne de la manière suivante :
Elle a 2 attributs, pioche et défausse. 
Lorsque la méthode `initialiser()` de la classe `Jeu` est appelée, un objet `Pioche` est créé avec en constructeur la liste de toutes les cartes du jeu, et une défausse vide.
Pendant la manche, `choixAction()` sera appelé, et si le joueur choisit `piocher()`, alors `donnerCarte()` sera appelé pour lui donner une carte.
`remplirPioche()` met les cartes de la défausse dans la pioche.
`mélangerPioche()` mélange les cartes de la pioche.