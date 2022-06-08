package project_16x16.multiplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.net.ConnectException;
import org.junit.jupiter.api.Test;

import processing.data.JSONObject;
import project_16x16.SideScroller;

class MultiplayerTest {

	/**
	 * Purpose: Test for Constructor() for host
	 * Input: SideScroller s, hostIP - "127.0.0.1", port - 25564, isHost - true
	 * Expected:
	 * 		Server should be active
	 */
	@Test
	void testMultiplayerSideScrollerStringIntBoolean() throws ConnectException {
		SideScroller s = new SideScroller();
		Multiplayer m = new Multiplayer(s, "127.0.0.1", 25564, true);
		assertTrue(m.getServer().active());
		m.exit();
	}
	
	/**
	 * Purpose: Test for Constructor() for client
	 * Input: SideScroller s, hostIP - "127.0.0.1", port - 25563, isHost - false
	 * Expected:
	 * 		Client should be active
	 */
	@Test
	void testMultiplayerSideScrollerStringIntBoolean3() throws ConnectException {
		SideScroller s = new SideScroller();

		Multiplayer m1 = new Multiplayer(s, "127.0.0.1", 25563, true);
		Multiplayer m2 = new Multiplayer(s, "127.0.0.1", 25563, false);
		assertTrue(m2.getClient().active());
		m2.exit();
		m1.exit();
	}

	/**
	 * Purpose: Test for Constructor() for client
	 * Input: SideScroller s, isHost - false
	 * Expected:
	 * 		Client should be active
	 */
	@Test
	void testMultiplayerSideScrollerBoolean() throws ConnectException {
		SideScroller s = new SideScroller();
		Multiplayer m1 = new Multiplayer(s, "127.0.0.1", 25565, true);
		Multiplayer m2 = new Multiplayer(s, false);
		assertTrue(m2.getClient().active());
		m2.exit();
		m1.exit();
	}

	/**
	 * Purpose: Test for readData() for host
	 * Input: SideScroller s, hostIP - "127.0.0.1", port - 25562, isHost - true
	 * Expected:
	 * 		data should be equal to read one
	 */
	@Test
	void testReadData() throws ConnectException {
		SideScroller s = new SideScroller();
		Multiplayer m = new Multiplayer(s, "127.0.0.1", 25562, true);
		JSONObject data = m.readData();
		assertEquals(data, m.getData());
		m.exit();
	}

	/**
	 * Purpose: Test for readData() for client
	 * Input: SideScroller s, hostIP - "127.0.0.1", port - 25559, isHost - false
	 * Expected:
	 * 		data should be equal to read one
	 */
	@Test
	void testReadData2() throws ConnectException {

		SideScroller s = new SideScroller();
		Multiplayer m1 = new Multiplayer(s, "127.0.0.1", 25559, true);
		Multiplayer m2 = new Multiplayer(s, "127.0.0.1", 25559, false);
		
		m1.writeData("Hello test");
		JSONObject data = m2.readData();
		assertEquals(data, m2.getData());		
		m2.exit();
		m1.exit();
	}
	
	/**
	 * Purpose: Test for writeData() for host
	 * Input: SideScroller s, hostIP - "127.0.0.1", port - 25561, isHost - true
	 * Expected:
	 * 		data should be successfully written
	 */
	@Test
	void testWriteData() throws ConnectException {
		SideScroller s = new SideScroller();
		Multiplayer m = new Multiplayer(s, "127.0.0.1", 25561, true);
		assertTrue(m.getServer().active());
		m.writeData("Hello test");
		m.exit();
	}
	
	/**
	 * Purpose: Test for writeData() for client
	 * Input: SideScroller s, hostIP - "127.0.0.1", port - 25559, isHost - false
	 * Expected:
	 * 		data should be successfully written
	 */
	@Test
	void testWriteData2() throws ConnectException {
		SideScroller s = new SideScroller();
		Multiplayer m1 = new Multiplayer(s, "127.0.0.1", 25559, true);
		Multiplayer m2 = new Multiplayer(s, "127.0.0.1", 25559, false);
		m2.writeData("Hello test");
		m2.exit();
		m1.exit();
	}

	/**
	 * Purpose: Test for exit() for client and host
	 * Input: SideScroller s, hostIP - "127.0.0.1", port - 25560, isHost - false and true
	 * Expected:
	 * 		server and client should not be active
	 */
	@Test
	void testExit() throws ConnectException {
		SideScroller s = new SideScroller();
		Multiplayer m1 = new Multiplayer(s, "127.0.0.1", 25560, true);
		Multiplayer m2 = new Multiplayer(s, "127.0.0.1", 25560, false);
		m2.exit();
		m1.exit();
		assertFalse(m1.getServer().active());
		assertFalse(m2.getClient().active());
	}

}
