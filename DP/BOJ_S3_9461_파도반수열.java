package BOJ.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S3_9461_파도반수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer = new StringBuilder();
	
	static int T;
	static long[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		dp = new long[101];
		
		// 0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9 
		// dp[i] = dp[i-3] + dp[i-2]
		
		dp[1] = 1;
		dp[2] = 1;
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			dfs(N);
			
			answer.append(dp[N]).append("\n");
		}
		
		System.out.println(answer);
	}
	
	static long dfs(int N) {
		// 3 이하인 경우 수열 값 리턴
		if(N < 3) {
			return dp[N];
		}
		
		// 수열의 값이 있다면 해당 값 리턴
		if(dp[N] != 0) {
			return dp[N];
		}
		
		
		return dp[N] = dfs(N-3) + dfs(N-2);
	}
	
	

}
