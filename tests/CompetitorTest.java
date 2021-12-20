import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import competition.Competitor;

public class CompetitorTest {

    private Competitor c;

    @Before
    public void init(){
        this.c = new Competitor("Ayoub", "Kenba");
    }   

    @Test
    public void isGetFirstNameWorking(){
        assertEquals(c.getFirstName(), "Ayoub");
    }

    @Test
    public void isGetLastNameWorking(){
        assertEquals(c.getLastName(), "Kenba");
    }

    @Test
    public void isGetNbWinsWorking(){
        assertEquals(c.getNbWins(), 0);
    }

    @Test
    public void addOneWiTest(){
        assertEquals(c.getNbWins(), 0);
        c.addOneWin();
        assertEquals(c.getNbWins(), 1);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CompetitorTest.class);
    }   
}