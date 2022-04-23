package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_1932_정수삼각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] triangle, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		N = Integer.parseInt(br.readLine());
		triangle = new int[N][N];
		dp = new int[N][N];
		int i = 1;
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < i; c++) {
				triangle[r][c] = Integer.parseInt(st.nextToken());
			}
			i++;
		}
		
		// 입력완료
		
		// 각 행의 0열, 끝열 초기화
		for(int r = 0; r < N; r++) {
			if(r== 0) {
				dp[r][0] = triangle[r][0];
				continue;
			}
			dp[r][0] = dp[r-1][0] + triangle[r][0];
			dp[r][r] = dp[r-1][r-1] + triangle[r][r];
			
		}
	
		for(int r = 2; r < N; r++) {
			for(int c = 1; c <= r-1; c++) {
				dp[r][c] = (Math.max(dp[r-1][c-1], dp[r-1][c]) + triangle[r][c]);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int j = 0; j < N; j++) {
			max = Math.max(dp[N-1][j], max);
		}
		
		System.out.println(max);
		
	}
	
	private static String src = "5\r\n" + 
			"7\r\n" + 
			"3 8\r\n" + 
			"8 1 0\r\n" + 
			"2 7 4 4\r\n" + 
			"4 5 2 6 5";

}
