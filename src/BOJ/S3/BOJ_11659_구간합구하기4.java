package BOJ.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int N, M;
	static int[]arr;
	static int[]dp;
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[100001];
		dp = new int[100001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// S(n) = S(n-1) + A(n)
		for(int i = 1; i <= N; i++) {
			dp[i] = dp[i-1] + arr[i];
		}
		
		// S(i, j) = S(i) - S(j-1)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			answer.append(dp[end]-dp[start-1]).append("\n");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);


	}
	private static String src = "5 3\r\n" + 
			"5 4 3 2 1\r\n" + 
			"1 3\r\n" + 
			"2 4\r\n" + 
			"5 5";

}
