import competition.Competition;
import competition.Match;
import competition.MatchAlea;
import competition.MatchStrategy;
import competition.Tournament;

public class TournamentTest extends CompetitionTest{

	protected Competition createCompetition() {
		Match m = new Match();
		MatchStrategy s = new MatchAlea();
		m.setMatchStrategy(s);
		return new Tournament(this.liste, m);
	}
    
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TournamentTest.class);
    } 
}