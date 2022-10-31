package BOJ.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import org.omg.CORBA.Current;

public class BOJ_G3_1937_욕심쟁이판다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] map;
	static int[][] dp;
	static int[][] deltas = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
	static boolean[][] visited;
	static int N, answer;
	
	static class Point{
		int r, c, distance;
		
		public Point(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", distance=" + distance + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// del
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		visited = new boolean[N][N];
		
		answer = Integer.MIN_VALUE;
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				answer = Math.max(answer, dfs(r, c));
			}
		}
		
		System.out.println(answer);
		
		
		

	}
	
	static int dfs(int startR, int startC) {
		
		// 방문한 적이 있는 경우 해당 값 리
		if(dp[startR][startC] != 0) {
			return dp[startR][startC];
		}
		
		// 현재 자리에서 1칸은 갈 수 있으므로 할당
		dp[startR][startC] = 1;
		
		for(int d = 0; d < 4; d++) {
			int nr = startR + deltas[d][0];
			int nc = startC + deltas[d][1];
			
			// 범위 내에 있
			if(isIn(nr, nc)) {
				// 갈 수 있는 칸인 경우
				if(map[startR][startC] < map[nr][nc]) {
					// 현재 칸의 최대는 다음 칸의 최대값 + 1
					dp[startR][startC] = Math.max(dp[startR][startC], dfs(nr, nc)+1);
					dfs(nr, nc);
				}
			}else {
				continue;
			}
		}
		
		return dp[startR][startC];
		
	
		
		
		
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	
	private static String src = "4\n" + 
			"14 9 12 10\n" + 
			"1 11 5 4\n" + 
			"7 15 2 13\n" + 
			"6 3 16 8";

}
