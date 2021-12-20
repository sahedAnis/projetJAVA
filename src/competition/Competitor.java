/**
 * Class of Competitor
 * @author SAHED Anis & KENBA Ayoub
 * @version 1.0
 */
package competition;

public class Competitor{

     
     private String firstName;
     private String lastName;
     private int nbWins;

    
    /**
     * Creates a competitor. Competitor has zero wins at creation.
     */
    public Competitor(String c1, String c2){
         this.firstName = c1;
         this.lastName = c2;
         this.nbWins = 0;
    }

    /**
     * Returns the competitor's first name.
     * @return competitor's first name.
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Returns the competitor's last name.
     * @return competitor's last name.
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Returns the competitor's number of wins
     * @return competitor's number of wins.
     */
    public int getNbWins(){
        return this.nbWins;
    }

    /**
     * Add a new win to the competitor score...
     */
    public void addOneWin(){
        this.nbWins = this.nbWins + 1;
    }
    
    /** Setter. Sets competitor's nbWins to score parameter.
     * @param score new Competitor's score
     * */
    public void setScore(int score) {
    	this.nbWins = score;
    }

}