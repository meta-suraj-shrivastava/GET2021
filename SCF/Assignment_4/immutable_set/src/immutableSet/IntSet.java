package immutableSet;
import java.util.ArrayList;

public final class IntSet {

	private ArrayList<Integer> set = new ArrayList<>();
	
	//constructor initializing the set with given data
	IntSet(ArrayList<Integer> arr){
		for(int data:arr){
			if(!set.contains(data))
				set.add(data);
		}
	}
	
	//return the set
	ArrayList<Integer> getSet(){
		return set;
	}
	
	//take a integer argument and check it is a part of set or not
	boolean isMember(int element){
		for(int data:set){
			if(data==element)
				return true;
		}
		return false;
	}
	
	//return the size of the set
	int size(){
		return set.size();
	}
	
	//return boolean value true if given set is a subset or vice-versa
	boolean isSubset(IntSet s){
		return set.containsAll(s.getSet());
	}
	
	//Complement of the set taking union set from 1 to 1000
	ArrayList<Integer> getComplement(){
		ArrayList<Integer> complementSet = new ArrayList<>();
		for(int index=0;index<=1000;index++){
			if(!set.contains(index))
				complementSet.add(index);
		}
		return complementSet;
	}
	
	//take two set and return union
	ArrayList<Integer> union(IntSet s1,IntSet s2){
		ArrayList<Integer> union = new ArrayList<>();
		for(int data:s1.getSet()){
				union.add(data);
		}
		for(int data:s2.getSet()){
			if(!union.contains(data))
				union.add(data);
	}
		return union;
	}
	
}
