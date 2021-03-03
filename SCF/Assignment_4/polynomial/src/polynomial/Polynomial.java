package polynomial;
import java.util.ArrayList;
public final class Polynomial {
final ArrayList<Integer> poly = new ArrayList<>();
	
	Polynomial(int [] polynomial){
		for(int coff:polynomial)
		poly.add(coff);
	}
	
	
	//return the polynomial
	ArrayList<Integer> getPoly(){
		return poly;
	}
	
	//take a float value and evaluate the polynomial and return the result
	float evaluate(float value){
		float result = 0;
		int deg = degree();
		for(int coff : poly)
			result+=coff*Math.pow(value, deg--);
		return result;
	}
	
	//return the degree of polynomial
	int degree(){
		return poly.size()-1;
	}
	
	//takes two polynomial as input and return the addition of those polynomial
	int[] addPoly(Polynomial p1, Polynomial p2){
		ArrayList<Integer> polyOne = p1.getPoly();
		ArrayList<Integer> polyTwo = p2.getPoly();
		int degOne = p1.degree();
		int degTwo = p2.degree();
		int max = degOne>=degTwo?degOne:degTwo;
		int[] result = new int[max+1];
		while(degOne>-1 && degTwo>-1){
			result[max--]=polyOne.get(degOne--)+polyTwo.get(degTwo--);
		}
		while(degOne>-1){
			result[max--]=polyOne.get(degOne--);
		}
		while(degTwo>-1){
			result[max--]=polyOne.get(degTwo--);
		}
		return result;
		
	}
	
	
	//takes two polynomial as input and return the multiplication of those polynomial
	int[] multiply(Polynomial p1,Polynomial p2){
		int degOne = p1.degree();
		int degTwo = p2.degree();
		ArrayList<Integer> polyOne = p1.getPoly();
		ArrayList<Integer> polyTwo = p2.getPoly();
		int[] product = new int[degOne+degTwo+1];
		for(int polyOneIndex=0;polyOneIndex<=degOne;polyOneIndex++){
			for(int polyTwoIndex=0;polyTwoIndex<=degTwo;polyTwoIndex++){
				product[polyOneIndex+polyTwoIndex] += polyOne.get(polyOneIndex)*polyTwo.get(polyTwoIndex);
			}
		}
		return product;
	}
}
 