package BOJ.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_2579_계단오르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 풀이 1
		int n = Integer.parseInt(br.readLine());
		
		int[] stairs = new int[301];
		int[]dp = new int[301]; 
		
		for(int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		
		
		dp[1] = stairs[1];
		dp[2] = stairs[1] + stairs[2];
		dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
		
		for(int i = 4; i <= n; i++) {
			dp[i] = Math.max(dp[n-3]+stairs[n-1], dp[n-2]) + stairs[i];
			
		}

		System.out.println(dp[n]);
		
		// 풀이 2
		/*
		int n = Integer.parseInt(br.readLine());
		int[] stairs = new int[301];
		int[][]dp = new int[301][3]; // dp[i][j] = i번째 계단을 j번 연속해서 오른 경우
		
		for(int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][1] = stairs[1]; dp[1][2] = 0; dp[2][1] = stairs[2]; dp[2][2] = stairs[1]+stairs[2];
		
		for(int i = 3; i <= n; i++) {
			dp[i][1] = Integer.max(dp[i-2][1], dp[i-2][2]) + stairs[i];
			dp[i][2] = dp[i-1][1] + stairs[i];
		}
		
		if(n == 1) {
			System.out.println(stairs[n]);
		}else {
			System.out.println(Integer.max(dp[n][1], dp[n][2]));
		}
		
		*/
	}

}
