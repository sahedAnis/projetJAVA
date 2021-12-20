package listeners;
import event.*;
import competition.*;
import java.util.*;

public class Bookmaker implements MatchListener, CompetitionListener{
	
	private String name;
	private int basicRating;
	private Map<Competitor, Integer> playersRatings;
	
	public Bookmaker(String s, int bR) {
		this.name = s;
		this.basicRating = bR;
		this.playersRatings = new HashMap<Competitor, Integer>();
	}

	  /**
	   * Returns this Bookmaker's name.
	   * @return This Bookmaker's name.
	   */
	  public String getName () {
	    return this.name;
	  }
	  
	  /**
	   * Returns the competition ratings established by this Bookmaker.
	   * @return The competition ratings established by this Bookmaker.
	   */
	  public Map<Competitor, Integer> getRatings () {
	    return this.playersRatings;
	  }

	  /**
	   * Returns a competitor rating.
	   * @return A competitor rating.
	   */
	  public int getCompetitorRating (Competitor competitor) {
	    return this.playersRatings.get(competitor);
	  }
	  
	  /**
	   * Adds competition competitors to this Bookmaker competitors list.*
	   */
	  public void addCompetitors (Competition competition) {
	    List<Competitor> competitors = competition.getCompetitors();
	    
	    for (Competitor competitor : competitors) {
	      if (!this.playersRatings.containsKey(competitor)) {
	    	  this.playersRatings.put(competitor, basicRating);
	      }
	    }
	  }

	  /** Calculates the new ratings of the two competitors that played the match event.
	   * @param event A match event played by two competitors.
	   */
	  public void updateRatings (MatchEvent event) {
	    this.playersRatings.put(event.getLoser(), this.playersRatings.get(event.getLoser()) + 1);
	    if (this.playersRatings.get(event.getWinner()) > 1) {
	    	this.playersRatings.put(event.getWinner(), this.playersRatings.get(event.getWinner()) - 1);
	  }
	 }
	  
	 public void matchFinished(MatchEvent e) {
		if(this.playersRatings.get(e.getWinner()) > 1) {
			System.out.println("| Bookmaker : " + this.getName() + ".");
			System.out.println("| Victoire de : " + e.getWinner().getFirstName() + " (cote " + this.displayOneCompetitorRating(e.getWinner()) + ") face à : " + e.getLoser().getFirstName() + " (cote " + this.displayOneCompetitorRating(e.getLoser()) + ").");
			System.out.println("| La cote de : " + e.getWinner().getFirstName() + " passe à " + (this.playersRatings.get(e.getWinner()) - 1) + ", celle de " + e.getLoser().getFirstName() + " passe à " + (this.playersRatings.get(e.getLoser()) + 1) + ".");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
			this.updateRatings(e);
		}
		else {
			System.out.println("| Bookmaker : " + this.getName() + ".");
			System.out.println("| Victoire de : " + e.getWinner().getFirstName() + " (cote " + this.displayOneCompetitorRating(e.getWinner()) + ") face à : " + e.getLoser().getFirstName() + " (cote " + this.displayOneCompetitorRating(e.getLoser()) + ").");
			System.out.println("| La cote de : " + e.getWinner().getFirstName() + " reste à 1, celle de " + e.getLoser().getFirstName() + " passe à " + (this.playersRatings.get(e.getLoser()) + 1) + ".\n");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
			this.updateRatings(e);
		}
		
	}
	 
	 /**
	  * Displays Competitor passed on argument rating
	  * @param eCompetitor we want to get his rating
	  * @return rating of the Competitor
	  */
	 public String displayOneCompetitorRating(Competitor e) {
		 if(this.playersRatings.containsKey(e)) { 
			 return String.valueOf(this.playersRatings.get(e));
			 }
		return "Le joueur n'existe pas dans la liste du Bookmaker.";
	}
	 
	 
	@Override
	public void competitionFinished(CompetitionEvent e) {
		System.out.println("| Bookmaker : " + this.getName() + "");
		System.out.println("| Côte des joueurs en fin de compétition :");
		for(int i = 0; i < e.getCompetitors().size(); i++) {
			System.out.println("| " + e.getCompetitors().get(i).getFirstName() + "    -> " + this.getCompetitorRating(e.getCompetitors().get(i)) + "");
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
		
	}
	
	
}
