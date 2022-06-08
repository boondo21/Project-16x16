package ui;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project_16x16.SideScroller;
import project_16x16.ui.Anchor;

public class AnchorTest {

	private Anchor anchor;
	private SideScroller sideScroller;
	@Before
	public void setUp() throws Exception {
		sideScroller = new SideScroller(); 
		anchor = new Anchor(sideScroller,10, 10, 10, 10);
	}
	
	@After
	public void tearDown() throws Exception {
		anchor=null;
	}
	
	/**
	 * Purpose: Check copy instance
	 * Input: copy 
	 * Expected:
	 * 	return same value of anchor properties
	 */
	@Test
	public void testCopy() {
		Anchor tmp = anchor.copy();
		assertNotNull(tmp);
		assertEquals(tmp.getLocalHeight(), anchor.getLocalHeight());
		assertEquals(tmp.getLocalWidth(), anchor.getLocalWidth());
		assertEquals(tmp.getLocalX(), anchor.getLocalX());
		assertEquals(tmp.getLocalY(), anchor.getLocalY());
		assertEquals(tmp.getPApplet(), anchor.getPApplet());
	}
	
}