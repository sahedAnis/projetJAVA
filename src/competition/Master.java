/**
 * Class of Master
 * @author SAHED Anis & KENBA Ayoub
 * @version 1.0
 */


package competition;
import java.util.*;

public class Master extends Competition{

    private League league;
    private Tournament tournament;
    private Strategy selectMethod;
    private Competitor winner;

    public Master(List<Competitor> l, Match m, Strategy s){
        super(l, m);
        this.selectMethod = s;
        this.league = new League(l, m);
        this.tournament = new Tournament(l, m);
    }

    /**
    * Plays the master
     */
    public void play(List<Competitor> l){
        // répartir les joueurs selon la méthode dividePlayers de l'interface SelectPlayers et récuperer la Map en résultat.
        Map<List<Competitor>, Integer> division = this.selectMethod.dividePlayers(l);
        // itérer sur les clés de la map (chaque poule) : 
        System.out.println("*************************************************************************** LEAGUE PHASE ***********************************************************************************************************\n");
        for(List<Competitor> poule : division.keySet()) {
            // pour chaque poule, déclencher méthode play de Competition avec le trace (print) qui va avec
        	this.league.play(poule);
    	}
        
        System.out.println("*********************************************************************** TOURNAMENT PHASE ***********************************************************************************************************\n");
        // selectionner les vainqueurs de chaque poule selon selectPlayers de SelectPlayers.
        List<Competitor> vainqueurs = this.selectMethod.selectPlayers(division);
        // faire jouer une league sur la liste des Competitor selectionnés à l'étape précédente.
        this.restoreScore(vainqueurs);
        this.tournament.play(vainqueurs);
        this.setWinner(this.tournament.getWinner(vainqueurs));
		this.fireCompetitionFinished();
     }
            
    /** Restores the score of the competitors to zero.
     * @param l list of competitors
     */
    public void restoreScore(List<Competitor> l) {
    	for(int i = 0; i < l.size(); i++) {
    		l.get(i).setScore(0);
    	}
    }
    
    public void setWinner(Competitor c) {
    	this.winner = c;
    }

    /**
    * Plays one match between two competitors. Returns the match's winner.
    @return the winner of the match.
    */
    public Competitor playMatch(Competitor c1, Competitor c2){
        this.match.setCompetitors(c1, c2);
    	this.match.executeStrategy(c1, c2);
        Competitor winner = this.match.getWinner();
        return winner;
    }

        /**
     * Returns the winner of the competition.
     * @return the winner of the competition.
     * */
    public Competitor getWinner(List<Competitor> l){
        return this.winner; // on ne peux pas supprimer la m�thode ici car Master doit donner une impl�mentation de celle-ci comme elle est m�thode dans la classe m�re.
        // return null donc car le travail de getWinner est en r�alit� fait lors du d�roulement du tournoi.
    }

    
}