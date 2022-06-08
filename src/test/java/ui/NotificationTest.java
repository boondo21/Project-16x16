package ui;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project_16x16.SideScroller;
import project_16x16.ui.Anchor;
import project_16x16.ui.Notifications;

public class NotificationTest {
	
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	/**
	 * Purpose: Check assignApplet
	 * Input: assignApplet 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testassignApplet() {
		try {
			Notifications.assignApplet(new SideScroller());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Purpose: Check clear
	 * Input: clear 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testclear() {
		try {
			Notifications.clear();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Purpose: Check addNotification
	 * Input: addNotification 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testaddNotification() {
		try {
			Notifications.addNotification("title","message");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
