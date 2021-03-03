package stringsMethods;

/*
 * Contains all the methods related to strings
 */

public class StrMethods {
	
/*
 * params :- two strings
 * returns :- 1 if both strings are equal else 0
 */
int equals(String one,String two){
	int lenOne = one.length();
	int lenTwo = two.length();
	if(lenTwo!=lenOne){
		return 0;
	}
	else{
		for(int index=0;index<lenOne;index++){
			if(one.charAt(index)!=two.charAt(index)){
				return 0;
			}
		}
		return 1;
	}
}

/*
 * params :- string
 * return:- reverse of string
 */
String reverse(String str){
	int len = str.length();
	String rev = "";
	for(int index=len-1;index>=0;index--)
		rev+=str.charAt(index);
	return rev;
}

/*
 * params :- string
 * return :- string with Interchanged letter case
 */
String interChangeCase(String str){
	String result = "";
	for(int index=0;index<str.length();index++){
		if(str.charAt(index)==' '){
			result+=" ";
		}
		else if(str.charAt(index)>='a' && str.charAt(index)<='z'){
			result += (char)(str.charAt(index)-32);
		}
		else{
			result += (char)(str.charAt(index)+32);
		}
	}
	return result;
}

/*
 * param :-  string
 * return:- the largest word in a string
 */
String largestWord(String line){
	String largestWord = "";
	String[] words = line.split(" ");
	for(String word:words){
		if(word.length()>=largestWord.length()){
			largestWord = word;
		}
	}
	return largestWord;
}

}
