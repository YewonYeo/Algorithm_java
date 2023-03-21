package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_1912_연속합 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, max;
	static int[] numbers, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		dp = new int[N];
		// dp[i] = i번째 수 까지 고려했을 때 최대 값
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dp[0] = numbers[0];
		max = dp[0];
		
		for(int i = 1; i < N; i++) {
			// i-1 까지 연속된 수에 현재 수를 더하기 or 현재 수부터 새로 시작
			dp[i] = Math.max(dp[i-1]+numbers[i], numbers[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	private static String src = "5\n" + 
			"-1 -2 -3 -4 -5";

}
