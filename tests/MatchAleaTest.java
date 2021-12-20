import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import competition.*;

public class MatchAleaTest {
	
	private Competitor c1;
	private Competitor c2;
	private MatchAlea m;
	
    @Before
    public void init(){
    	this.c1 = new Competitor("Titi", "Toto");
    	this.c2 = new Competitor("Tata", "Tutu");
    	
    	this.m = new MatchAlea();
    }
	
    // méthode aléatoire, on a testé comme on peut
	@Test 
	public void isMatchOK() {
		// Au début, c1 et c2 sont à égalité de score, c'est à dire 0.
		assertSame(0, c1.getNbWins());
		assertSame(0, c2.getNbWins());
		
		// on fais joueur le match :
		Competitor winner = this.m.match(c1, c2);
		
		// si c1 c'est le vainqueur, son score augemente de 1, sinon ce sera c2 : 
		if (winner.equals((c1))){
			assertSame(1, c1.getNbWins());
			assertSame(0, c2.getNbWins());
		}
		else {
			assertSame(1, c2.getNbWins());
			assertSame(0, c1.getNbWins());
		}
		
	}

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MatchAleaTest.class);
    }   
}