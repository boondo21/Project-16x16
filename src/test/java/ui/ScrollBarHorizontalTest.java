package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project_16x16.SideScroller;
import project_16x16.ui.Anchor;
import project_16x16.ui.Notifications;
import project_16x16.ui.ScrollBarHorizontal;

public class ScrollBarHorizontalTest {
	
	ScrollBarHorizontal scrollBarHorizontal;
	Anchor anchor;
	@Before
	public void setUp() throws Exception {
		anchor = new Anchor(new SideScroller(), 10, 10, 10, 10);
		scrollBarHorizontal = new ScrollBarHorizontal(anchor);
	}
	
	@After
	public void tearDown() throws Exception {
		anchor=null;
		scrollBarHorizontal=null;
	}
	
	/**
	 * Purpose: Check setAnchor
	 * Input: setAnchor 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testsetAnchor() {
		try {
			Anchor anc = new Anchor(new SideScroller(), 20, 20, 20, 20);
			scrollBarHorizontal.setAnchor(anc);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Purpose: Check display
	 * Input: display 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testdisplay() {
		try {
			scrollBarHorizontal.applet = new SideScroller(); 
			scrollBarHorizontal.display();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Purpose: Check setBarRatio
	 * Input: setBarRatio 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testsetBarRatio() {
		try {
			scrollBarHorizontal.setBarRatio((float)2.0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
