package listeners;

import competition.*;
import event.*;

public interface MatchListener extends java.util.EventListener {
	
	/* Method for match finished event. This method will be triggered when a notification of a match finished event will be received.
	 * @param e a MatchEvent object
	 */
	
	public void matchFinished(MatchEvent e);

}
