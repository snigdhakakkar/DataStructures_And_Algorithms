package Strings;

import java.util.Stack;

/*
 * We will use two stacks - one for operands and another for operators
 * Read the expression string left to right one by one
 * If operand comes, push into operand stack else push into operator stack
 * If it is an operator, check if last element is an open bracket, push current one into stack
 * If last operator >= current operator, pop last operator and two operands, calculate them and 
 * find the result and push the result into operands stack. Push the new operator into operators stack.
 * If last operator < current operator, push current one into operator stack.
 * If closing bracket comes, pop and solve the operation till open bracket comes.
 * If end index comes, and operator stack is not empty, pop and solve until stack is empty.
 * Final result is in operand stack, pop it.
 */
public class InfixExpressionEvaluation {
	
	private static final String divideByZero = "Can't divide by zero.";
	
	public static void main(String[] args) {
		InfixExpressionEvaluation a = new InfixExpressionEvaluation();
		//single digit expression
		String Math_exp = "2^3+1+(5-3*6/2)";
		System.out.println(Math_exp);
		System.out.println(a.evaluate(Math_exp));
		
		//multiple digit expression
		String Math_exp1 = "2^3+16+1000 +(5-3*6/2)";
		System.out.println(Math_exp1);
		System.out.println(a.evaluate(Math_exp1));
		
		//floating point expression
		String Math_exp2 = "2^3+16.05+1000 +(5-3*6/2)";
		System.out.println(Math_exp2);
		System.out.println(a.evaluate(Math_exp2));
		
		//handle divide by zero
		String Math_exp3 = "2^3+16.05+1000 +(5-3*6/0)";
		System.out.println(Math_exp3);
		System.out.println(a.evaluate(Math_exp3));
	}
	
	public String evaluate(String exp) {
		Stack<Double> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		
		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			
			if(Character.isDigit(ch)) {
				
				String value = "";
				while(i < exp.length()) {
					if(Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.') {
						value += exp.charAt(i++);
					}
					else {
						break;
					}
				}
				i--;
				operands.push(Double.parseDouble(value+""));
			}
			
			else if (ch=='(') {
				operators.push(ch);
			}
			
			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
				//if operator comes, then check
				if(operators.isEmpty()) {
					operators.push(ch);
				} 
				else if (operators.peek() == '(') {
					operators.push(ch);
				} 
				else if (getPrecedence(operators.peek()) >= getPrecedence(ch)) {
					char op = operators.pop();
					double num2 = operands.pop();
					double num1 = operands.pop();
					Object value = calculate(num1, num2, op);
					
					if (value instanceof String) {
						return divideByZero;
					}
					operands.push((double)value);
					operators.push(ch);
				} 
				else {
					operators.push(ch);
				}
			}
			
			else if(ch == ')') {
				while(operators.peek() != '(') {
					char op = operators.pop();
					double num2 = operands.pop();
					double num1 = operands.pop();
					Object value = calculate(num1, num2, op);
					
					if (value instanceof String) {
						return divideByZero;
					}
					operands.push((double)value);
				}
				operators.pop();
			}
		}
		
		//end of  loop
		while(operators.size() != 0) {
			char op = operators.pop();
			double num2 = operands.pop();
			double num1 = operands.pop();
			Object value = calculate(num1, num2, op);
			
			if (value instanceof String) {
				return divideByZero;
			}
			operands.push((double)value);
		}
		
		return operands.pop().toString();
	}
	
	private int getPrecedence(char ch) {
		
		if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '^') {
			return 3;
		} else if (ch == '(' || ch == ')') {
			return 4;
		} else
		return 0;
	}
	
	private Object calculate(double num1, double num2, char operator) {
		
		switch(operator) {
		case '+': return num1 + num2;
		case '-': return num1 - num2;
		case '*': return num1 * num2;
		case '/': 
			if(num2 == 0) {
				return divideByZero;
			} else 
				return num1 / num2;
		case '^': return Math.pow(num1, num2);
		default: return 0;
		}
	}
}
