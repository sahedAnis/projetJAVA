/**
 * Class of MatchAlea
 * @author SAHED Anis & KENBA Ayoub
 * @version 1.0
 */

package competition;
import java.util.*;
import listeners.*;
import event.*;



public class MatchAlea implements MatchStrategy {


    public Competitor match(Competitor c1, Competitor c2){
        Random rand = new Random();
        int random = rand.nextInt(2);
        if (random == 0){
        	Match.winner = c1;
        	c1.addOneWin();
            return c1;
        }
        Match.winner = c2;
        c2.addOneWin();
        return c2;
    }
   


    




	


}