package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2565_전깃줄 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static Wire[] wire;
	static int[]dp;
	
	static class Wire implements Comparable<Wire>{
		int a, b;
		
		public Wire(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Wire o) {
			return this.a - o.a;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		wire = new Wire[N];
		dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wire[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(wire);
		
		for(int i = 0; i <N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(wire[i].b > wire[j].b) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N - max);
	}
	private static String src = "8\n" + 
			"1 8\n" + 
			"3 9\n" + 
			"2 2\n" + 
			"4 1\n" + 
			"6 4\n" + 
			"10 10\n" + 
			"9 7\n" + 
			"7 6";

}
