package competition;

import java.util.*;

public class SelectFourFromSixteen extends Strategy {

	final static int NBPlayers = 16;
	final static int NBGroups = 4; 
	
	public SelectFourFromSixteen() {
		this.selectPlayersResult = new ArrayList<Competitor>();
		this.nbGroups = NBGroups;
	}

	@Override
	public List<Competitor> selectPlayers(Map<List<Competitor>, Integer> l) {
		for(List<Competitor> poule : l.keySet()) {
			Competitor localWinner = poule.get(0);
			int maxScore = localWinner.getNbWins();
			
	    	for(int i = 0; i < poule.size(); i++) { 
	    		if(poule.get(i).getNbWins() >= maxScore) {
	    			localWinner = poule.get(i);
	    			maxScore = poule.get(i).getNbWins();
	    		}
	    	}
	    	this.selectPlayersResult.add(localWinner);
		}
		return this.selectPlayersResult;
	}

	@Override
	public Map<List<Competitor>, Integer> dividePlayers(List<Competitor> l) {
		if (l.size() != NBPlayers && nbGroups != NBGroups) {
			System.out.println("Nombre de compétiteurs doit être égal à 16 et le nombre de groupes doit ếtre égal à 4.");
			return null;
		}
		return super.dividePlayers(l);
	}

}
