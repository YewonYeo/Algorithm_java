package BOJ.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_S3_9005_123더하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer = new StringBuilder();
	static int[] dp;
	static int T, n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		// dp = i를 1, 2, 3 으로 나타내는 방법
		T = Integer.parseInt(br.readLine());
		dp = new int[11];
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		
		// dp 채우기
		for(int i = 4; i<=10; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		// tc 마다 해당하는 dp 찾아주기
		for(int t= 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			answer.append(dp[n]).append("\n");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);

	}
	
	private static String src = "3\r\n" + 
			"4\r\n" + 
			"7\r\n" + 
			"10";

}
