package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import processing.event.MouseEvent;
import project_16x16.SideScroller;
import project_16x16.ui.Anchor;
import project_16x16.ui.ScrollBarHorizontal;
import project_16x16.ui.ScrollBarVertical;

public class ScrollBarVerticalTest {
	Anchor anchor;
	ScrollBarVertical scrollBarVertical;
	@Before
	public void setUp() throws Exception {
		anchor = new Anchor(new SideScroller(), 10, 10, 10, 10);
		scrollBarVertical = new ScrollBarVertical(anchor);
	}
	
	@After
	public void tearDown() throws Exception {
		anchor=null;
		scrollBarVertical=null;
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
			scrollBarVertical.setAnchor(anc);
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
			scrollBarVertical.setBarRatio((float)2.0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Purpose: Check mouseWheel
	 * Input: mouseWheel 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testmouseWheel() {
		try {
			MouseEvent mouseEvent = new MouseEvent(anchor, 10, MouseEvent.CLICK, 10, 10, 10, 10, 10); 
			scrollBarVertical.mouseWheel(mouseEvent);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
