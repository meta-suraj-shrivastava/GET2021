package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionTest {
	Recursion rec = new Recursion();
	
	
	//test method to search an element in the middle of the array
	@Test
	public void binarySearchTestAtMiddle() {
		int [] arr = {0,1,5,6,10};
		int dataToSearch = 5;
		int lowerBound = 0;
		int upperBound = arr.length-1;
		rec.sort(arr);
		assertTrue(rec.binarySearch(arr, dataToSearch, lowerBound, upperBound));
		
	}
	
	//test method to search an element at the end of the array
	@Test
	public void binarySearchTestAtEnd() {
		int [] arr = {0,1,5,6,10};
		int dataToSearch = 10;
		int lowerBound = 0;
		int upperBound = arr.length-1;
		rec.sort(arr);
		assertTrue(rec.binarySearch(arr, dataToSearch, lowerBound, upperBound));
		
	}
	
	//test method to search an element at start of the array
	@Test
	public void binarySearchTestAtStart() {
		int [] arr = {0,1,5,6,10};
		int dataToSearch = 0;
		int lowerBound = 0;
		int upperBound = arr.length-1;
		rec.sort(arr);
		assertTrue(rec.binarySearch(arr, dataToSearch, lowerBound, upperBound));
		
	}
	
	
	
	//test method for negative test case
	@Test
	public void binarySearchTestNotFound() {
		int [] arr = {0,1,5,6,10};
		int dataToSearch = 19;
		int lowerBound = 0;
		int upperBound = arr.length-1;
		rec.sort(arr);
		assertFalse(rec.binarySearch(arr, dataToSearch, lowerBound, upperBound));
		
	}
	
	
	//test method for negative test case for linear search
	@Test
	public void linearSearchTestNotFound() {
		int [] arr = {0,1,5,6,10};
		int dataToSearch = 19;
		assertFalse(rec.linearSearch(arr, dataToSearch));
		
	}
	
	//test method for positive test case for linear search
	@Test
	public void linearSearchTest() {
		int [] arr = {0,1,5,6,10};
		int dataToSearch = 6;
		assertTrue(rec.linearSearch(arr, dataToSearch));
		
	}
	
	
	@Test
	public void lcmTest() {
		int numberOne = 20;
		int numberTwo = 60;
		int actual = rec.findLcm(numberOne, numberTwo);
		
		assertEquals(60,actual);
		
	}
	
	@Test
	public void lcmTestForNegativeValue() {
		int numberOne = -20;
		int numberTwo = 60;
		int actual = rec.findLcm(numberOne, numberTwo);
		
		assertEquals(60,actual);
		
	}
	
	@Test
	public void gcdTest() {
		int numberOne = 8;
		int numberTwo = 12;
		int actual = rec.gcd(numberOne, numberTwo);
		
		assertEquals(4,actual);
		
	}
	
	//positive nQueen testCase
	@Test
	public void nQueenTestSuccess() {
		int numberOfQueens = 4;
		assertTrue(rec.nQueen(numberOfQueens));
		
	}

	//negative nQueen testCase
	@Test
	public void nQueenTestFail() {
		int numberOfQueens = 3;
		assertFalse(rec.nQueen(numberOfQueens));
		
	}
}
