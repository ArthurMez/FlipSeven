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

La vue d'initialisation de la partie est constituée d'un BorderPane. 
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

La vue règle du jeu est un BorderPane. 
Le coté gauche contient le bouton retour arrière.
La partie haute contient le label de titre. 
Le centre est une Vbox qui contient des label de texte qui représentent les différentes parties des règles du jeu.

#### Déroulement partie:

###### Image:
---

//

---

//TODO




