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
}
