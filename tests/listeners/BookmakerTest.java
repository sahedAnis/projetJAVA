package listeners;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import competition.*;
import event.*;

public class BookmakerTest {

	private Bookmaker b;
	
	@Before
	public void init() {
		this.b = new Bookmaker("Titi", 5);
	}
	
	@Test
	public void isGetNameOK() {
		assertSame("Titi", b.getName());
	}
	
	@Test
	public void isAddCompetitorsOK() {
		
		// au départ, la map du Bookmaker associant chaque competiteur à sa cote est de taille 0 : 
		assertSame(0, this.b.getRatings().size());
		
		// on ajoute des compétiteurs à celle-ci :
		List<Competitor> liste = new ArrayList<Competitor>();
		Competitor c1 = new Competitor("Toto", "Tutu");
		Competitor c2 = new Competitor("Toto", "Tutu");
		
		liste.add(c1);
		liste.add(c2);
		
		Match m = new Match();
		MatchStrategy s = new MatchAlea();
		
		m.setMatchStrategy(s);
		
		League l = new League(liste, m);
		
		// on ajoute nos compétiteurs à la map du bookmaker : 
		b.addCompetitors(l);
		assertSame(2, this.b.getRatings().size());
	}
	
	@Test
	public void getCompetitorRating() {
		
		List<Competitor> liste = new ArrayList<Competitor>();
		Competitor c1 = new Competitor("Toto", "Tutu");
		Competitor c2 = new Competitor("Toto", "Tutu");
		
		liste.add(c1);
		liste.add(c2);
		
		Match m = new Match();
		MatchStrategy s = new MatchAlea();
		
		m.setMatchStrategy(s);
		
		League l = new League(liste, m);
 
		b.addCompetitors(l);
		
		assertSame(5, this.b.getRatings().get(c1));
	}
	
	@Test
	
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(BookmakerTest.class);
    } 
}
