# Méthodologie tests / tests unitaires - Course hippodrome TDD

TURAM-ULIEN Ylane & RAJARATNAM Sarujan

----

## Consigne

- Outil de gestion de courses hippiques

- Rendu 08/03 23h59

- Hippodrome (un seul, nom), Course (nom, date, 6 chevaux), cheval(nom, âge, nombre de victoire). Indépendant les uns des autres.

- Menu en console.

- CRUD sur course et cheval.

- R sur Hippodrome (resultats) -> lister les 10 dernières courses et le cheval qui a gagné.

- Outil qui génère les résultats de course.

- Enregistrement des données (bdd, fichier txt)

- Travail en binôme. Les noms des membres du binôme seront indiqué dans un readme.

- Le code sur github, et le lien sera rendu sur Moodle.

- Le taux de couverture doit être de 75% minimum.

- Chaque test doit passer.

- Un fichier readme expliquera succinctement la stratégie de tests.


## Procédure de développement

Nous avons suivi la méthode TDD afin de développer les différentes fonctionnalités.

Nous avons commencé à mettre en place les modèles Cheval, Course, Hippodrome et enfin Data. Puis nous avons réalisé les classes DAO, ainsi que les controllers. Chaque fonctionnalité créée dans le DAO ainsi que dans le controller, nous l'avons testé. Enfin, nous avons développé la partie menu.

Pour sauvegarder les parties, nous avons mis en place un fichier CSV où nous avons développé les fonctionnélités nécessaires, puis testés.

L'avantage de tester le code à chaque fois que nous avançons le code permet de remettre en cause les différentes fonctionnalités afin de vérifier l'étanchéité du code, si elle respecte bien les conditions prédéfinies mais aussi de vérifier le bon fonctionnement du code.

## Coverage