package BOJ.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S3_1874_스택수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int prev = 0;
		
		for(int i = 0; i < N; i++) {
			
			int number = Integer.parseInt(br.readLine());
			
			if(prev < number) {
				for(int j = prev+1; j <= number; j++) {
					stack.push(j);
					answer.append("+").append("\n");
				}
				prev = number;
			}
			
			if(stack.peek() != number) {
				System.out.println("NO");
				System.exit(0);
			}
			
			stack.pop();
			answer.append("-").append("\n");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);

	}

}
