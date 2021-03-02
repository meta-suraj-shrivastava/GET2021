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
		for(int number=10;number<16;number++){ // Converting number 10 to 16 to hexadecimal 
			char key;
			key = (char)(65+number%10);
			hexCodeToDecimal.put(key, number);
				
		}
	}
	
	//taking hexadecimal digit as string and returning decimal representation 
	int hexToDecimal(String digit){
		int length = digit.length();
		int result=0;
		for(int index=0;index<length;index++){
		if(digit.charAt(index)>='0' && digit.charAt(index)<= '9'){
			result+=(digit.charAt(index)-'0')*Math.pow(base, length-index-1);
		}
		else
			result+=hexCodeToDecimal.get(digit.charAt(index))*Math.pow(base,length-index-1);
		}
		return result;
	}
	
	//taking decimal digit of integer type and returning hexadecimal representation
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
