package event;
import static org.junit.Assert.assertSame;

import java.util.*;

import org.junit.*;

import competition.*;
import event.*;

public class CompetitionEventTest {

	private CompetitionEvent cEvent;
	private Competitor winner;
	private Competitor c2;
	private List<Competitor> liste;
	
	@Before
	public void init() {
		
		this.winner = new Competitor("Titi", "Tata");
		this.c2 = new Competitor("Toto", "Tutu");
		
		
		this.liste = new ArrayList<Competitor>();
		this.liste.add(this.winner);
		this.liste.add(c2);
		
        Match m = new Match();
        MatchStrategy s = new MatchAlea();
        m.setMatchStrategy(s);
		Competition src = new Master(liste, m, new TwentyFourDividedIntoThreeGrpOfEight());
		
		this.cEvent = new CompetitionEvent(src, this.winner, liste);
	}
	
	@Test
	public void isGetWinnerOK() {
			assertSame(this.winner, this.cEvent.getWinner());
	}
	
	@Test
	public void isGetCompetitorsOK() {
			
		assertSame(this.liste.get(0), this.winner);
		assertSame(this.liste.get(1), this.c2);
	}
	
	
	
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CompetitionEventTest.class);
    }   
}

