package hexCalc;

import java.util.HashMap;
public class HexCalc {
	static final HashMap<Character,Integer> hexCode = new HashMap<Character,Integer>(); 
	HexCalc(){
		for(int i=1;i<=16;i++){
			char key;
			if(i>=1 && i<=9)
				key = Character.toChars(i)[0];
			else
				key = (char)(65+i%10);
			hexCode.put(key, i);
				
		}
	}
	
String add(String numberOne,String numberTwo){
	int lengthOne = numberOne.length();
	int lengthTwo = numberTwo.length();
	
	System.out.println(hexCode);
	String result="";
	int carry = 0;
	while(lengthOne>0){
		System.out.println(hexCode.get(numberOne.charAt(lengthOne-1))+" "+numberTwo.charAt(lengthTwo-1));
		int addResult =carry + hexCode.get(numberOne.charAt(lengthOne-1))+hexCode.get(numberTwo.charAt(lengthTwo-1));
		carry = addResult/10;
		result=addResult%10+result;
		lengthOne--;
	}
	return result;
} 
}
