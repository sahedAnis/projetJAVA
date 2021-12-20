/**
 * Interface : SelectPlayers
 * @author SAHED Anis & KENBA Ayoub
 * @version 1.0
 */

package competition;

import java.util.*;

public abstract class Strategy{
    	
	
	protected List<Competitor> selectPlayersResult;
	protected int nbGroups;

    /**
    * Method to be implemented by the sub-classes. Its code depends on how we want our players to be selected.
    @return list that contains the selected players.
    */
    public abstract List<Competitor>  selectPlayers(Map<List<Competitor>, Integer> l);

    /**
    * Method to be implemented by the sub-classes. Its code depends on how we want our players to be divided.
    @return map with groups of players as keys, id of the groupe as values.
    */
    public Map<List<Competitor>, Integer> dividePlayers(List<Competitor> l){
		List<Competitor> group = new ArrayList<Competitor>();
		Map<List<Competitor>, Integer> result = new HashMap<List<Competitor>, Integer>();
		int i = 0;
		int j = (l.size()/this.nbGroups);
		int id = 0;
		while(j <= l.size()) {
			result.put(l.subList(i, j), id);
			i+=l.size()/this.nbGroups;
			j+=l.size()/this.nbGroups;
			id++;
		}
		return result;
	}

}
