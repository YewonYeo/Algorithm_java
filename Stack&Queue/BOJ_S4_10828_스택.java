package BOJ.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S4_10828_스택 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		Stack<Integer> input = new Stack<Integer>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = 0;
			if(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			if (order.equals("push")) {
				input.push(num);
			}else if(order.equals("top")) {
				if(input.isEmpty()) {
					answer.append("-1").append("\n");
				}else {
				answer.append(input.peek()).append("\n");
				}
			}else if(order.equals("pop")) {
				if(input.isEmpty()) {
					answer.append("-1").append("\n");
				}else {
				answer.append(input.pop()).append("\n");
				}
			}else if(order.equals("empty")) {
				if(input.isEmpty()) {
					answer.append("1").append("\n");
				}else {
				answer.append("0").append("\n");
				}
			}else if(order.equals("size")) {
				answer.append(input.size()).append("\n");
			}
		}
		System.out.println(answer);

	}
	private static String src = "7\n" + 
			"pop\n" + 
			"top\n" + 
			"push 123\n" + 
			"top\n" + 
			"pop\n" + 
			"top\n" + 
			"pop";

}
