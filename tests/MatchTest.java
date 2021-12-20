import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.*;
import org.junit.*;
import competition.*;


public class MatchTest {
	
	private Match match;
	private Competitor c1;
	private Competitor c2; 
	
	
	@Before
	public void init() {
		
		// Création d'un match avec comme stratégie MatchAlea (pattern Strategy)
		MatchStrategy s = new MatchAlea();
		
		this.match = new Match();
		this.match.setMatchStrategy(s);
		
		this.c1 = new Competitor("Titi", "Tata");
		this.c2 = new Competitor("Toto", "Tutu");
	}
	
	@Test
	public void isExecuteStrategyOK() {
		// Dans notre concéption; on a fais en sorte qu'après qu'un match ait été joué, il ne peut plus être rejoué et on garde le même vainquer
		// durant tout le déroulement pour ne pas avoir de confusion entre les classes (comme il y a beaucoup d'appes à la méthode playMatch(Competitor, Competitor)
		// C'est le Design Pattern singleton.
		
		assertNull(this.match.getWinner());
		
		// Comme la stratégie de jeu des matchs est aléatoire, et pour être sur que le vainqeur du match est "static", on fais une boucle pour tester cela : 
		this.match.executeStrategy(c1, c2);
		Competitor winner1 = this.match.getWinner();
		
		for(int i= 0; i < 10000000; i++) {
			this.match.executeStrategy(c1, c2);
			Competitor winner2 = this.match.getWinner();
			assertEquals(winner1, winner2);
		}
	}
	
	@Test
	public void deleteWinner(){
		
		this.match.executeStrategy(c1, c2);
		
		assertNotNull(this.match.getWinner());
		
		// on fais appel à la méthode deleteWinner() : 
		match.deleteWinner();
		
		assertNull(this.match.getWinner());
	}
	
	@Test
	public void addMatchListener() {
		
	}
}


	
