package StackImp;


//this class provide basic methods to perform operation  on stack
public class MyStack {

	private int top = -1;
	private int MAXSIZE = 100;
	private char[] charStack = new char[MAXSIZE];
	private int[] intStack = new int[MAXSIZE];
	
	
	//insert the character item in stack
	String push(char operator){
		if(top == MAXSIZE){
			return "OverFlow";
		}
		else{
			charStack[++top] = operator;
		}
		return "Sucess";
	}
	
	
	//insert integer item in stack
	String push(int number){
		if(top == MAXSIZE){
			return "OverFlow";
		}
		else{
			intStack[++top] = number;
		}
		return "Sucess";
	}
	
	//return and delete character element from charStack
	char opPop(){
		char op = charStack[top];
		top--;
		return op;
	}
	
	//return and delete integer element from intStack
	int intPop(){
		
		int op = intStack[top];
		top--;
		return op;
	}
	
	
	//return the character element from stack
	char opPeek(){
		return charStack[top];
	}
	
	
	//return the integer element from stack
	int intPeek(){
		return intStack[top];
	}
	
	
	//return true if the stack is empty
	boolean isEmpty(){
		return top == -1?true:false;
	}

	
}
