package competition;

import java.util.*;

public class TwentyFourDividedIntoThreeGrpOfEight extends Strategy {

	final static int NBPlayers = 24;
	final static int NBGroups = 3;
	
	public TwentyFourDividedIntoThreeGrpOfEight() {
		this.selectPlayersResult = new ArrayList<Competitor>();
		this.nbGroups = NBGroups;
	}
	
	/**
	* Ranks the players by descending score values. 
	* @return list of players ranked by their score descendtly
	*/
	public List<Competitor> ranking(List<Competitor> l){
		List<Competitor> res = new ArrayList<Competitor>();
	   	
		for(int i = 0; i < l.size(); i++) {
			int maxScore = l.get(i).getNbWins();
			Competitor winner = l.get(i);
			for(int j = 0; j < l.size(); j++) {
				if(l.get(j).getNbWins() > maxScore && (res.contains(l.get(j)) == false) && (l.get(j).equals(winner) == false)) {
					maxScore = l.get(j).getNbWins();
					winner = l.get(j);
				}
			}
			if(res.contains(winner) == false) {
				res.add(winner);
			}
		}
		for(int i = 0; i < l.size(); i++) {
			if(res.contains(l.get(i)) == false) {
				int score1 = l.get(i).getNbWins();
				Competitor winner1 = l.get(i);
				for(int j = 0; j < l.size(); j++) {
					if(l.get(j).getNbWins() > score1 && (res.contains(l.get(j)) == false) && (l.get(j).equals(winner1) == false)) {
						res.add(l.get(j));
					}
				}
				res.add(winner1);
			}
			
		}
		return res;
	}

	
	@Override
	public List<Competitor> selectPlayers(Map<List<Competitor>, Integer> l) {
		
		Map<List<Competitor>, Integer> division = l;
		
		// selectionner les deux premiers de chaque groupe :
		for(List<Competitor> poule : division.keySet()) {
				List<Competitor> rankedPoule = this.ranking(poule);
				this.selectPlayersResult.add(rankedPoule.get(0));
		}
		for(List<Competitor> poule : division.keySet()) {
			List<Competitor> rankedPoule = this.ranking(poule);
			this.selectPlayersResult.add(rankedPoule.get(1));
		}
		
		// les deux meilleurs troisièmes :
		List<Competitor> intermediaire = new ArrayList<Competitor>();
		for(List<Competitor> poule : division.keySet()) {
			List<Competitor> rankedPoule = this.ranking(poule);
			intermediaire.add(rankedPoule.get(2));
			}
		List<Competitor> rankedIntermediaire = this.ranking(intermediaire);
		this.selectPlayersResult.add(rankedIntermediaire.get(0));
		this.selectPlayersResult.add(rankedIntermediaire.get(1));
		
		return this.selectPlayersResult;
	}


	@Override
	public Map<List<Competitor>, Integer> dividePlayers(List<Competitor> l) {
		if (l.size() != NBPlayers && nbGroups != NBGroups) {
			System.out.println("Nombre de compétiteurs doit être égal à 24 et le nombre de groupes doit être égal à 3.");
			return null;
		}
		return super.dividePlayers(l);
	}
}
