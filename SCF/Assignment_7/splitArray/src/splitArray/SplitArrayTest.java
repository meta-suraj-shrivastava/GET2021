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

}
