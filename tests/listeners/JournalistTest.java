package listeners;

import event.*;
import competition.*;

import static org.junit.Assert.assertSame;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class JournalistTest {
	
    
	private Journalist j;
	
	@Before
	public void init() {
		this.j = new Journalist("Titi", "France Football");
	}
	
	@Test
	public void isGetNameOK() {
		assertSame("Titi", this.j.getName());
	}
	
	
	@Test
	public void isGetJournalNameOK() {
		assertSame("France Football", this.j.getJournal());
	}
	
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(JournalistTest.class);
    } 
}
