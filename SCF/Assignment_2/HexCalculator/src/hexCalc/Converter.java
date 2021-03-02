package hexCalc;
import java.util.HashMap;
/*
 * Helps to covert decimal to hexa decimal or vice versa with the help of two methods
 * 1. hexToDecimal
 * 2. decimalToHex
 */


public class Converter {

	static final char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	static final HashMap<Character,Integer> hexCodeToDecimal = new HashMap<Character,Integer>();
	int base = 16;
	/*Constructor can be use to make this class work for any base
	 * Converter(int userBase){
	 * base = userBase;
	 * }
	 */
	Converter(){
		for(int i=10;i<16;i++){ // Converting 10 to 16 to hexadecimal 
			char key;
			key = (char)(65+i%10);
			hexCodeToDecimal.put(key, i);
				
		}
	}
	
	int hexToDecimal(String digit){
		int length = digit.length();
		int result=0;
		for(int i=0;i<length;i++){
		if(digit.charAt(i)>='0' && digit.charAt(i)<= '9'){
			result+=(digit.charAt(i)-'0')*Math.pow(base, length-i-1);
		}
		else
			result+=hexCodeToDecimal.get(digit.charAt(i))*Math.pow(base,length-i-1);
		}
		return result;
	}
	
	String decimalToHex(int digit){
		String result="";
		while(digit>0){
			int rem = digit%16;
			
			result=hex[rem]+result;
			digit = digit/16;
		}
	return result;
	}
	
}
