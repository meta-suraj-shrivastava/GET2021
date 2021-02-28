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
		int deg = poly.size();
		for(int coff : poly)
			result+=coff*Math.pow(value, deg--);
		return result;
	}
	
	int degree(){
		return poly.size();
	}
	
	ArrayList<Integer> addPoly(Polynomial p1, Polynomial p2){
		ArrayList<Integer> polyOne = p1.getPoly();
		ArrayList<Integer> polyTwo = p2.getPoly();
		if(p1.degree()>=p2.degree()){
			for(int i=p2.degree()-1;i>=0;i--){
				polyOne.set(i, polyOne.get(i)+polyTwo.get(i));
			}
			return polyOne;
		}
		else{
			for(int i=p1.degree()-1;i>=0;i--){
				polyTwo.set(i, polyOne.get(i)+polyTwo.get(i));
			}
			return polyTwo;
		}
	}
}
