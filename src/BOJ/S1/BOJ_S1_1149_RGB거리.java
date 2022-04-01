package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_1149_RGB거리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] dp;
	static int[][] house;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		N = Integer.parseInt(br.readLine());
		house = new int[N+1][3]; // 행: 집, 열: rbg
		dp = new int[N+1][3];
		
		for(int r = 1; r <=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c <3; c++) {
				house[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력완료
		
		for(int r = 1; r <= N; r++) {
			for(int c = 0; c < 3; c++) {
				if(c==0) {
					dp[r][c] = Integer.min(dp[r-1][1], dp[r-1][2]) + house[r][c];
				}else if(c == 1) {
					dp[r][c] = Integer.min(dp[r-1][0], dp[r-1][2]) + house[r][c];
				}else {
					dp[r][c] = Integer.min(dp[r-1][0], dp[r-1][1]) + house[r][c];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			if(dp[N][i] < min) {
				min = dp[N][i];
			}
		}
		
		System.out.println(min);


	}
	
	private static String src = "3\r\n" + 
			"26 40 83\r\n" + 
			"49 60 57\r\n" + 
			"13 89 99";

}
