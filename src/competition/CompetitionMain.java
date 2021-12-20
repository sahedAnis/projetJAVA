package competition;
import event.*;
import listeners.*;
/**
 * Main of the project
 * @author SAHED Anis & KENBA Ayoub
 * @version 1.0
 */

import java.util.*;
import java.util.Scanner;


public class CompetitionMain{

	public static void main(String[] args) {
		/* V1 : 
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Bonjour, quel mode voulez-vous jouer \n");
		System.out.println("Tapez 1 pour le mode LEAGUE, 2 pour le mode TOURNAMENT\n\n");
		
		int mode = myScanner.nextInt();
		
		while(mode != 1 && mode != 2) {
			System.out.println("Valeur incorrete. Veuillez rÃ©essayez, s'il vous plait : \n");
			System.out.println("Tapez 1 pour le mode League, 2 pour le mode Tournoi\n\n");
			mode = myScanner.nextInt();
		}
		
		if(mode == 1) {
			
			System.out.println("**** Bienvenue dans le mode LEAGUE ! ****\n\n");
			
			Competitor c1 = new Compelistsize/(listsize/2)titor("Anis", "Sahed");
		    Competitor c2 = new Competitor("Kenba", "Ayoub");
		    Competitor c3 = new Competitor("Toto", "Titi");

		    List<Competitor> liste = new ArrayList<Competitor>();
	    	
	    	liste.add(c1);
	        liste.add(c2);
	        liste.add(c3);
	        League l = new League(liste, new MatchAlea());
	        
	        l.play();
		}
		
		else if(mode == 2) {
			System.out.println("**** Bienvenue dans le mode TOURNAMENT ! ****\n\n");
			
			Competitor c1 = new Competitor("Anis", "Sahed");
		    Competitor c2 = new Competitor("Kenba", "Ayoub");
		    Competitor c3 = new Competitor("Toto", "Titi");
		    Competitor c4 = new Competitor("Hihi", "Hoho");
		    List<Competitor> liste = new ArrayList<Competitor>();
	    	
	    	liste.add(c1);
	        liste.add(c2);
	        liste.add(c3);
	        liste.add(c4);
	        
	        Tournament t = new Tournament(liste, new MatchAlea());
	        
	        t.play();
	
		}
		*/
		
		// V2 :
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Bonjour, quel mode voulez-vous jouer \n");
		System.out.println("Tapez 1 pour le mode LEAGUE, 2 pour le mode TOURNAMENT, 3 pour le mode MASTER\n\n");
		
		int mode = myScanner.nextInt();
		
		while(mode != 1 && mode != 2 && mode != 3) {
			System.out.println("Valeur incorrete. Veuillez rÃ©essayez, s'il vous plait : \n");
			System.out.println("Tapez 1 pour le mode League, 2 pour le mode Tournoi, 3 pour le mode Master\n\n");
			mode = myScanner.nextInt();
		}
		/* 
		if(mode == 1) {
			
			System.out.println("**** Bienvenue dans le mode LEAGUE ! ****\n\n");
			
			Competitor c1 = new Competitor("Anis", "Sahed");
		    Competitor c2 = new Competitor("Kenba", "Ayoub");
		    Competitor c3 = new Competitor("Toto", "Titi");

		    List<Competitor> liste = new ArrayList<Competitor>();
	    	
	    	liste.add(c1);
	        liste.add(c2);
	        liste.add(c3);
	        
	        MatchAlea m = new MatchAlea();
	       	Bookmaker b = new Bookmaker("Thierry Dupont", 5);
	        
	        m.addMatchListener(b);
	        
	        League l = new League(liste, m);
	        
	        b.addCompetitors(l);
	        
	        l.play();
		}
		*/

		if(mode == 1) {
			
			System.out.println("**************************** Bienvenue dans le mode LEAGUE ! *******************************************************************************************************************");
			
			
			Competitor c1 = new Competitor("Anis", "Sahed");
		    Competitor c2 = new Competitor("Kenba", "Ayoub");
		    Competitor c3 = new Competitor("Toto", "Titi");

		    List<Competitor> liste = new ArrayList<Competitor>();
	    	
	    	liste.add(c1);
	        liste.add(c2);
	        liste.add(c3);
	        
	        Match m = new Match();
	        MatchStrategy s = new MatchAlea();
	        
	        m.setMatchStrategy(s);
	        
	       	Bookmaker b = new Bookmaker("Thierry Dupont", 5);
	       	Journalist j = new Journalist("Titi Toto", "L'Equipe");
	        
	       	
	       	System.out.println("* La League tant attendue est enfin là, de très belles affiches pour ce soir !                                                                                                 *"); 
	       	System.out.println("* Le journaliste en charge d'afficher le résultat des matchs ce soir est le grand : " + j.getName() + " pour le journal : " + j.getJournal() + "                                                       *");
	       	System.out.println("* Quant au Bookmaker, c'est monsieur : " + b.getName() + " qui est avec nous ce soir. Sa mission est de faire évoluer les cotes des compétiteurs en fonction de leurs résultat      *");
	       	System.out.println("********************************************************************************************************************************************************************************");
	       	System.out.println("\n\n");
	       	
	       	m.addMatchListener(j);
	        m.addMatchListener(b);
	        
	        League l = new League(liste, m);
	        
	        l.addCompetitionListener(j);
	        l.addCompetitionListener(b);
	        
	        b.addCompetitors(l);
	        
	        l.play();
		}



		else if(mode == 2) {
			System.out.println("***************************************************************************** Bienvenue dans le mode TOURNAMENT ! ***************************************************************************************************************");
			
			Competitor c1 = new Competitor("Anis", "Sahed");
		    Competitor c2 = new Competitor("Kenba", "Ayoub");
		    Competitor c3 = new Competitor("Toto", "Titi");
		    Competitor c4 = new Competitor("Hihi", "Hoho");
		    List<Competitor> liste = new ArrayList<Competitor>();
	    	
	    	liste.add(c1);
	        liste.add(c2);
	        liste.add(c3);
	        liste.add(c4);
	        
	        
	        Match m = new Match();
	        MatchStrategy s = new MatchAlea();
	        
	        m.setMatchStrategy(s);
	        
	       	Bookmaker b = new Bookmaker("Thierry Dupont", 5);
	       	Journalist j = new Journalist("Titi Toto", "L'Equipe");
	       	
	       	System.out.println("* Le tournoi tant attendu est enfin là, de très belles affiches pour ce soir !                                                                                                 *"); 
	       	System.out.println("* Le journaliste en charge d'afficher le résultat des matchs ce soir est le grand : " + j.getName() + " pour le journal : " + j.getJournal() + "                                                       *");
	       	System.out.println("* Quant au Bookmaker, c'est monsieur : " + b.getName() + " qui est avec nous ce soir. Sa mission est de faire évoluer les cotes des compétiteurs en fonction de leurs résultat      *");
	       	System.out.println("********************************************************************************************************************************************************************************");
	       	System.out.println("\n\n");
	        
	        m.addMatchListener(j);
	        m.addMatchListener(b);
	        
	        Tournament t = new Tournament(liste,  m);
	        
	        t.addCompetitionListener(j);
	        t.addCompetitionListener(b);
	        
	        b.addCompetitors(t);
	        t.play();
	
		}
		else {
			
			System.out.println("**************************** Bienvenue dans le mode MASTER ! *******************************************************************************************************************");
			
	       	System.out.println("* Le Master tant attendu est enfin là, de très belles affiches pour ce soir !                                                                                                 *"); 
	       	
	       	
			System.out.println("* Veuillez choisir une stratégie de jeu, s'il vous plait :\n\n");
			System.out.println("* Tapez 1 pour la stratégie -> SelectFourFromSixteen : \n");
			System.out.println("*    Cette stratégie répartira 16 joueurs en 4 poules de 4 joueurs et ne conservera");
			System.out.println("*     que les meilleurs de chaque poule pour la seconde phase\n\n");
			System.out.println("* Tapez 2 pour la stratégie -> TwentyFourDividedIntoThreeGrpOfEight : \n");
			System.out.println("*    Cette stratégie répartira 24 joueurs en 3 poules de 8 joueurs et ne conservera que");
			System.out.println("*    les 2 premiers de chaque poule auxquels s’ajoutent les 2 meilleurs troisièmes\n\n");
		
			mode = myScanner.nextInt();
			
			while(mode != 1 && mode != 2) {
				System.out.println("Saisie incorrecte, veuillez s'il vous plait réessayer : \n\n");
				mode = myScanner.nextInt();
			}
			
			if (mode == 1) {
				
				System.out.println("*Vous avez séléctionné la stratégie SELECT FOUR FROM SIXTEEN, c'est parti ! \n");
				
				
				Competitor c1 = new Competitor("Real Madrid", "FC");
		    	Competitor c2 = new Competitor("Barcelona", "FC");
		    	Competitor c3 = new Competitor("Atletico Madrid", "FC");
		    	Competitor c4 = new Competitor("SÃ©ville", "FC");
		    	Competitor c5 = new Competitor("Betis", "FC");
		    	Competitor c6 = new Competitor("Real Sociedad", "FC");
		    	Competitor c7 = new Competitor("Rayo Vallecano", "FC");
		    	Competitor c8 = new Competitor("Osasuna", "FC");
		    	Competitor c9 = new Competitor("Ath. Bilbao", "FC");
		    	Competitor c10 = new Competitor("Espanyol", "FC");
		    	Competitor c11 = new Competitor("Majorque", "FC");
		    	Competitor c12 = new Competitor("Villareal", "FC");
		    	Competitor c13 = new Competitor("Celta Vigo", "FC");
		    	Competitor c14 = new Competitor("Elche", "FC");
		    	Competitor c15 = new Competitor("Cadix", "FC");
		    	Competitor c16 = new Competitor("Getafe", "FC");
		    	
		    	List<Competitor> liste = new ArrayList<Competitor>();
		    	
		    	liste.add(c1);
		        liste.add(c2);
		        liste.add(c3);
		        liste.add(c4);
		    	liste.add(c5);
		        liste.add(c6);
		        liste.add(c7);
		        liste.add(c8);
		    	liste.add(c9);
		        liste.add(c10);
		        liste.add(c11);
		        liste.add(c12);
		    	liste.add(c13);
		        liste.add(c14);
		        liste.add(c15);
		        liste.add(c16);
		        
		        
		        Match m = new Match();
		        MatchStrategy s = new MatchAlea();
		        
		        m.setMatchStrategy(s);
		        
		       	Bookmaker b = new Bookmaker("Thierry Dupont", 5);
		       	Journalist j = new Journalist("Titi Toto", "L'Equipe");
		        
		       	m.addMatchListener(j);
		        m.addMatchListener(b);
		        
		        System.out.println("* Le journaliste en charge d'afficher le résultat des matchs ce soir est le grand : " + j.getName() + " pour le journal : " + j.getJournal() + "                                                       *");
		       	System.out.println("* Quant au Bookmaker, c'est monsieur : " + b.getName() + " qui est avec nous ce soir. Sa mission est de faire évoluer les cotes des compétiteurs en fonction de leurs résultat      *");
		       	System.out.println("********************************************************************************************************************************************************************************");
		       	System.out.println("\n\n");
		        
		        Master master = new Master(liste, m, new SelectFourFromSixteen());
		        
		        master.addCompetitionListener(j);
		        master.addCompetitionListener(b);
		        
		        b.addCompetitors(master);
		        
		        master.play();
			}
			else if(mode == 2) {
				System.out.println("* Vous avez séléctioné la stratégie TWENTY FOU RDIVIDED INTO THREE GRP OF EIGHT, c'est parti !\n");
				
				Competitor c1 = new Competitor("Real Madrid", "FC");
		    	Competitor c2 = new Competitor("Barcelona", "FC");
		    	Competitor c3 = new Competitor("Atletico Madrid", "FC");
		    	Competitor c4 = new Competitor("S�ville", "FC");
		    	Competitor c5 = new Competitor("Betis", "FC");
		    	Competitor c6 = new Competitor("Real Sociedad", "FC");
		    	Competitor c7 = new Competitor("Rayo Vallecano", "FC");
		    	Competitor c8 = new Competitor("Osasuna", "FC");
		    	Competitor c9 = new Competitor("Ath. Bilbao", "FC");
		    	Competitor c10 = new Competitor("Espanyol", "FC");
		    	Competitor c11 = new Competitor("Majorque", "FC");
		    	Competitor c12 = new Competitor("Villareal", "FC");
		    	Competitor c13 = new Competitor("Celta Vigo", "FC");
		    	Competitor c14 = new Competitor("Elche", "FC");
		    	Competitor c15 = new Competitor("Cadix", "FC");
		    	Competitor c16 = new Competitor("Getafe", "FC");
		    	Competitor c17 = new Competitor("PSG", "FC");
		    	Competitor c18 = new Competitor("Chelsea", "FC");
		    	Competitor c19 = new Competitor("JSKAbylie", "FC");
		    	Competitor c20 = new Competitor("USMAlger", "FC");
		    	Competitor c21 = new Competitor("Bayern Munich", "FC");
		    	Competitor c22 = new Competitor("Juventus", "FC");
		    	Competitor c23 = new Competitor("Liverpool", "FC");
		    	Competitor c24 = new Competitor("RB Leipzig", "FC");
		    	
		    	List<Competitor> liste = new ArrayList<Competitor>();
		    	
		    	liste.add(c1);
		        liste.add(c2);
		        liste.add(c3);
		        liste.add(c4);
		    	liste.add(c5);
		        liste.add(c6);
		        liste.add(c7);
		        liste.add(c8);
		    	liste.add(c9);
		        liste.add(c10);
		        liste.add(c11);
		        liste.add(c12);
		    	liste.add(c13);
		        liste.add(c14);
		        liste.add(c15);
		        liste.add(c16);
		        liste.add(c17);
		        liste.add(c18);
		    	liste.add(c19);
		        liste.add(c20);
		        liste.add(c21);
		        liste.add(c22);
		        liste.add(c23);
		        liste.add(c24);
		        
		        Match m = new Match();
		        MatchStrategy s = new MatchAlea();
		        
		        m.setMatchStrategy(s);
		        
		       	Bookmaker b = new Bookmaker("Thierry Dupont", 5);
		       	Journalist j = new Journalist("Titi Toto", "L'Equipe");
		        
		       	m.addMatchListener(j);
		        m.addMatchListener(b);
		        
		        Master master = new Master(liste, m, new TwentyFourDividedIntoThreeGrpOfEight());
		        
		        System.out.println("* Le journaliste en charge d'afficher le résultat des matchs ce soir est le grand : " + j.getName() + " pour le journal : " + j.getJournal() + "                                                       *");
		       	System.out.println("* Quant au Bookmaker, c'est monsieur : " + b.getName() + " qui est avec nous ce soir. Sa mission est de faire évoluer les cotes des compétiteurs en fonction de leurs résultat      *");
		       	System.out.println("********************************************************************************************************************************************************************************");
		       	System.out.println("\n\n");
		        
		        master.addCompetitionListener(j);
		        master.addCompetitionListener(b);
		        
		        b.addCompetitors(master);
		        
		        master.play();
			}

	    }
	}
}