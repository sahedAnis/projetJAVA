package listeners;

import competition.*;
import event.*;

public interface CompetitionListener extends java.util.EventListener {
	
	/* Method for competition finished event. This method will be triggered when a notification of a competition finished event will be received.
	 * @param e a CompetitionEvent object
	 */
	
	public void competitionFinished(CompetitionEvent e);
}
