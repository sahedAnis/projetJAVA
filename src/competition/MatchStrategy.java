package competition;

public interface MatchStrategy {
	
    /**
    * Method to be implemented by the sub-classes. Its code depends on how we want our match to be played.
    @return winner of the match.
    */
    public Competitor match(Competitor c1, Competitor c2);
    
    
    
}
