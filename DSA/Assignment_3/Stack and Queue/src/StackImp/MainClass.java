package StackImp;

import java.util.Scanner;

public class MainClass {

	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Expression :");
		String exp = sc.nextLine();
		System.out.println("Ans :"+evaluate(exp));
	}
	
	
	public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'values'
        MyStack values = new MyStack();
 
        // Stack for Operators: 'ops'
        MyStack ops = new MyStack();
 
        for (int i = 0; i < tokens.length; i++)
        {
             
            // Current token is a 
            // whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 
            // Current token is a number, 
            // push it to stack for numbers
            if (tokens[i] >= '0' && 
                 tokens[i] <= '9')
            {
                StringBuffer sbuf = new
                            StringBuffer();
                 
                // There may be more than one 
                // digits in number
                while (i < tokens.length && 
                        tokens[i] >= '0' && 
                          tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.
                                      toString()));
                  i--;
            }
 
            // Current token is an opening brace, 
            // push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            // Closing brace encountered, 
            // solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.opPeek() != '(')
                  values.push(applyOp(ops.opPop(), 
                                   values.intPop(), 
                                 values.intPop()));
                ops.opPop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' || 
                     tokens[i] == '-' ||
                     tokens[i] == '*' || 
                        tokens[i] == '/')
            {
                while (!ops.isEmpty() && hasPrecedence(tokens[i],ops.opPeek()))
                		values.push(applyOp(ops.opPop(),values.intPop(),values.intPop()));
 
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }
 
        // Entire expression has been 
        // parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.isEmpty())
            values.push(applyOp(ops.opPop(), 
                             values.intPop(), 
                           values.intPop()));
 
        // Top of 'values' contains 
        // result, return it
        return values.intPop();
    }
 
    // Returns true if 'op2' has higher 
    // or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && 
            (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
	 public static int applyOp(char op,int b, int a) {
		 
		 switch (op){
		 	case '+':
		 		return a + b;
		 	case '-':
		 		return a - b;
		 	case '*':
		 		return a * b;
		 	case '/':
		 		if (b == 0)
		 			throw new
		 			UnsupportedOperationException(
		 					"Cannot divide by zero");
		 		return a / b;
		 }
		 return 0;
	 	}
	 
	 
	}
