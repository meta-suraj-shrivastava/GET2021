package noOfUniqueChar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// this class provide methods to find no of unique character in a string
public class UniqueChar {
	private List<Character> list;
	private HashMap<String,Integer> map;
	
	public UniqueChar() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}
	
	//this method will return number of unique character and also stores the result for future strings
	//@param - string
	public int numberOfUniqueChar(String string){
		HashMap<Character,Integer> tmpMap = new HashMap<>();
		
		//checking if this string have been processed before or not of processed then return the
		//stored result
		if(map.containsKey(string)){
			return map.get(string);
		}
		for(Character character:string.toCharArray()){
			if(tmpMap.containsKey(character)){
				list.remove(character);
			}
			else{
				list.add(character);
				tmpMap.put(character,1);
			}
		}
		int uniqueChar = list.size();
		list.clear();
		map.put(string,uniqueChar); //storing for future use
		return uniqueChar;
	}
}
