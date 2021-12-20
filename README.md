# V1 : 
# 🚪 Introduction sur le sujet du projet : 
Le sujet du projet est : Compétitions sportives. Le but de ce dernier est de réaliser une implémentation de compétitions. Cette implémentation doit être ouverte aux extensions.

Dans cette première version, on a implanté deux types de compétitions : 
    ● Tournament : C'est des tournois à élminiation directe se déroulant sur plusieurs tours.
    ● League : C'est une implémentation de championnants se jouant en matchs aller/retour.

# 🧩 How to : 
    ● Récupération du dépôt : $ git clone adresseSSHouHTTPS nomDuDepot
    ● Commande de la génération de la documentation : 
        .../nomDuDepot/> javadoc -sourcepath src -d docs -subpackages competition
        Localisation de la documentation : .../nomDuDepot/docs/
    ● Commande de génération de l'archive du projet (appli) :
        .../nomDuDepot/> jar cvfe appli.jar competition.CompetitionMain -C classes .
    ● Commande d'exécution de l'archive générée :
        .../nomDuDepot/> java-jar appli.jar

# 📱 Présentation d'élements de code scintillants :
    ─ Utilisation du polymorphisme.
    ─ Respect du principe ouvert fermé (OCP).
    ─ Respect du principe de résponsabilité unique (SRP).
    ─ Respect du principe Dependency Inversion Principle (Dépendre d'interfaces et de classes abstraites plutôt que de classes) :
        ● (MatchAlea implémente l'intefrace Match, League et Tournament héritent de Competition).
        ● Les classes de Tests LeagueTest et TournamentTest héritent de la classe abstraite CompetitionTest

# ❌ Ce qui n'a malheuresement pas pu être traité :
    ─ Tests des méthodes play(List<Competitor> l) des classes League et Tournament : ces méthodes renvoyaient un résultat aléatoire. On est pas parvenu à trouver la bonne façon de les tester...


# ℹ️ Avancement de la V1 📈 : 
## 19/09/2021
    • Ajout du .gitignore
    • Ajout de la V1 du diagramme UML

Competition est une classe abstraite; League et Tournament héritent de cette classe et implémentent la méthodes play(List<Competitor>) suivant la manière dont la compétition est jouée (matchs aller/retour pour League et matchs à élimination directe en plusieurs tours pour Tournament).

Match est aussi une classe abstraite; MatchAlea hérite de cette classe et implémente la méthode match(c1 : Comptetitor, c2 : Comptetitor) en faisant jouer le match, comme le nom de la classe l'indique de manière aléatoire.

La méthode playMatch(c1 : Comptetitor, c2 : Comptetitor) sera commune quelque soit la classe héritant de Competiton. Cette méthode (playMatch) fera appel à la méthode match() de l'attribut Match dans la même classe et déroulera le comportement adéquat en fonction du type du match.

On a donc, comme demandé, une modélisation qui permet d'avoir la possibilté d'autres types de compétitions et d'autres types de matchs (principe ouvert fermé) : 
    
    • Si par exemple on veut un autre type de competition : création de la classe du nouveau type, l'a faire hériter de la classe Competition et implanter la méthode play(List<Competitor>) selon le comportement voulu.

    • Aussi, si on veut un autre type de match : création de la classe du nouveau type, l'a faire hériter de la classe Match et implanter la méthode match() selon le comportement voulu. La méthode playMatch se trouvant dans la classe héritant de Competiton fera le nécessaire pour dérouler le comportement adéquat.. C'est beau le polymorphisme ! 
    

## 23/09/2021 : 
Finalement, mettre la méthode playMatch en public ne servait à rien, on l'a donc remise en protected, c'est beaucoup plus sûr.

Ajout d'une nouvelle version UML (ajout de la méthode setNbWins() de la classe Competitor + mise de la méthode playMatch() de Competiton en protected).

Ajout de la classe Competitor (compilée) et de la classe ComptetitorTest (non encore compilée et testée).


## 28/09/2021 : 
Update du diagramme UML. (UMLV4)

Ajout du test4poo.jar pour compiler et exécuter les tests;

Implémentation des classes : Match, MatchAlea, Competition, League et Tournament et leurs classes de tests. Reste à completer, compiler certaines (League et Tournament) d'entre elles et à faire passer les tests.


**Remarques**
- Pourquoi seul un des deux membres du binôme a commité ?
- il faudrait faire des plus petits commits.
- vous êtes en retard. Le coeur de ce qui est demandé pour la première version n'est pas implémenté.
- les seuls tests codés sont ceux qui correspondent aux getters et setters. Vous êtes en retard.

## 02/10/2021 : 

Transformation de la classe abstraite Match en interface (car celle-ci ne comporte qu'une seule méthode.) -> (voir UML)

Mise des .src dans un package competiton (pour pouvoir bien compiler les tests).

Completion de la classe League + ajout de la classe LeagueTest.

Ajout de la classe CompetitionMain.

Implantation de la méthode initLeggedTwoMatches((List<Competitor> l).

**Problème** : On ne comprends pas le résultat envoyé par cette méthode. Au déroulement de l'algorithme sur papier on a bien le même résultat, par contre ce n'est pas le cas en compilant. Par exemple, si on passe "<Sahed, Ayoub, Toto>" en argument à cette méthode, celle-ci nous retournera une liste de tableau Competitor[] à deux élements identiques de la forme [Toto, Sahed] ... ? 

 ## 04/10/2021 : 

Suppression de la méthode initLeggedTwoMatches. Elle a été remplacée par une boucle for dans la méthode play(List<Competitor> l). 

Mise à jour de l'UML. (voir UMLV6.png)

Ajout des méthodes descendantRanking() et displayRanking dans Competition pour classer les joueurs selon leurs score (de manière descendante) et ensuite affiche le classement (Principe de responsabiité unique ici). 

Mise à jour de l'UML (voir UMLV7.png)

Ajout LeagueTest.java

## 07/10/2021 :

Ajout méthode copyList par respect au principe de réponsabilité unique dans la classe Tournament (voir UMLV8).

Modification des méthodes ranking, descendantRanking() et displayRanking() de la classe Competition (passage en paramètre d'une ArrayList de Competitors) (voir UMLV8)

Completition de la méthode play(List<Competitor>) dans la classe Tournament.

Modification du CompetitionMain :
    - ajout d'un scanner pour pouvoir demander à l'utilisateur de saisir un numéro
    - en fonction du numéro saisi (sois 1 sois 2) une League ou un Tournament est lancé.


## 09/10/2021 : 

Ajout d'une méthode abstraite getWinner() qui renvoi le vainqueur de la compétition. (voir UMLV9)

Ajout des classes CompetitionTest, LeagueTest et TournamentTest.

## 10/10/2021 : 

Dernières petites retouches (génération de la documentation, génération de l'archive, ect..) + commit FINAL



# V2 :
# 🚪 Introduction sur le sujet du projet : 
Le sujet du projet est : Les Masters. Les Masters sont des types de Competition qui font s'affronter les compétiteurs en deux phases. La
compétition commence par une phase de poules à l’issue de laquelle certains compétiteurs sont sélectionnés pour disputer la phase finale du tournoi. Les poules sont organisées sour forme de championnat (League) tandis que la phase finale se déroule sous la forme d’un tournoi à élimination directe (Tournament).

Comme demandé, les méthodes de sélection des compétiteurs retenus pour disputer la phase finale du Master est pr´ecisée à la création du
Master, et peut varier d’un Master à un autre. On a implanté deux méthodes de séléction : 
    ● SelectFourFromSixteen : cette méthode répartira 16 joueurs en 4 groupes de 4 et ne conservera que les meilleurs de chaque poule pour la seconde phase.
    ● TwentyFourDividedIntoThreeGrpOfEight : Celle-ci à son tour répartira 24 compétiteurs en 3 groupes de 8, pour ne sélectionner pour la phase finale que les 2 premiers de chaque poule auxquels s’ajoutent les 2 meilleurs troisièmes, toutes poules confondues.

Bien sûr, le principe ouvert-fermé (OCP) est respecté dans notre modélisation. D'autres méthodes de séléctions peuvent être envisagées dans le futur.


# 🧩 How to : 
    ● Récupération du dépôt : $ git clone adresseSSHouHTTPS nomDuDepot
    ● Commande de la génération de la documentation : 
        .../nomDuDepot/> javadoc -sourcepath src -d docs -subpackages competition
        Localisation de la documentation : .../nomDuDepot/docs/
    ● Commande de génération de l'archive du projet (appli) :
        .../nomDuDepot/> jar cvfe appli.jar competition.CompetitionMain -C classes .
    ● Commande d'exécution de l'archive générée :
        .../nomDuDepot/> java -jar appli.jar

# 📱 Présentation d'élements de code scintillants :
    ─ Utilisation du polymorphisme.
    ─ Respect du principe ouvert fermé (OCP).
    ─ Respect du principe de résponsabilité unique (SRP).
    ─ Respect du principe Dependency Inversion Principle (Dépendre d'interfaces et de classes abstraites plutôt que de classes) :
        ● MatchAlea implémente l'intefrace Match.
        ● Les classes de Tests LeagueTest et TournamentTest héritent de la classe abstraite CompetitionTest.
        ● Les classes SelectFourFromSixteen et TwentyFourDividedIntoThreeGrpOfEight implémentent l'interface Strategy.
        ● Les classes Master, League et Tournament héritent de la classe abstraite Competition.
    ─ Design pattern utilisé : Strategy.
    ─ Utilisation de l'héritage dans nos tests. LeagueTest et CompetitonTest hérient de la classe CompetitionTest. (voir images/UMLTests.png).


# ❌ Ce qui n'a malheuresement pas pu être traité :
    ─ Tests des méthodes play(List<Competitor> l) de la classe Master : ces méthodes renvoyaient un résultat aléatoire. On n'est pas parvenu à trouver la bonne façon de les tester...
    ─ Factorisation du code des classes de test SelectFourFromSixteenTest & TwentyFourDividedIntoThreeGrpOfEightTest. Malgré une très forte ressemblance entre les deux classes; on n'arrivait pas à faire comme on l'a fait avec les classes TournamentTest et LeagueTest qui héritaient de la classe CompetitionTest. (voir images/UMLTests.png).


# 

     
# ℹ️ Avancement de la V2 📈 : 
# 13/10/2021 :

Ajout de l'interface SelectPlayers. Les classes implémentant SelectPlayers devront donner le code de la méthode List<Competitor> selectPlayers(List<Competitor>) en fonction de la façon dont on veut séléctionner les compétiteurs retenus pour la phase finale.

Ajout de la classe SelectFourFromSixteen qui implémente l'interface SelectPlayers et qui permet de répartir 16 joueurs en 4 poules de 4 joueurs et ne conserver que les meilleurs de chaque poule pour la seconde phase. (Voir UMLV10)

## 20/10/2021 :

Update UML : (voir UMLV11.png)
Ajout de l'interface SelectPlayers qui contient une méthode selectPlayers(List<Competitor>) qui renvoie une List<Competitor>. Les classes implémentant cette interface définiront la manière dont les joueurs vont être répartis : 
        - SelectFourFromSixteen répartira 16 joueurs en 4 poules de 4 joueurs et ne conservera que les meilleurs de chaque poule pour la seconde phase.
        - TwentyFourDividedIntoThreeGrpsOfHeight répartira quand à elle 24 joueurs en 3 groupes de 8, pour ne s´electionner pour la phase finale que
          les 2 premiers de chaque poule auxquels s’ajoutent les 2 meilleurs troisièmes, toutes poules confondues.
    
Bien sur on pourra par la suite ajouter d'autres classes implémentant l'interface SelectPlayers et donc définir d'autres méthodes  pour s´electionner les comp´etiteurs entre la premi`ere et la seconde phase.

## 26/10/2021 : 

- Modification de l'interface SelectPlayers : 
    - Ajout de la méthode dividePlayers qui permet de répartir les joueurs d'une certaine façon.
    Par exemple : la classe SelectFourFromSixteen répartira 16 joueurs en 4 poules de 4 joueurs grâce à la méthode dividePlayers et ne conservera que les meilleurs de chaque poule pour la seconde phase grâce à selectPlayers.
    (voir UMLV12).

- Ajout de la classe Master héritant de compétition et ayant en plus deux attributs : league de type League et tournament de type Tournament.
- Ajout de l'interface SelectPlayers.
- Ajout de la classe Master.

## 27/10/2021 :

- Modification du nom de l'interface SelectPlayers -> Strategy et les modifcations qui sont engendrées. (voir UMLV13.png)
- Modification du type de l'interface Strategy : Interface -> Classe abstraite, le but étant général dans la division des joueurs en poules. (voir UMLV13.png)
- Ajout classe SelectFourFromSixteen et sa classe de test (non finie).
- Completion de la méthode isDividePlayersOK de la classe SelectFourFromSixteenTest.

## 02/11/2021 : 

- Ajout de la classe TwentyFourDividedIntoThreeGrpOfEight héritant de la classe abstraite Strategy et permettant de répartir r 24 compétiteurs  répartis en 3 groupes de 8, pour ne sélectionner pour la phase finale que les 2 premiers de chaque poule auxquels s’ajoutent les 2 meilleurs troisièmes, toutes poules confondues.
- Changement du type du paramètre de la méthode selectPlayers dans la classe Strategy : List<Competitor> -> Map<List<Competitor>, Integer> l : cela nous permettera de parcourir directement toutes les poules d'un coup.
- Complétion de la classe SelectFourFromSixteen (ajout méthode selectPlayers).
- Ajout UMLV14.png

## 03/11/2021 :

- Ajout attribut nbGroups dans Strategy (ça nous a permis de faciliter l'impélemntation) et donc suppression du paramètre int nbGroups de la méthode selectPlayers. (voir UMLV15.png)
- Implementation de la méthode play(List<Competitor>) de la classe Master.
- Update UML : voir UMLV15.png

## 06/11/2021 : 
- Ajout d'une fonction permettant de remettre les scores des joueurs à 0 ( restoreScore(List<Competitor> l) ) lors du passage à la phase suivante  (Principe de responsabilité unique) et donc ajout d'un setter SetScore dans la classe Competitor pour modifier le score. 
- Ajout de la méthode selectPlayers(Map<List<Competitor>, Integer> l) de la classe TwentyFourDividedIntoThreeGrpOfEight.
- Update UML : voir UMLV16.png

## 14//11/2021 :
- Ajout d'une méthode ranking dans la classe TwentyFourDividedIntoThreeGrpOfEight pour nous faciliter la tâche pour selectionner les vainquers. (voir UMLV17.png)
- Ajout de la méthode selectPlayers de la classe TwentyFourDividedIntoThreeGrpOfEight pour sélectionner pour la phase finale que les 2 premiers de chaque poule auxquels s’ajoutent les 2 meilleurs troisièmes, toutes poules confondues
- Modification du main : 
	- ajout d'une demande de saisie pour choisir le type de la stratégie. 
- Ajout UMLV17.png

- Ajout de la classe de test MasterTest.
- Ajout de la classe de test SelectFourFromSixteenTest.
- Ajout de la classe de test TwentyFourDividedIntoThreeGrpOfEightTest. 
- Ajout UMLTests.png (dossier images)
- Ajout du diagramme UML modélisant les classes de test du projet.
- Mise des anciennes version UML dans le dossier images dans un dossier à part.
- Génération de la documentation.
- Génération de l'archive du projet
- RAPPORT final (voir README.md -> V2) 


# V3 :
# 🚪 Introduction sur le sujet du projet : 
Le sujet de la troisième et dernière version est : Les journalistes et les bookmakers. Le but étant d'ajouter des "journalistes" et des "bookmaker" qui assistent aux compétitions et qui opérent certains comportement en fonction des évènements des compétitions :

    - Les journalistes peuvent donc assister aux compétitions et diffuser le résultat des matchs.
    - Les bookmakers, quant à eux, font  ́evoluer les cotes des compétiteurs en fonction des résultats des matchs de la compétition. Ils maintiennent une liste des cotes des compétiteurs qu’ils affichent et font  evoluer en fonction des victoires (diminution de la cote) et des d ́efaites (augmentation de la cote).

# 🧩 How to : 
    ● Récupération du dépôt : $ git clone adresseSSHouHTTPS nomDuDepot
    ● Commande de la génération de la documentation : 
        .../nomDuDepot/> javadoc -sourcepath src -d docs -subpackages competition
        Localisation de la documentation : .../nomDuDepot/docs/
    ● Commande de génération de l'archive du projet (appli) :
        .../nomDuDepot/> jar cvfe appli.jar competition.CompetitionMain -C classes .
    ● Commande d'exécution de l'archive générée :
        .../nomDuDepot/> java -jar appli.jar

# 📱 Présentation d'élements de code scintillants :
    ─ Utilisation du polymorphisme.
    ─ Respect du principe ouvert fermé (OCP).
    ─ Respect du principe de résponsabilité unique (SRP).
    ─ Respect du principe Dependency Inversion Principle (Dépendre d'interfaces et de classes abstraites plutôt que de classes) :
        ● MatchAlea implémente l'intefrace Match.
        ● Les classes de Tests LeagueTest et TournamentTest héritent de la classe abstraite CompetitionTest.
        ● Les classes SelectFourFromSixteen et TwentyFourDividedIntoThreeGrpOfEight implémentent l'interface Strategy.
        ● Les classes Master, League et Tournament héritent de la classe abstraite Competition.
    
    ─ Designs patterns utilisés :  
        ● Strategy : Stratégie des matchs, stratégie de répartition des joueurs dans Master.
        ● Factory Method : voir CompetitionTest et ses classes filles.
        ● Singleton : Une seule instance du winner dans un Match. (voir la classe Match)
        ● Observer : Evenements et Listeners (tout le sujet de la V3) 

# ❌ Ce qui n'a malheuresement pas pu être traité :
    ─ Tests des méthodes d'évènements (...finished() et les méthodes fire...() );

# ✅ Ce que le projet nous a apporté  :
    ─ Mise en pratique et maitrise des designs patterns vus en cours.
    ─ Travail d'équipe.
    ─ Organisation, assiduité et régularité.
    ─ Gestion du git.

# ℹ️ Avancement de la V3 📈 :
## 21/11/2021 :
- Début de la version 3
- Définition des classes d'évènements (MatchEvent et CompetitionEvent) dans le package src.event
- Ajout des classes listeners (MatchListeners et CompetitionListeners) dans le package src.listeners

## 22/11/2021 :
- Définition des classes génératrices d'évènements (Match et Competition) : 
	● Ajout des attributs listeners (ArrayList<MatchListener> matchListeners dans MatchAlea et ArrayList<CompetitionListener> competitionListeners dans Competition)
	● Ajout des méthodes d'ajout et de suppression de listeners dans les deux classes.
	● Ajout des méthodes déclencheuses de la propagation d'évènements fireXXX dans les deux classes.
	● Update UML (voir UMLV18 + UMLEvent)

## 24/11/2021 :
- Ajout de de la classe concrète listeners Bookmaker (qui implémente MatchListeners et CompetitionListeners)
- Modification des classes d'évènements MatchEvent et CompetitionEvent
- Ajustement de la classe MatchAlea pour s'alligner avec le but du projet.
- Ajustement de la méthode play(List<Competitor> l) et du CompetitionMain afin d'avoir le bon traçage.
- UPDATE UML. (EventUML.png + UMLV19.png)

## 01/12/2021 : 
- Ajout de la classe concrète listeners Journalist (qui implémente MatchListeners et CompetitionListers)

## 02/12/2021 : 
- Ajustement de la classe Master

## 03/12/2021 :
- Gestion de l'évènement matchFinished du Journalist
- Ajustement du main
- UPDATE UML : voir EventUML.png

## 04/12/2021 : 
- Gestion de l'évènement competitionFinished du Journalist et du Bookmaker
- Ajustement du Main 
- Application du design pattern Strategy sur les matchs (voir UMLV20.png)
- Update EventUML.png

## 12/12/2021 : 
- Ajout de nouvelles classes de test : (MatchTest, MatchEventTest, CompetitionEventTest, JournalistTest & BookmakerTest) et ajustement des tests déjà fait.
- Ajout des dernières version des UML : 
    EventUML.png
    SrcUML.png
    UMLTests.png
- Génération de la documentation.
- Update de l'archive du projet.

FIN PROJET (voir RAPPORT V3 en haut).
