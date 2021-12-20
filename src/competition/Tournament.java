/**
 * Class of League
 * @author SAHED Anis & KENBA Ayoub
 * @version 1.0
*/


package competition;
import java.util.*;

public class Tournament extends Competition{

    public Tournament(List<Competitor> l, Match m){
        super(l, m);
    }
    
    /*
    * Tournaments (direct elimination) take place over several rounds.
    *
    **/
    public void play(List<Competitor> l){
        if(l.size()%2 != 0) {
    		System.out.print("La taille de la liste des joueurs doit être une puissance de deux ! \n");
    	}
    	else {
    		int listsize = l.size();
    		List<Competitor> sublist = this.copyList(l);
    		for(int i = 0; i <= 2; i++) {
        		for(int j = 0; j < (listsize/(2*(i+1))); j++) {
	        			Competitor winner = this.playMatch(sublist.get(j), sublist.get(j+1));
	        			System.out.println(sublist.get(j).getFirstName() + " Vs " + sublist.get(j+1).getFirstName());
	        			this.match.fireMatchFinished();
        			if (winner.equals(sublist.get(j))){
        				sublist.remove(j+1);
        			}
        			else {
        				sublist.remove(j);
        			}
        		}
        	}
			System.out.println("\n");
    		this.displayRanking(l);
    		System.out.println(" ********************** \n");
    		this.fireCompetitionFinished();
    	} 
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
    
    
    /***
    * Copies the list l given and returns the copy.
    * @param l the list to be copied
    * @return a new list copied from l
    */
    public List<Competitor> copyList(List<Competitor> l){
		List<Competitor> sublist = new ArrayList<Competitor>();
		for(int k = 0; k < l.size(); k++) {
			sublist.add(l.get(k));
		}
		return sublist;
    }

    /**
     * Returns the winner of the competition.
     * @return the winner of the competition.
     * */
    public Competitor getWinner(List<Competitor> l) {
		Competitor localWinner = l.get(0);
		int maxScore = localWinner.getNbWins();
		
    	for(int i = 0; i < l.size(); i++) { 
    		if(l.get(i).getNbWins() >= maxScore) {
    			localWinner = l.get(i);
    			maxScore = l.get(i).getNbWins();
    		}
    	}
    	return localWinner;
    }
}


