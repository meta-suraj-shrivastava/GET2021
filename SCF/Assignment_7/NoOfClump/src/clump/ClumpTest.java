package clump;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClumpTest {
	Clump clump = new Clump();
	@Test
	public void test() {
		int [] testCaseOne = {1,1,1,3,3,4};
		int [] testCaseTwo = {0,10,1,3,3,4};
		assertEquals(clump.countClump(testCaseOne, 6),2);
		assertEquals(clump.countClump(testCaseTwo, 6),1);
	}
	
	@Test
	public void testTwo() {
		int [] testCaseOne = {};
		assertEquals(clump.countClump(testCaseOne, 0),0);
	}

}
