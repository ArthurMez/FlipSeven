# Compte rendu des tests:

## 1. Classe `Flip7`

### 1.1. Constructeur `Flip7`

|                       |                                       |   |   |   |   |   |
|-----------------------|---------------------------------------|---|---|---|---|---|
| nbJoueurs  : Int      | [2,4]                                 | x |   | x | x | x |
|                       | ]Int.MIN_VALUE, 2\]\[4,MAX_VALUE[       |   | x |   |   |   |
|                       |                                       |   |   |   |   |   |
| joueurs:List<IJoueur> |                                       |   |   |   |   |   |
|                       | joueur.size = nbJoueurs               | x | x |   | x | x |
|                       | joueur.size != nbJoueurs              |   |   | x |   |   |
| cartes : List<Carte>  | cartes.size() != 94                   |   |   |   | x |   |
|                       | cartes.size() = 94                    | x | x | x |   | x |
| scoreFinPartie : Int  | [50,200]                              | x | x | x | x |   |
|                       | ]Int.MIN_VALUE,50\[\]200,Int.MAX_VALUE[ |   |   |   |   | x |
| retour                | Flip7                                 | x |   |   |   |   |
| throws                | NombreJoueursInvalideException        |   | x |   |   |   |
|                       | ListeJoueursInvalideException         |   |   | x |   |   |
|                       | PiocheInvalideException               |   |   |   | x |   |
|                       | ScoreFinPartieInvalideException       |   |   |   |   | x |

Description des tests de constructeur Flip7 :

- ct1 : c'est pour tester si le constructeur renvoie un Flip7
- ct2 : sert à tester si le constructeur renvoie l'exception NombreJoueursInvalideException si nbJoueurs est différent de 2,3,4
- ct3 : sert à tester si le constructeur renvoie l'exception ListeJoueursInvalideException si la taille de la liste joueurs est différent de nbJoueurs
- ct4 : est pour throws PiocheInvalideException si la pioche en paramètre du constructeur n'a pas le bon nombre de carte
- ct5 : sert à throws  ScoreFinPartieInvalideException si le score est différent de [50,200].

### 1.2. `joueurCourantDitStop()`

|                  | Intervalle                   | CT1 | CT2 | CT3 | CT4 |
|------------------|------------------------------|:---:|:---:|:---:|:---:|
| **etatPartie**       | ATTENTE_CHOIX_JOUEUR         |  X  |     |     |  X  |
|                  | ATTENTE_CIBLE_STOP           |     |  X  |     |     |
|                  | MANCHE_TERMINEE              |     |     |  X  |     |
| **joueurs restants** | plus de 1 en JOUE_ENCORE     |  X  |     |     |     |
|                  | dernier joueur actif         |     |     |     |  X  |
| **Sortie**           | joueur stoppé, tour suivant  |  X  |     |     |     |
|                  | état passe à MANCHE_TERMINEE |     |     |     |  X  |
| **Exception**        | EtatPartieInvalideException  |     |  X  |  X  |     |

### 1.3. `joueurCourantCibleStop(carteStop, nbJoueurCible)`

|               | Intervalle                        | CT1 | CT2 | CT3 | CT4 | CT5 |
|---------------|-----------------------------------|:---:|:---:|:---:|:---:|:---:|
| **etatPartie**    | ATTENTE_CIBLE_STOP                |  X  |     |  X  |  X  |  X  |
|               | autre état                        |     |  X  |     |     |     |
| **carteStop**     | CarteStop de piocheUneCarte       |  X  |     |     |  X  |  X  |
|               | autre                             |     |     |  X  |     |     |
| **nbJoueurCible** | joueur JOUE_ENCORE                |  X  |     |  X  |     |     |
|               | joueur STOP                       |     |     |     |  X  |     |
|               | joueur PERDU                      |     |     |     |     |  X  |
| **Sortie**        | cible stoppée, carte dans sa main |  X  |     |     |     |     |
| **Exception**     | EtatPartieInvalideException       |     |  X  |     |     |     |
|               | CarteInvalideException            |     |     |  X  |     |     |
|               | JoueurNonActifException           |     |     |     |  X  |  X  |

### 1.4. `scoreManche()`

|              | Intervalle                   | CT1 | CT2 | CT3 | CT4 | CT5 |
|--------------|------------------------------|:---:|:---:|:---:|:---:|:---:|
| **etatPartie**   | MANCHE_TERMINEE              |  X  |     |  X  |  X  |  X  |
|              | autre état                   |     |  X  |     |     |     |
| **joueur**       | STOP (score = calculScore)   |  X  |     |  X  |  X  |  X  |
|              | PERDU (score = 0)            |  X  |     |     |     |     |
| **Flip7**        | non (< 7 CarteNum)           |  X  |     |     |  X  |  X  |
|              | oui (7 CarteNum et +15)      |     |     |  X  |     |     |
| **score cumulé** | < scoreFinPartie             |  X  |     |  X  |     |  X  |
|              | sup ou égal à scoreFinPartie |     |     |     |  X  |     |
| **Sortie**       | Map<Int, Int>                |  X  |     |  X  |  X  |  X  |
|              | état passe à NOUVELLE_MANCHE |  X  |     |  X  |     |  X  |
|              | état passe à PARTIE_TERMINEE |     |     |     |  X  |     |
| **Exception**    | EtatPartieInvalideException  |     |  X  |     |     |     |

### 1.5. `nouvelleManche()`

|            | Intervalle                                                                  | CT1 | CT2 | CT3 | CT4 |
|------------|-----------------------------------------------------------------------------|:---:|:---:|:---:|:---:|
| **etatPartie** | NOUVELLE_MANCHE                                                             |  X  |     |     |  X  |
|            | ATTENTE_CHOIX_JOUEUR                                                        |     |  X  |     |     |
|            | PARTIE_TERMINEE                                                             |     |     |  X  |     |
| **Sortie**     | les mains sont vidées, tous JOUE_ENCORE, état passe en ATTENTE_CHOIX_JOUEUR |  X  |     |     |  X  |
|            | scores cumulés conservés                                                    |  X  |     |     |  X  |
| **Exception**  | EtatPartieInvalideException                                                 |     |  X  |  X  |     |

---

### 1.6. `joueurCourantPiocheUneCarte()`

| Entrées / Résultats       | classes d'équivalence               | CT1 | CT2 | CT3 | CT4 | CT5 | CT6 | CT7 |
|:--------------------------|:------------------------------------|:----|:----|:----|:----|:----|:----|:----|
| `etatPartie`                | `ATTENTE_CHOIX_JOUEUR`                | x   |     | x   | x   | x   | x   | x   |
|                           | `!= ATTENTE_CHOIX_JOUEUR`             |     | x   |     |     |     |     |     |
| `joueurCourant.etat`        | `JOUE_ENCORE`                         | x   | x   |     | x   | x   | x   | x   |
|                           | `!= JOUE_ENCORE`                      |     |     | x   |     |     |     |     |
| `carteTiree`                | `estCarteNum()`                       | x   |     |     | x   |     |     |     |
|                           | `estCarteStop()`                      |     |     |     |     | x   |     |     |
|                           | `estCarte3aLaSuite()`                 |     |     |     |     |     | x   |     |
|                           | `estCarte2ndeChance()`                |     |     |     |     |     |     | x   |
| `main.contains(carteTiree)` | `false`                               | x   |     |     |     |     |     | x   |
|                           | `true`                                |     |     |     | x   |     |     |     |
| **Retour**                    | Retourne la`carteTiree`               | x   |     |     | x   | x   | x   | x   |
| **Modifications d'état**      | `joueurCourant.etat = PERDU`          |     |     |     | x   |     |     |     |
|                           | `etatPartie = ATTENTE_CIBLE_STOP`     |     |     |     |     | x   |     |     |
|                           | `etatPartie = ATTENTE_CIBLE_3SUITE`   |     |     |     |     |     | x   |     |
|                           | Carte `2ndeChance` retirée de la main |     |     |     |     |     |     | x   |
| **Exceptions**                | `EtatPartieInvalideException`         |     | x   |     |     |     |     |     |
|                           | `JoueurNonActifException`             |     |     | x   |     |     |     |     |

### 1.7. `joueurCourantCible3aLaSuite()`

| Entrées / Résultats  | classes d'équivalence                   | CT1 | CT2 | CT3 | CT4 | CT5 | CT6 |
|:---------------------|:----------------------------------------|:----|:----|:----|:----|:----|:----|
| `etatPartie`           | `ATTENTE_CIBLE_3SUITE`                    | x   |     | x   | x   | x   | x   |
|                      | `!= ATTENTE_CIBLE_3SUITE`                 |     | x   |     |     |     |     |
| `carte3aLaSuite`       | Instance exacte de la carte tirée       | x   | x   |     | x   | x   | x   |
|                      | Instance invalide ou mauvais type       |     |     | x   |     |     |     |
| `nbJoueurCible`        | `[0, nbJoueurs - 1]`                      | x   | x   | x   | x   | x   | x   |
| `joueurs[Cible].etat`  | `JOUE_ENCORE`                             | x   | x   | x   |     | x   | x   |
|                      | `!= JOUE_ENCORE`                          |     |     |     | x   |     |     |
| `taillePioche`         | Suffisante (`>= 3`)                       | x   |     |     |     |     | x   |
|                      | Tombe à `0` (déclenche remélange)         |     |     |     |     | x   |     |
| **Résultat des pioches** | 3 cartes sans aucun doublon             | x   |     |     |     | x   |     |
|                      | Un doublon est pioché (arrêt prématuré) |     |     |     |     |     | x   |
| **Retour**               | Retourne une `List<Carte>` (3 cartes)     | x   |     |     |     | x   |     |
|                      | Retourne une `List<Carte>` (< 3 cartes)   |     |     |     |     |     | x   |
| **Modifications d'état** | `joueurs[Cible].etat = PERDU`             |     |     |     |     |     | x   |
| **Exceptions**           | `EtatPartieInvalideException`             |     | x   |     |     |     |     |
|                      | `CarteInvalideException`                  |     |     | x   |     |     |     |
|                      | `JoueurNonActifException`                 |     |     |     | x   |     |     |

---

## 2. Classe `OutilsCarte`

### 2.1. `verifieMainPossible`

|                                                 |                       |     |     |     |     |     |     |     |     |     |
|-------------------------------------------------|-----------------------|-----|-----|-----|-----|-----|-----|-----|-----|-----|
| caractéristique de main:List<Carte>             | classes d'équivalence | CT1 | CT2 | CT3 | CT4 | CT5 | CT6 | CT7 | CT8 | CT9 |
| Nombre de CarteBonusMultiplie                   | [0,1]                 | x   | x   | x   |     | x   | x   | x   | x   | x   |
|                                                 | ]1,Int.MAX_VALUE[     |     |     |     | x   |     |     |     |     |     |
| Nombre de CarteBonusPlus                        | [0,5]                 | x   | x   | x   | x   |     | x   | x   | x   | x   |
|                                                 | ]5,Int.MAX_VALUE[     |     |     |     |     | x   |     |     |     |     |
| Nombre maximal de même valeur de CarteBonusPlus | [0,1]                 | x   | x   | x   | x   | x   |     | x   | x   | x   |
|                                                 | ]1,Int.MAX_VALUE[     |     |     |     |     |     | x   |     |     |     |
| Nombre de Carte2ndeChance                       | [0,3]                 | x   | x   | x   | x   | x   | x   |     | x   | x   |
|                                                 | ]3,Int.MAX_VALUE[     |     |     |     |     |     |     | x   |     |     |
| Nombre de CarteNum                              | [0,7]                 | x   |     | x   | x   | x   | x   | x   | x   | x   |
|                                                 | ]7,Int.MAX_VALUE[     |     | x   |     |     |     |     |     |     |     |
| Nombre maximal  de même valeur de CarteNum      | [0,2]                 | x   | x   |     | x   | x   | x   | x   | x   | x   |
|                                                 | ]2,Int.MAX_VALUE[     |     |     | x   |     |     |     |     |     |     |
| Nombre de CarteStop                             | [0,1]                 | x   | x   | x   | x   | x   | x   | x   |     | x   |
|                                                 | ]1,Int.MAX_VALUE[     |     |     |     |     |     |     |     | x   |     |
| Nombre de Carte3aLaSuite                        | [0,3]                 | x   | x   | x   | x   | x   | x   | x   | x   |     |
|                                                 | ]3,Int.MAX_VALUE[     |     |     |     |     |     |     |     |     | x   |
| retour                                          | void                  | x   |     |     |     |     |     |     |     |     |
| throws                                          | MainInvalideException |     | x   | x   | x   | x   | x   | x   | x   | x   |

Description des tests de verifieMainPossible :

- ct1 : c'est pour tester si un main est valide.
- ct2 : sert à tester si  on renvoie l'exception MainInvalideException si nombre de CarteNum est plus de 7.
- ct3 : sert à tester si  on renvoie l'exception MainInvalideException si nombre maximal  de même valeur de CarteNum est plus de 2.
- ct4 : sert à tester si  on renvoie l'exception MainInvalideException si nombre de CarteBonusMultiplie est plus de 1.
- ct5 : sert à tester si  on renvoie l'exception MainInvalideException si nombre de CarteBonusPlus est plus de 5.
- ct6 : sert à tester si  on renvoie l'exception MainInvalideException si nombre maximal de même valeur de CarteBonusPlus est plus de 1.
- ct7 : sert à tester si  on renvoie l'exception MainInvalideException si nombre de Carte2ndeChance est plus de 3.
- ct8 : sert à tester si  on renvoie l'exception MainInvalideException si nombre de CarteStop est plus de 1.
- ct9 : sert à tester si  on renvoie l'exception MainInvalideException si nombre de Carte3aLaSuite est plus de 3.

### 2.2. `verifiePiocheInitiale`

|                                                                          |                         |     |     |     |     |     |     |     |
|--------------------------------------------------------------------------|-------------------------|-----|-----|-----|-----|-----|-----|-----|
| caractéristique de unePioche:List<Carte>                                 | classes d'équivalence   | CT1 | CT2 | CT3 | CT4 | CT5 | CT6 | CT7 |
| Nombre total de cartes                                                   | 94                      | x   |     |     | x   | x   | x   | x   |
|                                                                          | [0,94[                  |     | x   |     |     |     |     |     |
|                                                                          | ]94,Int.MAX_VALUE[      |     |     | x   |     |     |     |     |
| Nombre de CarteNum                                                       | 79                      | x   |     |     | x   | x   | x   | x   |
|                                                                          | [0,79[                  |     |     |     |     |     |     |     |
|                                                                          | ]79,Int.MAX_VALUE[      |     |     |     |     |     |     |     |
| Répartition des CarteNum (1×CarteNum(0), i×CarteNum(i) pour i de 1 à 12) | 1*0,i*i)                  | x   |     |     |     | x   | x   | x   |
|                                                                          | non conforme            |     |     |     | x   |     |     |     |
| Valeur de chaque CarteNum                                                | [0,12]                  | x   |     |     | x   | x   | x   | x   |
|                                                                          | ]Int.MIN_VALUE,0[       |     |     |     |     |     |     |     |
|                                                                          | ]12,Int.MAX_VALUE[      |     |     |     |     |     |     |     |
| Nombre de CarteBonusMultiplie                                            | 1                       | x   |     |     | x   |     | x   | x   |
|                                                                          | [0,1[                   |     |     |     |     | x   |     |     |
|                                                                          | ]1,Int.MAX_VALUE[       |     |     |     |     |     |     |     |
| Nombre de CarteBonusPlus                                                 | 5                       | x   |     |     | x   | x   | x   | x   |
|                                                                          | [0,5[                   |     |     |     |     |     |     |     |
|                                                                          | ]5,Int.MAX_VALUE[       |     |     |     |     |     |     |     |
| Valeurs des CarteBonusPlus                                               | {2,4,6,8,10}            | x   |     |     | x   | x   |     | x   |
|                                                                          | =!{2,4,6,8,10}          |     |     |     |     |     | x   |     |
| Nombre de Carte2ndeChance                                                | 3                       | x   |     |     | x   | x   | x   |     |
|                                                                          | [0,3[                   |     |     |     |     |     |     | x   |
|                                                                          | ]3,Int.MAX_VALUE[       |     |     |     |     |     |     |     |
| Nombre de Carte3aLaSuite                                                 | 3                       | x   |     |     | x   | x   | x   | x   |
|                                                                          | [0,3[                   |     |     |     |     |     |     |     |
|                                                                          | ]3,Int.MAX_VALUE[       |     |     |     |     |     |     |     |
| Nombre de CarteStop                                                      | 3                       | x   |     |     | x   | x   | x   | x   |
|                                                                          | [0,3[                   |     |     |     |     |     |     |     |
|                                                                          | ]3,Int.MAX_VALUE[       |     |     |     |     |     |     |     |
| throws                                                                   | PiocheInvalideException |     | x   | x   | x   | x   | x   | x   |
| retour                                                                   | void                    | x   |     |     |     |     |     |     |

Description des tests de verifiePiocheInitiale :

- ct1 : c'est pour tester si une Pioche est valide.
- ct2 : sert à tester si on renvoie l'exception PiocheInvalideException si le nombre total de cartes est inférieur à 94.
- ct3 : sert à tester si on renvoie l'exception PiocheInvalideException si le nombre total de cartes est supérieur à 94.
- ct4 : sert à tester si on renvoie l'exception PiocheInvalideException si la répartition des CarteNum n'est pas conforme (1×CarteNum(0) et i×CarteNum(i) pour i de 1 à 12).
- ct5 : sert à tester si on renvoie l'exception PiocheInvalideException si le nombre de CarteBonusMultiplie est différent de 1.
- ct6 : sert à tester si on renvoie l'exception PiocheInvalideException si les valeurs des CarteBonusPlus ne sont pas  {2,4,6,8,10}.
- ct7 : sert à tester si on renvoie l'exception PiocheInvalideException si le nombre de Carte2ndeChance est différent de 3.

### 2.3. `CalculScore`

| entrée | main                                       | main correcte              | x |   |   |
|--------|--------------------------------------------|----------------------------|:-:|:-:|---|
|        |                                            | main correcte dont doublon |   |   | x |
|        |                                            | main incorrecte            |   | x |   |
| throws | MainInvalideExeption                       |                            |   | x |   |
| return | 0                                          |                            |   |   | x |
| return | Score( =résultat du calcul des points) int |                            | x |   |   |

Description des tests:

\-Verification du throw MainInvalideExeption lorsque la main est Invalide.

\-Verification qu'il n'y a pas d'erreur lorsqu'elle est valide.

\-Comparaison du score attendu et du score actuel selon plusieurs cas précis: -avec uniquement des carteNum, avec carteNum et Doublon (renvoie 0), test avec carteNum + carteSpeciale sans effet, test avec carteBonusPlus, test avec le x2, test avec le flip7, test de l'ordre de calcul des points entre carteNum carteBonus Flip7 et x2, test des carteBonus avec un doublon.

### 2.4. `EstFlip7`

| entrée | main                 | main correcte                             | x |   |   |
|--------|----------------------|-------------------------------------------|:-:|:-:|:-:|
|        |                      | main correcte dont 7 carteNum différentes |   | x |   |
|        |                      | main incorrecte                           |   |   | x |
| throws | MainInvalideExeption |                                           |   |   | x |
| return | True                 |                                           |   | x |   |
| return | False                |                                           | x |   |   |

Description des tests:

\-Verification du throw MainInvalideExeption lorsque la main est Invalide.

\-assertTrue du Flip7 avec uniquement 7 carteNum différentes, puis avec les 7 carteNum et d'autres cartes autre que carteNum

\-assertFalse du Flip7 avec 6 carteNum différentes, puis avec 7 carteNum dont un doublon.

---

## 3. Classe `Carte` 

### 3.1. `toString(): String`

|        | Intervalle          | CT1 | CT2 | CT3 | CT4 | CT5 | CT6 | CT7 | CT8 | CT9 |
|--------|---------------------|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| **this**   | CarteNum            |  X  |  X  |  X  |     |     |     |     |     |     |
|        | CarteBonusPlus      |     |     |     |  X  |  X  |     |     |     |     |
|        | CarteBonusMultiplie |     |     |     |     |     |  X  |     |     |     |
|        | CarteStop           |     |     |     |     |     |     |  X  |     |     |
|        | Carte2ndeChance     |     |     |     |     |     |     |     |  X  |     |
|        | Carte3aLaSuite      |     |     |     |     |     |     |     |     |  X  |
| **Sortie** | String correct      |  X  |  X  |  X  |  X  |  X  |  X  |  X  |  X  |  X  |

### 3.2. `equals(other: Any?)`

#### 3.2.1. `CarteNum.equals`

|        | Intervalle            | CT1 | CT2 | CT3 | CT4 | CT5 |
|--------|-----------------------|:---:|:---:|:---:|:---:|:---:|
| **other**  | CarteNum, même valeur |  X  |     |  X  |     |     |
|        | CarteNum pas pareil   |     |  X  |     |     |     |
|        | type différent        |     |     |     |  X  |     |
|        | null                  |     |     |     |     |  X  |
| **Sortie** | `true`                  |  X  |     |  X  |     |     |
|        | `false`                 |     |  X  |     |  X  |  X  |

#### 3.2.2. `CarteBonusPlus.equals`

|        | Intervalle                  | CT1 | CT2 | CT3 | CT4 |
|--------|-----------------------------|:---:|:---:|:---:|:---:|
| **other**  | CarteBonusPlus, même valeur |  X  |     |     |     |
|        | CarteBonusPlus, pas pareil  |     |  X  |     |     |
|        | type différent              |     |     |  X  |     |
|        | null                        |     |     |     |  X  |
| **Sortie** | `true`                        |  X  |     |     |     |
|        | `false`                       |     |  X  |  X  |  X  |

#### 