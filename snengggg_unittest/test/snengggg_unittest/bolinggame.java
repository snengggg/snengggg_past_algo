package snengggg_unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

public class bolinggame {

	private Game g;

	@Test
	public void testGutterGame() {
		Game g = new Game();
		for(int i = 0; i < 20; i++) {
			g.roll(0);
		}
		assertEquals(0,g.score());
	}
	
	@Test
	public void testAllOnes1() {
		g = new Game();
		for(int i = 0; i < 20; i++) {
			g.roll(1);
		}
		assertEquals(20,g.score());
	}
	
	@Test
	public void testAllOnes() {
		rollMany(20,1);
	}
	
	private void rollMany(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	@Ignore("until we walk frame by frame")
	@Test
	public void testOneSpare() {
		g.roll(5);
		g.roll(5);//spare
		g.roll(3);
		rollMany(17,0);
		assertEquals(16,g.score());
	}
	
	
	
}
