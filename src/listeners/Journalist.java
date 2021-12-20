package listeners;
import event.*;
import listeners.*;
import java.util.*;


public class Journalist implements MatchListener, CompetitionListener {
	
	private String journal;
	private String name;
	
	public Journalist(String n,String j) {
		this.name = n;
		this.journal=j; 
	}
	
	  /**
	   * Returns this Journalist's name.
	   * @return This Journalist's name.
	   */
	  public String getName () {
	    return this.name;
	  }
	  
	   /**
	   	* Returns this Journalist's journal.
	   	* @return This Journalist's journal.
		*/
		public String getJournal() {
		  return this.journal;
		}
	
		  
		  
		public void matchFinished(MatchEvent e) {
			  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			  System.out.println("| Journalist : " + this.getName() + " pour " + this.getJournal() + " :");
			  System.out.println("| Match terminé entre " + e.getWinner().getFirstName() + " et " + e.getLoser().getFirstName() + ".");
			  System.out.println("| Belle victoire de : " + e.getWinner().getFirstName() + ".\n");
		}
		
		public void competitionFinished(CompetitionEvent e) {
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| Journalist : " + this.getName() + " pour " + this.getJournal() + " :");
			System.out.println("| Compétition terminée. L'heureux vainqueur est : " + e.getWinner().getFirstName() + "\n");
		}

}
