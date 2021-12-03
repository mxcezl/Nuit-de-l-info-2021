**Testé sous linux**

# Movai code
*Abus du préprocesseur C en do mineur*

Le programme est une calculatrice basique pour le terminal effectuant les quatres opérations de base (addition, soustraction, multiplication et division) sur des entiers 32 bits. L'utilisateur est invité à renseigner les différentes opérandes.

La particularité du code source fourni (magic.c) est qu'il est visiblement composé à 95% de AAAAAAAA. C'est absurde. Ce n'est pas censé tourner. Et pourtant ça compile. Comme par magie (noire certe, mais par magie quand même).

### Un magicien ne révèle jamais ses secrets
*...mais vu que vous êtes sympa il va faire une exception.*

Le "vrai" code source se trouve dans `generate/main.c`. Vous remarquerez que le code est beaucoup plus lisible - du moins relativement au prédédent, les noms de variables restent insensés et l'omniprésence des gotos mettent Dijkstra en rotation dans sa tombe. Mais au moins il y a des commentaires.

Mais comment en arriver à l'immondice précédente ? Tout se déroule dans le `make.py` : celui ci va commencer par lire une liste de symboles C (`symbols.txt`) et attribuer à chacun d'entre eux une séquence unique de 8 A ou А. Et non je n'ai pas répété deux fois la même lettre.

Quand je disais que le code était *visiblement* composé à 95% de AAAAAAAA ? Permettez moi d'insister sur le visiblement : en fait, certains d'entre eux sont les A *latins* que nous connaissons si bien, alors que les autres sont des А *cyrilliques*, qui sont rendus de la même manière par la plupart des polices.

Enfin bref. Les différentes combinaisons de A sont inscrites au fur et à mesure dans l'entête `magic.h` avec le symbole correspondant, le tout dans une directive `#define`. C'est comme ça que le compilateur arrive à retrouver l'instruction originelle et à traduire le non-sens qu'on lui jette à la figure.

Vous l'avez sûrement deviné, le script remplace tout simplement les symboles de main.c avec leur AAAAAAAA respectif et écrit le résultat de la substitution dans magic.c. MAIS avant de faire cela, il va effectuer un obscurcissement supplémentaire.

### Et on agite très fort !

En regardant le code source de base, vous pouvez vous rendre compte que toutes les instructions sont structurées de la même manière : 1 ligne d'identificateur, 1 ligne de code, et 1 ligne de goto vers l'instruction suivante, (+1 ligne de commentaire en entête, parce que ma santé mentale commençait à sérieusement se dégrader).

Une fois les commentaires retirés, make.py va séparer chaque bloc d'instruction, et les mélanger (pseudo-)aléatoirement. Cela est possible car les gotos rendent l'ordre d'éxecution des instructions complètement indépendantes de leur position dans le code source.

### En bref

J'ai passé beaucoup trop de temps sur cette immondice et j'ai désormais très mal à la tête. Bonne nuit.
