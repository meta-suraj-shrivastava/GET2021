package StackImp;

public class MyStack {

	private int top = -1;
	private int MAXSIZE = 100;
	private char[] charStack = new char[MAXSIZE];
	private int[] intStack = new int[MAXSIZE];
	
	String push(char operator){
		if(top == MAXSIZE){
			return "OverFlow";
		}
		else{
			charStack[++top] = operator;
		}
		return "Sucess";
	}
	
	String push(int number){
		if(top == MAXSIZE){
			return "OverFlow";
		}
		else{
			intStack[++top] = number;
		}
		return "Sucess";
	}
	
	char opPop(){
		char op = charStack[top];
		top--;
		return op;
	}
	
	int intPop(){
		
		int op = intStack[top];
		top--;
		return op;
	}
	
	char opPeek(){
		return charStack[top];
	}
	
	int intPeek(){
		return intStack[top];
	}
	
	boolean opEmpty(){
		return top == -1?true:false;
	}
	
	boolean intEmpty(){
		return top == -1?true:false;
	}

	
}
