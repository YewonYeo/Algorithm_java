package BOJ.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_B2_17608_막대기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		int max = 0;
		while(!stack.isEmpty()) {
			if(stack.peek() > max) {
				max = stack.peek();
				cnt++;
			}
			stack.pop();
		}
		
		System.out.println(cnt);
	}
}
