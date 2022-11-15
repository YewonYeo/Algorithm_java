package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class BOJ_S1_2504_괄호의값 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<String> stack;
	static int smallBracket, bigBracket;
	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		String input = br.readLine();
		stack = new Stack<String>();
		
		for(int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			
			switch(temp) {
			// 여는 괄호인 경우 스택에 넣는다
			case '(':
				smallBracket++;
				stack.push("(");
				break;
			
			// 닫는 ) 괄호인 경우 
			case ')':
				smallBracket--;
				
				if(smallBracket > -1) {
					// 직전 괄호가 여는( 괄호인 경우 숫자 2를 넣는다
					if(stack.peek().equals("(")) {
						stack.pop();
						stack.push("2");
					}
					else {
						int smallSum = 0;
						while(!stack.isEmpty()) {
							if(stack.peek().equals("[")) {
								System.out.print(0);
								System.exit(0);
							}else if(stack.peek().equals("(")) {
								stack.pop();
								smallSum *= 2;
								stack.push(String.valueOf((smallSum)));
								break;
							}else {
								smallSum += Integer.parseInt(stack.pop());
							}
						}
						
						
					}
				}
				break;
				
			case '[':
				bigBracket++;
				stack.push("[");
				break;
				
			case ']':
				bigBracket--;
				
				if(bigBracket > -1) {
					if(stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					}else{
						int bigSum = 0;
						while(!stack.isEmpty()) {
							if(stack.peek().equals("(")) {
								System.out.print(0);
								System.exit(0);
							}else if(stack.peek().equals("[")) {
								stack.pop();
								bigSum *= 3;
								stack.push(String.valueOf(bigSum));
								break;
							}else {
								bigSum += Integer.parseInt(stack.pop());
							}
							
						}
					}
					
					
				}
				break;
			}
			if(bigBracket < 0 || smallBracket < 0) {
				System.out.print(0);
				System.exit(0);
			}
			
			
				
			
		}
		
		if(bigBracket != 0 || smallBracket != 0) {
			System.out.print(0);
			System.exit(0);
		}
		
		int answer = 0;
		
		while(!stack.isEmpty()) {
			answer += Integer.parseInt(stack.pop());
		}
	        
	   System.out.println(answer);
		
		
		
		

	}
	private static String src = "[][]((])";

}
