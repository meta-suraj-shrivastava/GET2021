package polynomial;
import java.util.ArrayList;
public final class Polynomial {
final ArrayList<Integer> poly = new ArrayList<>();
	
	Polynomial(int [] polynomial){
		for(int coff:polynomial)
		poly.add(coff);
	}
	
	ArrayList<Integer> getPoly(){
		return poly;
	}
	float evaluate(float value){
		float result = 0;
		int deg = degree();
		for(int coff : poly)
			result+=coff*Math.pow(value, deg--);
		return result;
	}
	
	int degree(){
		return poly.size()-1;
	}
	
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
}
 