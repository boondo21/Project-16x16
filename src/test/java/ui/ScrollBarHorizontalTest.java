package ui;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import processing.event.MouseEvent;
import project_16x16.SideScroller;
import project_16x16.ui.Anchor;
import project_16x16.ui.ScrollBarHorizontal;

public class ScrollBarHorizontalTest {
	
	ScrollBarHorizontal scrollBarHorizontal;
	Anchor anchor;
	@BeforeAll
	public void setUp() throws Exception {
		anchor = new Anchor(new SideScroller(), 10, 10, 10, 10);
		scrollBarHorizontal = new ScrollBarHorizontal(anchor);
	}
	
	@AfterAll
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
			scrollBarHorizontal.mouseWheel(mouseEvent);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
