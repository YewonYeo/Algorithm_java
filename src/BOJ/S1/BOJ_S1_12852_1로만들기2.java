package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_S1_12852_1로만들기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		int[] nums = new int[N+1];
		
		dp[1] = 0; nums[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			nums[i] = i-1;
			
			if(i % 3 == 0 && dp[i] > dp[i/3]+1) {
				dp[i] = dp[i/3] + 1;
				nums[i] = i/3; 
			}else if(i % 2 == 0 && dp[i] > dp[i/2]+1) {
				dp[i] = dp[i/2] + 1;
				nums[i] = i/2;
			}
			
		}
		answer.append(dp[N]).append("\n");
		answer.append(N).append(" ");
		for(int i = N; ; ) {
			if(i == 1) break;
			answer.append(nums[i]).append(" ");
			i = nums[i];
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);

	}

}
