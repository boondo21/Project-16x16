package ui;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import processing.core.PGraphics;
import project_16x16.SideScroller;
import project_16x16.scene.PressStartinit;
import project_16x16.ui.Button;



public class ButtonTest {
	Button button;
	SideScroller scroller;
	@BeforeAll
	public void setUp() throws Exception {
		scroller = new SideScroller();
		button = new Button(scroller);
	}
	
	@AfterAll
	public void tearDown() throws Exception {
		button=null;
		scroller=null;
	}
	
	
	/**
	 * Purpose: check setInitStategy, setbuttoninit
	 * Input: setInitStategy() setbuttoninit()
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testsetInitStategy() {
		try {
			PressStartinit buttonStrategy = new PressStartinit();
			buttonStrategy.pressStart = button;
			buttonStrategy.applet = scroller;
			button.setInitStategy(buttonStrategy);
			button.setbuttontinit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
	}
	
	/**
	 * Purpose: check display
	 * Input: display()
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testdisplay() {
		try {
			scroller = new SideScroller();
			button = new Button(scroller);
			
			assertNotNull(button.applet);
			button.applet.recorder = new PGraphics();
			button.applet.g = new PGraphics();
			button.display();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Purpose: check update
	 * Input: update()
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testUpdate() {
		button.applet.mousePressEvent = true;
		button.update();
	}
}
