package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_11722_가장긴감소하는부분수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] arr, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N]; // i번째 원소가 끝인 수열의 길이
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 입력완료
		int max = 0;
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[i] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
			if(max < dp[i]) max = dp[i];
			
		}
		
		System.out.println(max);

	}
	private static String src = "6\r\n" + 
			"10 30 10 20 20 10";

}
