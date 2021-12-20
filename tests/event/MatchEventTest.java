package event;
import static org.junit.Assert.assertSame;

import java.util.*;

import org.junit.*;

import competition.*;
import event.*;

public class MatchEventTest {

	private MatchEvent mEvent;
	private Competitor c1;
	private Competitor c2;
	private Competitor winner;
	
	@Before
	public void init() {
		
		this.c1 = new Competitor("Titi", "Tata");
		this.c2 = new Competitor("Toto", "Tutu");
		this.winner = c2;
		Match src = new Match();
		
		this.mEvent = new MatchEvent(src, c1, c2, c2);
	}
	
	@Test
	public void isGetWinnerOK() {
			assertSame(c2, this.mEvent.getWinner());
	}
	
	@Test
	public void isGetLoserOK() {
			assertSame(c1, this.mEvent.getLoser());
	}
	
	
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MatchEventTest.class);
    }   
}
