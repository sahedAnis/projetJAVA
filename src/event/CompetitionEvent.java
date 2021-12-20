package event;
import java.util.List;

import competition.*;

public class CompetitionEvent extends java.util.EventObject{
	
	private Competitor winner;
	private List<Competitor> competitors;
		
	public CompetitionEvent(Competition source, Competitor w, List<Competitor> l) {
		super(source);
		this.winner = w;
		this.competitors = l;
	}
	
	/**
	 * returns the winner of the Competition
	 * @return Competitor object that represents the winner of the competition
	 */
	public Competitor getWinner() {
		return this.winner;
	}
	
	/**
	 * returns the competitors of the Competition
	 * @return Competitors list that contains the competitors
	 */
	public List<Competitor> getCompetitors() {
		return this.competitors;
	}
}
