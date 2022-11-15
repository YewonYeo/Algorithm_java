package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_S1_1890_점프 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long [N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int jump = map[r][c];
				
				if(jump == 0) break;
				
				if(c + jump < N) {
					dp[r][c+jump] += dp[r][c];
				} 
				
				if (r + jump < N) {
					dp[r+jump][c] += dp[r][c];
				}
			}
			
		}
		
		System.out.println(dp[N-1][N-1]);
	}
	private static String src = "4\n" + 
			"2 3 3 1\n" + 
			"1 2 1 3\n" + 
			"1 2 3 1\n" + 
			"3 1 1 0";

}
