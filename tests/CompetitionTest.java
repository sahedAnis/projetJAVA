import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.*;

import competition.*;




public abstract class CompetitionTest {
	
    protected Competitor c1;
    protected Competitor c2;
    protected Competitor c3;
    protected Competitor c4;
    protected List<Competitor> liste;
	
    // Factory method :
	protected abstract Competition createCompetition();
	
    @Before
    public void init(){
		this.c1 = new Competitor("Real Madrid", "FC");
    	this.c2 = new Competitor("Barcelona", "FC");
    	this.c3 = new Competitor("Atletico Madrid", "FC");
    	this.c4 = new Competitor("S�ville", "FC");
        
        this.liste = new ArrayList<Competitor>();
        
        liste.add(c1);
        liste.add(c2);
        liste.add(c3);
        liste.add(c4);
    }
	
	@Test
	public void isRankingOk(){
		// Design pattern : Factory method : 
		Competition competition = this.createCompetition();
		
		// Au d�but, le score de chaque joueur est �gal � 0 : 
		assertSame(0, c1.getNbWins());
		assertSame(0, c2.getNbWins());
		assertSame(0, c3.getNbWins());
		assertSame(0, c4.getNbWins());
		
		// Donc, chaque joueur a un score de 0 comme valeur : 
		Map<Competitor, Integer> result = competition.ranking(liste);
		
		for(Competitor c : result.keySet()) {
			assertSame(0, c.getNbWins());
		}
		
		// On fais jouer un match entre c1 et c2 par exemple : 
		Competitor winner = competition.playMatch(c1, c2);
		
		// On v�rfie donc que la m�thode ranking associe bien au winner son nouveau score : 
		result = competition.ranking(liste);
		
		for(Competitor c : result.keySet()) {
			if (c.equals(winner)) {
				assertSame(1, c.getNbWins());
			}
			else {
				assertSame(0, c.getNbWins());
			}
		}
	}
	
	@Test
	public void isDescendantRankingOk() {
		Competition competition = this.createCompetition();
		
		// on fais jouer la comp�tition : 
		competition.play();
		Competitor winner = competition.getWinner(this.liste);
		
		// on r�cup�re le r�sultat de la m�thode descendantRanking() ;
		Map<Competitor, Integer> result = competition.ranking(liste);
		
		for(Competitor c : result.keySet()) {
			System.out.println(c.getLastName() + "\n");
		}
		
		// On v�rifie bien que le vainqueur a bien le score le plus elev� : 
		for(Competitor c : result.keySet()) {
			if (c.equals(winner)) {
				for(Competitor comp : result.keySet()){
					assertTrue(result.get(winner) >= result.get(comp) );
				}
			}
		}
	}
	
	@Test
	public void getWinnerTest() {
		
		// Comme le vainqueur est choisi al�atoirement, on ne sais pas si c'est la bonne fa�on de tester : 
		
		Competition competition = this.createCompetition();
		
		competition.play();
		
		// on sais que le gagnant est celui qui a le plus gros score :
		// on s�l�ctionne un joueur au hasard et on suppose que c'est le vainqueur : 
		List<Competitor> competitorsMap = competition.getCompetitors();
		System.out.println("competitorsMap taille : " + competitorsMap.size() + "\n");
		Competitor localWinner = competitorsMap.get(0);
		int maxScore = localWinner.getNbWins();
		
    	for(int i = 0; i < competitorsMap.size(); i++) { 
    		if(competitorsMap.get(i).getNbWins() >= maxScore) {
    			localWinner = competitorsMap.get(i);
    			maxScore = competitorsMap.get(i).getNbWins();
    		}
    	}
		
		// � la sortie de la boucle for, on a le vrai vainquer de la comp�tition
		// on fais appel � la m�thode getWinner pour voir si c'est le cas :
		assertEquals(localWinner, competition.getWinner(this.liste));
		
	}
	
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CompetitionTest.class);
    } 
	
	
}
