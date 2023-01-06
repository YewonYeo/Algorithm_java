package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_16194_카드구매하기2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] dp;
	static int[] packs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// del
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		packs = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			packs[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N == 1) {
			System.out.println(packs[0] * N);
			System.exit(0);
		}
		
		// dp[i] = i개의 카드를 살 때 최소 금액
		// 카드 i개를 사는 방법 = 1개 구매 + (i-1)	개 구매 , 2개 구매 + (i-2)개 구매 , ... , i개 구매
		
				
		for(int i = 1; i <= N; i++) {
			dp[i] = packs[i];
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j]+packs[j]);
			}
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
		
	}
	private static String src = "10\n" + 
			"5 10 11 12 13 30 35 40 45 47";

}
