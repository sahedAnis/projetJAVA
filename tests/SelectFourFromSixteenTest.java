import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import competition.*;

public class SelectFourFromSixteenTest {
	
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
    }
    
    @Test 
    public void isSelectPlayersOK() {
    	// cette méthode de la classe SelectFourFromSixteen séléctionne les premiers de chaque poule pour la seconde phase
    	// on va attribut à un joueur aléatoire de chaque poule un score et voir si elle sera dans la liste renvoyée par selectPlayers
    	
    	
    	// on va dire que c1 est le premier de la poule 1 :
    	this.c1.setScore(10);
    	
    	// c7 premier de la poule 2 : 
    	this.c7.setScore(10);
    	
    	// c3 premier de la poule 3 :
    	this.c10.setScore(10);
    	
    	// c4 premier de la poule 4 :
    	this.c14.setScore(10);
    	
    	// on va répartir nos joueurs : 
    	this.strategy = new SelectFourFromSixteen();
    	Map<List<Competitor>, Integer> result = strategy.dividePlayers(liste);
    	
    	// on séléctionne les meilleurs de chaque poule : 
    	List<Competitor> winners = strategy.selectPlayers(result);
    	
    	assertTrue(winners.contains(c1));
    	assertTrue(winners.contains(c7));
    	assertTrue(winners.contains(c14));
    	assertTrue(winners.contains(c10));
    	assertFalse(winners.contains(c9));
    	
    }
    
    
	@Test
	public void isDividePlayersOK(){
		// on applique la méthode dividePlayers à la liste l et on regarde si :
			// - chaque clé est une liste de taille 4
			// que chaque poule contient bien les bonnes équipes : 
		
		this.strategy = new SelectFourFromSixteen();
		Map<List<Competitor>, Integer> result = strategy.dividePlayers(liste);
		
		for(List<Competitor> l : result.keySet()) {
			assertEquals(4, l.size());
			// on récupère première poule et on vérifie qu'elle contient les bonnes équipes :
			if(result.get(l).equals(0)) {
				assertTrue(l.contains(c1));
				assertTrue(l.contains(c2));
				assertTrue(l.contains(c3));
				assertTrue(l.contains(c4));
			}
			// deuxième : 
			else if(result.get(l).equals(1)) {
				assertTrue(l.contains(c5));
				assertTrue(l.contains(c6));
				assertTrue(l.contains(c7));
				assertTrue(l.contains(c8));
			} // troisième poule : 
			else if(result.get(l).equals(2)) {
				assertTrue(l.contains(c9));
				assertTrue(l.contains(c10));
				assertTrue(l.contains(c11));
				assertTrue(l.contains(c12));
			} // quatrième : 
			else{
				assertTrue(l.contains(c13));
				assertTrue(l.contains(c14));
				assertTrue(l.contains(c15));
				assertTrue(l.contains(c16));
				}
			}
	}

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(SelectFourFromSixteenTest.class);
    }   
}
