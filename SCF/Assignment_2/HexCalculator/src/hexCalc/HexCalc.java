package hexCalc;

/*
 * Perform basic arithmetic operations between two hexa decimal numbers
 * with the help of following methods :-
 * 1.add :- return addition of two hexa decimal number
 * 2.subtract :- return difference    ""    ""
 * 3.multiply :- return multiplication  ""    ""
 * 4.divide :- return division  ""     ""
 * 5.equals :- return true if both are equal
 * 6.isGreater :- return true if first arg. is greater 
 * 7.isLesser :- return true if first arg. is lesser
 */
public class HexCalc {
	
String add(String numberOne,String numberTwo){
	Convertor con = new Convertor();
	int numOne = con.hexToDecimal(numberOne);
	int numTwo = con.hexToDecimal(numberTwo);
	int result = numOne + numTwo;
	return con.decimalToHex(result);
} 
String subtract(String numberOne,String numberTwo){
	Convertor con = new Convertor();
	int numOne = con.hexToDecimal(numberOne);
	int numTwo = con.hexToDecimal(numberTwo);
	int result = numOne - numTwo;
	if(result<0)
		return '-'+con.decimalToHex(result-2*result);
	else
		return con.decimalToHex(result);
}
String multiply(String numberOne,String numberTwo){
	Convertor con = new Convertor();
	int numOne = con.hexToDecimal(numberOne);
	int numTwo = con.hexToDecimal(numberTwo);
	int result = numOne * numTwo;
	return con.decimalToHex(result);
}
String[] divide(String numberOne,String numberTwo){
	Convertor con = new Convertor();
	String[] finalResult = new String[2];
	int numOne = con.hexToDecimal(numberOne);
	int numTwo = con.hexToDecimal(numberTwo);
	int quot = numOne/numTwo;
	int rem = numOne%numTwo;
	finalResult[0]= con.decimalToHex(quot);
	finalResult[1]= con.decimalToHex(rem);
	return finalResult;

}
boolean equals(String numberOne,String numberTwo){
	return numberOne == numberTwo;
}
boolean isGreater(String numberOne,String numberTwo){
	if(numberOne.length()>numberTwo.length()){
		return true;
	}
	else{
		if(numberOne.compareTo(numberTwo)==1)
			return true;
		else
			return false;
	}
}
boolean isLesser(String numberOne,String numberTwo){
	if(numberOne.length()<numberTwo.length()){
		return true;
	}
	else{
		if(numberOne.compareTo(numberTwo)==-1)
			return true;
		else
			return false;
	}
}
}
