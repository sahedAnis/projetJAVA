import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.*;

import competition.*;

public class MasterTest{
	
    protected Competitor c1;
    protected Competitor c2;
    protected Competitor c3;
    protected List<Competitor> liste;
    protected Master game;

    @Before
    public void init(){
		this.c1 = new Competitor("Real Madrid", "FC");
    	this.c2 = new Competitor("Barcelona", "FC");
    	this.c3 = new Competitor("Atletico Madrid", "FC");
        
        this.liste = new ArrayList<Competitor>();
        
        liste.add(c1);
        liste.add(c2);
        
		Match m = new Match();
		MatchStrategy s = new MatchAlea();
		m.setMatchStrategy(s);
		
        this.game = new Master(this.liste, m, new SelectFourFromSixteen());
    }
	
	@Test
	public void isRestoreScoreOK() {
		// Cette m�thode remet les score des joueurs � z�ro : 
		// on attribut � chacun de nos joueurs un score :
		c1.setScore(34);
		c2.setScore(20);
		c3.setScore(27);
		
		assertEquals(34, c1.getNbWins());
		assertEquals(20, c2.getNbWins());
		assertEquals(27, c3.getNbWins());
		
		List<Competitor> liste = new ArrayList<Competitor>();
		liste.add(c1);
		liste.add(c2);
		liste.add(c3);
		
		// on applique donc notre m�thode sur notre liste : 
		this.game.restoreScore(liste);
		
		// on v�rifie bien que les scores des joueurs on �t� remis � z�ro :
		assertEquals(0, c1.getNbWins());
		assertEquals(0, c2.getNbWins());
		assertEquals(0, c3.getNbWins());
	}
    
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MasterTest.class);
    } 
}