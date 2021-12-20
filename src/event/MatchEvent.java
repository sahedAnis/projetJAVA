package event;
import competition.*;

public class MatchEvent extends java.util.EventObject{
	
	private Competitor player1;
	private Competitor player2;
	private Competitor winner;
	
	public MatchEvent(Match source, Competitor p1, Competitor p2, Competitor winner) {
		super(source);
		this.player1 = p1;
		this.player2 = p2;
		this.winner = winner;
	}
	
	/**
	 * Returns the winner of the match
	 * @return the winner of the match (Competitor object)
	 */
	public Competitor getWinner() {
		return this.winner;
	}
	
	/**
	 * Returns the loser of the match
	 * @return the loser of the match (Competitor object)
	 */
	public Competitor getLoser() {
		Competitor winner = this.getWinner();
		if(this.player1.equals(winner)) {
			return this.player2;
		}
		return this.player1;
	}
}
