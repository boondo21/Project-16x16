package ui;

import static org.junit.Assert.assertNotNull;

import org.apache.jackrabbit.webdav.lock.Scope;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project_16x16.SideScroller;
import project_16x16.ui.Button;



public class ButtonTest {
	Button button;
	SideScroller scroller;
	@Before
	public void setUp() throws Exception {
		scroller = new SideScroller();
		button = new Button(scroller);
	}
	
	@After
	public void tearDown() throws Exception {
		button=null;
		scroller=null;
	}
	
	/**
	 * Purpose: check setbuttoninit
	 * Input: setbuttoninit() 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testsetbuttoninit() {
		try {
			button.setbuttontinit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
	}
}
