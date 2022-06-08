package ui;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project_16x16.SideScroller;
import project_16x16.ui.Anchor;
import project_16x16.ui.AnchorOrigin;

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
	
	/**
	 * Purpose: execute Constructor
	 * Input: Anchor() make instance 
	 * Expected:
	 * 	return Anchor instance
	 */
	@Test
	public void testConstructor() {
		Anchor tmp = new Anchor(anchor, 10, 10, 10, 10);
		
		assertEquals(tmp.getPApplet(), anchor.getPApplet());
		assertEquals(tmp.getLocalHeight(), 10);
		assertEquals(tmp.getLocalWidth(), 10);
		assertEquals(tmp.getLocalX(), 10);
		assertEquals(tmp.getLocalY(), 10);
		
	}
	
	/**
	 * Purpose: get PApplet property
	 * Input: getPApplet  
	 * Expected:
	 * 	return SideScroller
	 */
	@Test
	public void testgetPApplet() {
		// hasContainer == false
		assertEquals(anchor.getPApplet(), sideScroller);
	
		// tmp hasContainer == true
		Anchor tmp = new Anchor(anchor, 10, 10, 10, 10);
		assertEquals(tmp.getPApplet(), anchor.getPApplet());
	}
	
	/**
	 * Purpose: set PApplet property
	 * Input: setPApplet  
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testsetPApplet() {
		try {
			anchor.setPApplet(sideScroller);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Purpose: get Container
	 * Input: getContainer  
	 * Expected:
	 * 	return Anchor instance
	 */
	@Test
	public void testgetContainer() {
		// hasContainer == false
		assertEquals(anchor.getContainer(), null);
	
		// tmp hasContainer == true
		Anchor tmp = new Anchor(anchor, 10, 10, 10, 10);
		assertEquals(tmp.getContainer(), anchor);
	}
	
	
	/**
	 * Purpose: set Container
	 * Input: setContainer  
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testsetContainer() {
		try {
			Anchor tmp = new Anchor(new SideScroller(), 10, 10, 10, 10);
			anchor.setContainer(tmp);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
	
	
	/**
	 * Purpose: Change of result value according to anchorOrigin value
	 * Input: X 
	 * Expected:
	 * 	return int value
	 */
	@Test
	public void testX() {
		
		int target;
		
		// Case left
		target = anchor.getLocalX()+anchor.frameGlobalX();
		
		anchor.setAnchorOrigin(AnchorOrigin.Left);
		assertEquals(target, anchor.X());
		
		anchor.setAnchorOrigin(AnchorOrigin.TopLeft);
		assertEquals(target, anchor.X());
		
		anchor.setAnchorOrigin(AnchorOrigin.BottomLeft);
		assertEquals(target, anchor.X());
		
		// Case right
		target = (anchor.frameGlobalHeight()+anchor.getLocalX())+anchor.frameGlobalX();
		
		anchor.setAnchorOrigin(AnchorOrigin.Right);
		assertEquals(target, anchor.X());
		
		anchor.setAnchorOrigin(AnchorOrigin.TopRight);
		assertEquals(target, anchor.X());
		
		anchor.setAnchorOrigin(AnchorOrigin.BottomRight);
		assertEquals(target, anchor.X());
		
		// Case center
		
		target = (anchor.frameGlobalWidth()/2 + anchor.getLocalX()) + anchor.frameGlobalX();
		
		anchor.setAnchorOrigin(AnchorOrigin.Center);
		assertEquals(target, anchor.X());
		
		//else
		
		target = anchor.getLocalX() + anchor.frameGlobalX();
				
		anchor.setAnchorOrigin(AnchorOrigin.Bottom);
		assertEquals(target, anchor.X());
		
		anchor.setAnchorOrigin(AnchorOrigin.Top);
		assertEquals(target, anchor.X());
	}
}