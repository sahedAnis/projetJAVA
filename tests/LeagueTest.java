import competition.*;

public class LeagueTest extends CompetitionTest{

	protected Competition createCompetition() {
		Match m = new Match();
		MatchStrategy s = new MatchAlea();
		m.setMatchStrategy(s);
		return new League(this.liste, m);
	}
    
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(LeagueTest.class);
    } 
}