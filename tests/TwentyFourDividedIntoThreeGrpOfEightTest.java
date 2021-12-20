import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;
import org.junit.*;

import competition.*;

public class TwentyFourDividedIntoThreeGrpOfEightTest {
	
    protected Competitor c1;
    protected Competitor c2;
    protected Competitor c3;
    protected Competitor c4;
    protected Competitor c5;
    protected Competitor c6;
    protected Competitor c7;
    protected Competitor c8;
    protected Competitor c9;
    protected Competitor c10;
    protected Competitor c11;
    protected Competitor c12;
    protected Competitor c13;
    protected Competitor c14;
    protected Competitor c15;
    protected Competitor c16;
    protected Competitor c17;
    protected Competitor c18;
    protected Competitor c19;
    protected Competitor c20;
    protected Competitor c21;
    protected Competitor c22;
    protected Competitor c23;
    protected Competitor c24;
    protected List<Competitor> liste;
    protected Strategy strategy;
	
	@Before
    public void init() {
		this.c1 = new Competitor("Real Madrid", "FC");
    	this.c2 = new Competitor("Barcelona", "FC");
    	this.c3 = new Competitor("Atletico Madrid", "FC");
    	this.c4 = new Competitor("Séville", "FC");
    	this.c5 = new Competitor("Betis", "FC");
    	this.c6 = new Competitor("Real Sociedad", "FC");
    	this.c7 = new Competitor("Rayo Vallecano", "FC");
    	this.c8 = new Competitor("Osasuna", "FC");
    	this.c9 = new Competitor("Ath. Bilbao", "FC");
    	this.c10 = new Competitor("Espanyol", "FC");
    	this.c11 = new Competitor("Majorque", "FC");
    	this.c12 = new Competitor("Villareal", "FC");
    	this.c13 = new Competitor("Celta Vigo", "FC");
    	this.c14 = new Competitor("Elche", "FC");
    	this.c15 = new Competitor("Cadix", "FC");
    	this.c16 = new Competitor("Getafe", "FC");
    	this.c17 = new Competitor("PSG", "FC");
    	this.c18 = new Competitor("Chelsea", "FC");
    	this.c19 = new Competitor("JSKAbylie", "FC");
    	this.c20 = new Competitor("USMAlger", "FC");
    	this.c21 = new Competitor("Bayern Munich", "FC");
    	this.c22 = new Competitor("Juventus", "FC");
    	this.c23 = new Competitor("Liverpool", "FC");
    	this.c24 = new Competitor("RB Leipzig", "FC");
    	
        this.liste = new ArrayList<Competitor>();
        
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
        

    }
	
	@Test
	public void isRankingOK() {
		
		Competitor comp1 = new Competitor ("Anis", "Sahed");
		Competitor comp2 = new Competitor ("Ayoub", "Kenba");
		Competitor comp3 = new Competitor ("Elias", "Frik");
		
		comp1.setScore(10);
		comp2.setScore(9);
		comp3.setScore(8);
		
		// on ajoute nos competiteurs dans un ordre ascendant de socre :
		List<Competitor> test = new ArrayList<Competitor>();
		test.add(comp3);
		test.add(comp2);
		test.add(comp1);
		
		assertEquals(comp3, test.get(0));
		assertEquals(comp2, test.get(1));
		assertEquals(comp1, test.get(2));
		
		TwentyFourDividedIntoThreeGrpOfEight strategy = new TwentyFourDividedIntoThreeGrpOfEight();
		List<Competitor> rankedTest = strategy.ranking(test);
		
		assertEquals(comp1, rankedTest.get(0));
		assertEquals(comp2, rankedTest.get(1));
		assertEquals(comp3, rankedTest.get(2));
	}
	
	
    @Test 
    public void isSelectPlayersOK() {
    	// cette méthode de la classe TwentyFourDividedIntoThreeGrpOfEight séléctionne les 2 premiers de chaque poule auxquels s’ajoutent les 2 meilleurs troisièmes toutes poules confondues.
    	// on va attribut à deux joueurs aléatoires de chaque poule un score et voir si elle sera dans la liste renvoyée par selectPlayers
    	
    	
    	// poule 1 : 
    	// c1 premier de la poule :
    	this.c1.setScore(10);
    	// c3 deuxième de la poule : 
    	this.c3.setScore(9);
    	
    	// poule 2 :
    	// c10 premier de la poule 2 : 
    	this.c10.setScore(8);
    	// c16 deuxième de la poule 2 : 
    	this.c16.setScore(7);
    	
    	// poule 3 : 
    	// c18 premier de la poule 3 :
    	this.c18.setScore(10);
    	
    	// c19 prdeuxième de la poule 4 :
    	this.c19.setScore(9);
    	
    	// les deux meilleurs troisièmes :
    	this.c2.setScore(7);
    	
    	this.c20.setScore(8);
    	
    	// on va répartir nos joueurs : 
    	this.strategy = new TwentyFourDividedIntoThreeGrpOfEight();
    	Map<List<Competitor>, Integer> result = strategy.dividePlayers(liste);
    	
    	// on séléctionne les meilleurs de chaque poule : 
    	List<Competitor> winners = strategy.selectPlayers(result);
    	
    	assertTrue(winners.contains(c1));
    	assertTrue(winners.contains(c3));
    	assertTrue(winners.contains(c10));
    	assertTrue(winners.contains(c16));
    	assertTrue(winners.contains(c18));
    	assertTrue(winners.contains(c19));
    	assertTrue(winners.contains(c2));
    	assertTrue(winners.contains(c20));
    	assertFalse(winners.contains(c15));
    	
    }
    
	
	@Test
	public void isDividePlayersOK(){
		// on applique la méthode dividePlayers à la liste l et on regarde si :
			// - chaque clé est une liste de taille 8
			// que chaque poule contient bien les bonnes équipes : 
		
		this.strategy = new TwentyFourDividedIntoThreeGrpOfEight();
		Map<List<Competitor>, Integer> result = strategy.dividePlayers(liste);
		
		for(List<Competitor> l : result.keySet()) {
			assertEquals(8, l.size());
			// on récupère première poule et on vérifie qu'elle contient les bonnes équipes :
			if(result.get(l).equals(0)) {
				assertTrue(l.contains(c1));
				assertTrue(l.contains(c2));
				assertTrue(l.contains(c3));
				assertTrue(l.contains(c4));
				assertTrue(l.contains(c5));
				assertTrue(l.contains(c6));
				assertTrue(l.contains(c7));
				assertTrue(l.contains(c8));
			}
			// deuxième : 
			else if(result.get(l).equals(1)) {
				assertTrue(l.contains(c9));
				assertTrue(l.contains(c10));
				assertTrue(l.contains(c11));
				assertTrue(l.contains(c12));
				assertTrue(l.contains(c13));
				assertTrue(l.contains(c14));
				assertTrue(l.contains(c15));
				assertTrue(l.contains(c16));
			} // troisième poule : 
			else{
				assertTrue(l.contains(c17));
				assertTrue(l.contains(c18));
				assertTrue(l.contains(c19));
				assertTrue(l.contains(c20));
				assertTrue(l.contains(c21));
				assertTrue(l.contains(c22));
				assertTrue(l.contains(c23));
				assertTrue(l.contains(c24));
				}
			}
	}
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TwentyFourDividedIntoThreeGrpOfEightTest.class);
    }  
}