package splitArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitArrayTest {

	SplitArray splitArray = new SplitArray();
	@Test
	public void test() {
		int[] testCaseOne ={1, 1, 1, 2, 1};
		assertEquals(splitArray.getSplitIndex(testCaseOne, 5),3);
	}
	@Test
	public void testTwo() {
		int[] testCaseOne ={2, 1, 1, 2, 1};
		assertEquals(splitArray.getSplitIndex(testCaseOne, 5),-1);
	}
	@Test
	public void testThree() {
		int[] testCaseOne ={1, 2, 3, 1, 1};
		assertEquals(splitArray.getSplitIndex(testCaseOne, 5),-1);
	}

}
