package immutableSet;
import java.util.ArrayList;

public final class IntSet {

	private ArrayList<Integer> set = new ArrayList<>();
	IntSet(ArrayList<Integer> arr){
		for(int data:arr){
			if(!set.contains(data))
				set.add(data);
		}
	}
	
	ArrayList<Integer> getSet(){
		return set;
	}
	boolean isMember(int element){
		for(int data:set){
			if(data==element)
				return true;
		}
		return false;
	}
	int size(){
		return set.size();
	}
	
	boolean isSubset(IntSet s){
		return set.containsAll(s.getSet());
	}
	
	
	ArrayList<Integer> getComplement(){
		ArrayList<Integer> complementSet = new ArrayList<>();
		for(int i=0;i<=1000;i++){
			if(!set.contains(i))
				complementSet.add(i);
		}
		return complementSet;
	}
	
	ArrayList<Integer> union(IntSet s1,IntSet s2){
		ArrayList<Integer> union = new ArrayList<>();
		for(int el:s1.getSet()){
				union.add(el);
		}
		for(int el:s2.getSet()){
			union.add(el);
	}
		return union;
	}
	
}
