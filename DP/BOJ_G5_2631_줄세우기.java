package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_G5_2631_줄세우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int[] dp, numbers;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		numbers = new int [N];
		dp = new int[N]; // dp[i] : i번째 수를 끝으로 하는 최장 길이
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(numbers[j] < numbers[i] && dp[i] < dp[j] + 1 ) {
					dp[i] = dp[j] + 1;
				}
			}
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(Arrays.toString(dp));
		
		System.out.println(N-max);
	}

}
