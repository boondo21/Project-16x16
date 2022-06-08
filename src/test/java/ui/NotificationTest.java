package ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import project_16x16.SideScroller;
import project_16x16.ui.Notifications;

public class NotificationTest {
	
	
	@BeforeAll
	public void setUp() throws Exception {
		
	}
	
	@AfterAll
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
	
	/**
	 * Purpose: Check run
	 * Input: run 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void testrun() {
		try {
			Notifications.addNotification("title","message");
			Notifications.run();		
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Purpose: Check stageResized
	 * Input: stageResized 
	 * Expected:
	 * 	return void
	 */
	@Test
	public void teststageResized() {
		try {
			Notifications.stageResized();	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
