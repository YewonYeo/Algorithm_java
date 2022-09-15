package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G5_2493_탑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int N;
	static Stack<Top> tops;
	static Stack<Top> temp = new Stack<Top>();
	
	static class Top{
		int index, height;
		
		public Top(int index, int height) {
			this.index = index;
			this.height = height;
		}

		@Override
		public String toString() {
			return "Top [index=" + index + ", height=" + height + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		tops = new Stack<Top>();
		int[] index = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tops.add(new Top(i+1, Integer.parseInt(st.nextToken())));
		}
		 
		while(!tops.isEmpty()) {
			// 왼쪽 탑에서 꺼낸다.
			Top Current = tops.pop();
			temp.push(Current);
			
			while(!temp.isEmpty()) {
				// 왼쪽 탑이 높이가 더 크다면 꺼내서 해당 자리에 왼쪽 탑의 인덱스를 추가
				if(tops.isEmpty()) break;
				
				if(temp.peek().height < tops.peek().height) {
					index[temp.peek().index] = tops.peek().index;
					temp.pop();
				}else {
					break;
				}
			
			}
		}
		
		for(int i = 1; i <= N; i++) {
			answer.append(index[i]).append(" ");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
	}
	
	private static String src = "5\n" + 
			"6 9 5 7 4";

}
