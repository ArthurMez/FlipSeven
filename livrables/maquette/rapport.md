### Rapport maquette IHM

On a choisi de représenter le jeu flip7 en utilisant 4 vues différentes : Une vue de menu principal, une vue pour présenter les règles du jeu, une vue pour initialiser la partie, et une vue pour le déroulement de la partie.
#### Menu principal:

###### Image:
---

<img src=Images/MenuPrincipal.png>

---

Le menu principal est constitué d'une Vbox qui contient 1 label et 3 boutons: 
Le label de titre, le bouton qui permet de passer dans l'interface de lancement de partie, le bouton qui permet de passer sur la vue qui contient les règles du jeu, et un bouton pour quitter le jeu.

#### Initialisation partie:

###### Image:
---

<img src=Images/InitialisationPartie.png>

---

La vue d'initialisation de la partie est utilisée pour intégrer des joueurs dans la partie, puis la lancer en passant a la vue Déroulement partie
Elle est constituée d'un BorderPane. 
La partie gauche contient un bouton pour revenir a la vue précédente (Menu principal). 
La partie haute contient le label du titre. 
La partie basse contient une Hbox qui est constitué de : Une Vbox contenant le bouton ajouter joueur et le textField pour entrer le nom du joueur, 
Ainsi que le bouton pour lancer la partie une fois que les joueurs ont été entrés. Enfin dans le centre il y a un Hbox qui contient 4 Vbox. 
Chacune des Vbox contient les formes de personnage qui sont grises quand il n'y a pas de joueur associé. 
Quand un joueur est ajouté, on passe en visible le label qui montre le nom du joueur, et en actif le bouton pour le supprimer. 
On change aussi la couleur des formes personnage pour montrer que le joueur est présent.

#### Règles du jeu:

###### Image:
---

<img src=Images/RèglesDuJeu.png>

---

La vue règle du jeu est accessible depuis le menu principal pour apprendre a jouer avant une partie.
C'est un BorderPane. 
Le coté gauche contient le bouton retour arrière.
La partie haute contient le label de titre. 
Le centre est une Vbox qui contient des label de texte qui représentent les différentes parties des règles du jeu.

#### Déroulement partie:

###### Image:
---

<img src=Images/DéroulementPartie.png>

---

La vue Déroulement Partie est la vue principale qui est active durant toute la partie, de son lancement jusqu'a la fin. 
Elle est constituée d'un BorderPane. 
Le bas est constitué du menu qui permet d'afficher le numéro de la manche en cours, le score total des joueurs dans la partie, et les bouton d'action pour le joueur courant: Piocher ou s'arrêter (Tirer ou Stop). Il contient aussi une image de la pioche et de la carte piochée avant qu'elle soit placée dans la main d'un joueur.
Le centre du BorderPane est un GridPane dont chacune des 4 cases est une Vbox, elle même constituée de deux Hbox: une première qui contient le nom du joueur et les symboles correspondant a ces bonus*.
La deuxième contient les images de toutes les cartes numéros possédées par le joueur.

*Nous avons choisi pour économiser de la place sur l'écran et avoir un meilleur rendu visuel de remplacer les cartes spéciales et bonus dans la main des joueurs par des symboles a coté du nom du joueur (ex: un coeur pour la vie, des +X pour les bonus)




#### Cartes:

###### Image:
---

<img src=Images/Cartes.png>

---

Ce n'est pas une vue visible durant une partie, mais nous avons créé les images de toutes les cartes que nous utiliserons pendant la partie.