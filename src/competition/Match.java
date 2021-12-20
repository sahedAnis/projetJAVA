/**
 * Class of Match
 * @author SAHED Anis & KENBA Ayoub
 * @version 1.0
 */

package competition;

import java.util.ArrayList;

import event.MatchEvent;
import listeners.MatchListener;

public class Match{
	
	private ArrayList<MatchListener> matchListeners;
	private Competitor p1;
	private Competitor p2;
    private MatchStrategy strategy;
    public static Competitor winner; // Singleton
    
    public Match() {
    	this.matchListeners = new ArrayList<MatchListener>();
    }
    
	/** Sets the strategy attribute to s
     */
    public void setMatchStrategy(MatchStrategy s) {
    	this.strategy = s;
    }
    
    public void executeStrategy(Competitor c1, Competitor c2) {
 	   if (winner == null) {
		   Competitor winner = this.strategy.match(c1, c2);
	 }
    }
    
    /**
     * Sets the competitors of the match
     * @param c1 competitor one
     * @param c2 competitor two
     */
    public void setCompetitors(Competitor c1, Competitor c2) {
    	this.p1 = c1;
    	this.p2 = c2;
    }
    
    /**
     * Returns the winner of the match.
     * @param Competitor c1 the first competitor
     * @param Competitor c2 the second one
     * @return the winner of the match
     */
   public Competitor getWinner() {
	   return this.winner;
   }
    
    /**
    * Deletes the winner of the competiton
    */
   public void deleteWinner() {
	   this.winner = null;
   }
   
   /** Adds the MatchListener l to the list of matchListeners
    * @param l the object MatchListener to be added.
    */
   public synchronized void addMatchListener(MatchListener l) {
   	if(matchListeners.contains(l)) {return;}
   	this.matchListeners.add(l);
   }

   /** Remove the MatchListener l to the list of matchListeners
    * @param l the object MatchListener to be removed.
    */
   public synchronized void removeMatchListener(MatchListener l) {
   	this.matchListeners.remove(l);
   }
   
   /** Trigger the propagation of matchFinished event from the methods where they are detected. 
   */
   public void fireMatchFinished() {
	   ArrayList<MatchListener> t1 = (ArrayList<MatchListener>) this.matchListeners.clone();
	   if(t1.size() == 0) {return;}
       this.executeStrategy(p1, p2);
       Competitor winner = this.getWinner();
    	
	   MatchEvent event = new MatchEvent(this, p1, p2, winner);
	   for(MatchListener listener : t1) {
		   listener.matchFinished(event);
	   }
	   this.deleteWinner();
   }   

}
