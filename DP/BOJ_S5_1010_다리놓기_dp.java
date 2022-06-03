package BOJ.S5;

import java.io.*;
import java.util.*;

public class BOJ_S5_1010_다리놓기_dp {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder answer = new StringBuilder();
	
	private static int T, N, M;
	private static int[][]dp = new int[31][31];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		
		// nCr = n-1Cr-1 + n-1Cr, nC0 = nCn = 1
		
		T = Integer.parseInt(br.readLine());
		
		for(int n = 1; n<=30; n++) {
			for(int m = 0; m <= 30; m++) {
				if(n==m || m==0) {
					dp[n][m] = 1;
				}else {
				dp[n][m] = dp[n-1][m-1] + dp[n-1][m];
				}
			}
		}
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			answer.append(dp[M][N]).append("\n");
			
		}
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		
	}
	
	private static String src = "3\n" + 
			"2 2\n" + 
			"1 5\n" + 
			"13 29";

}
