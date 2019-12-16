# Le projet Distributeur
Voici une solution de l'exercice distributeur.

Il n'y a pas de réponse ultime, j'ai pris différentes décisions qui ne sont pas les votres, mais cela ne veut pas dire que vous avez faux.

Voici quelques explications supplémentaires pour vous aider.

J'ai transformé tout le code en anglais, c'est plus naturelle pour moi de coder en anglais, je vous conseille de continuer ainsi.

## L'objet Distributeur Dristributor

On retrouve la map drinkTypePrice pour gérer le prix par type de boisson. J'ai ajouté l'objet DistributorStore et DistributorCheckout  

## L'objet de gestion de magasin de boisson DistributorStore

On retrouve la liste de boisson dans cette objet. la fonction "findAndLoad" permet de trouver une boisson et de la charger, ce qui veut dire de la garder en mémoire.
La fonction pullLoaded permet de sortir la boisson chargée.

## L'objet de gestion de la caisse DistributorCheckout

On retrouve la map qui permet de savoir par pièce, le nombre présent dans la caisse.
Ceci est stocké dans l'objet Money de nom "total".
La fonction "pay", permet d'ajouter l'argent de l'utilisateur à la caisse et d'enlever celle de la monnaie de retour.

## L'objet de gestion d'argent Money

Cette objet permet de visualiser un nombre de pièce par pièce.
Celle ci n'est pas forcément liée à un contexte de distributeur, elle pourrait être utilisée autre part pour gérer de la monnaie.
On retrouve les fonctions "add" pour ajouter des pièces, "remove" pour enlever, "contains" pour voir si on a ce type de pièce.

## Pour exécuter: Lancer la classe Runner

Vous trouverez 3 scénarios qui permettent de tester tout ceci.

## Pour aller plus loin

Au niveau du retour de la monnaie, vous avez peut être un défaut de 5 centimes ou d'une pièce près.
L'arrondi créé des soucis en Java. Je n'ai pas parlé l'objet BigDecimal et BigInteger, on regardera cela à la rentrée.

On n'a pas vu aussi l'objet Optional, qui pourrait nous aider dans notre problèmatique de null.
On regardera cela à la rentrée.