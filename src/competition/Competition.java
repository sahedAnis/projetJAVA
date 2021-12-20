/**
 * Class of Competition
 * @author SAHED Anis & KENBA Ayoub
 * @version 1.0
 */
package competition;
import competition.util.*;
import java.util.*;
import listeners.*;
import event.*;

public abstract class Competition{

    protected Match match;
    protected List<Competitor> competitors;
    protected ArrayList<CompetitionListener> competitionListeners;


    public Competition(List<Competitor> l, Match m){
        this.competitors = l;
        this.match = m;
        this.competitionListeners = new ArrayList<CompetitionListener>();
    }

    /**
    * Plays the competition.
      */
    public void play(){
        this.play(this.competitors);
    }

    /*
    * Play the competition according on how we want it to be played (League, Tournament,...)
    * @param l list of competitors.
    */
    public abstract void play(List<Competitor> l);


    /**
    * Plays one match between two competitors. Returns the match's winner.
    @return the winner of the match.
    */
    public abstract Competitor playMatch(Competitor c1, Competitor c2);


    /**
    *Returns map of players as key associated with their score as value. 
    * @return map of players as key associated with their score as value.
    */
    public Map<Competitor, Integer> ranking(List<Competitor> l){
        Map<Competitor, Integer> scoremap = new HashMap<Competitor, Integer>();
        
        int size = l.size();
        for(int i = 0; i < size; i++){
            scoremap.put(l.get(i), l.get(i).getNbWins());
        }
        return scoremap;
    }

      /** Sort the map containing competitors and their score on descending values.
    *  @return the map sorted by descendinb values.
     */
    public Map<Competitor, Integer> descendantRanking(List<Competitor> l){
        Map<Competitor, Integer> scoretab = this.ranking(l);
        Map<Competitor, Integer> scoretabdescendant = MapUtil.sortByDescendingValue(scoretab);
        return scoretabdescendant;
    }

    /**
    * Displays the descendant ranking of competitor.
     */
    public void displayRanking(List<Competitor> l){
        System.out.println("*** Ranking ***\n");
        Map<Competitor, Integer> descendantRankingValue = this.descendantRanking(l);
        for(Competitor c : descendantRankingValue.keySet()){
            System.out.println(c.getFirstName() + " - " + c.getNbWins() + "\n");
        }
    }


    /**
    * Getter. Returns the match.
    @return the type of the match.
     */
    public Match getMatch(){
        return this.match;
    }

    /**
    * Getter. Returns the list of the competitors.
    @return list of the competitors.
     */
    public List<Competitor> getCompetitors(){
        return this.competitors;
    }
    
    /**
     * Returns the winner of the competition.
     * @return the winner of the competition.
     * */
    public abstract Competitor getWinner(List<Competitor> l);

    /* Adds the CompetitionListener l to the list of competitionListeners
     * @param l the object CompetitionListener to be added.
     */
    public synchronized void addCompetitionListener(CompetitionListener l) {
    	if(competitionListeners.contains(l)) {return;}
    	this.competitionListeners.add(l);
    }
    
    /* Remove the CompetitionListener l to the list of commpetitionListeners
     * @param l the object CompetitionListener to be removed.
     */
    public synchronized void removeCompetitionListener(CompetitionListener l) {
    	this.competitionListeners.remove(l);
    }

	/* Trigger the propagation of competitionFinished event from the methods where they are detected. 
    */
    public void fireCompetitionFinished() {
     	ArrayList<CompetitionListener> t1 = (ArrayList<CompetitionListener>) this.competitionListeners.clone();
     	if(t1.size() == 0) {return;}
     	Competitor winner = this.getWinner(this.competitors);
     	List<Competitor> competitors = this.getCompetitors();
     	CompetitionEvent event = new CompetitionEvent(this, winner, competitors);
     	for(CompetitionListener listener : t1) {
     		listener.competitionFinished(event);
     	}
    }

}