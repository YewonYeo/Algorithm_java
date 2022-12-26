package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_1946_신입사원 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int T, N;
	static People[] input;
	
	static class People implements Comparable<People>{
		int first;
		int second;
		
		public People(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		public int compareTo(People o) {
			return this.first - o.first;
		}		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new People[N];
			int sum = 1;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				input[i] = new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} // 입력완료
			
			Arrays.sort(input);
			int before = input[0].second;
			
			for(int i = 1; i < N; i++) {
				if(input[i].second < before) {
					sum++;
					before = input[i].second;
				}
			}
			
			answer.append(sum).append("\n");
			
		} // t.c
		
		answer.setLength(answer.length()-1);
		System.out.print(answer);

	}
	
	private static String src = "2\n" + 
			"5\n" + 
			"3 2\n" + 
			"1 4\n" + 
			"4 1\n" + 
			"2 3\n" + 
			"5 5\n" + 
			"7\n" + 
			"3 6\n" + 
			"7 3\n" + 
			"4 2\n" + 
			"1 4\n" + 
			"5 7\n" + 
			"2 5\n" + 
			"6 1";

}
