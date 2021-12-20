/**
 * Class of League
 * @author SAHED Anis & KENBA Ayoub
 * @version 1.0
 */


package competition;


import java.util.*;

public class League extends Competition{


    public League(List<Competitor> l, Match m){
        super(l, m);
    }
    
    /*
    * In League, championships are played in two-legged matches
    */
    public void play(List<Competitor> l){
        for(int i = 0; i < l.size(); i++){
            for(int j = 0; j < l.size(); j++){
                if (l.get(i).equals(l.get(j)) == false){ // pour ne pas avoir Player1 joue avec lui même 
                    Competitor winner = this.playMatch(l.get(i), l.get(j));
                    System.out.println(l.get(i).getFirstName() + " Vs " + l.get(j).getFirstName());
                    this.match.fireMatchFinished();
                }                
            }
        }
        System.out.println("\n");
        this.displayRanking(l);
        this.fireCompetitionFinished();
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
    	Competitor winner = this.competitors.get(0);
    	int max = this.competitors.get(0).getNbWins();;
    	for(int i = 1; i < this.competitors.size(); i++) { 
    		if(this.competitors.get(i).getNbWins() >= max) {
    			winner = this.competitors.get(i);
    			max = this.competitors.get(i).getNbWins();
    		}
    	}
    	return winner;
    }
    
}