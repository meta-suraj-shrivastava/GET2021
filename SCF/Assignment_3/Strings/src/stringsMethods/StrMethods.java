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
		for(int i=0;i<lenOne;i++){
			if(one.charAt(i)!=two.charAt(i)){
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
	for(int i=len-1;i>=0;i--)
		rev+=str.charAt(i);
	return rev;
}

/*
 * params :- string
 * return :- string with Interchanged letter case
 */
String interChangeCase(String str){
	String result = "";
	for(int i=0;i<str.length();i++){
		if(str.charAt(i)==' '){
			result+=" ";
		}
		else if(str.charAt(i)>='a' && str.charAt(i)<='z'){
			result += (char)(str.charAt(i)-32);
		}
		else{
			result += (char)(str.charAt(i)+32);
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
