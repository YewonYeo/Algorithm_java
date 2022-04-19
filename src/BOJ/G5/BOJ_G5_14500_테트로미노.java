package BOJ.G5;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  dfs 로 가능한 모양 : ㅜ 빼고
 *  4번 탐색 후 최대값 갱신
 * 	ㅜ 모양: + 모양으로 구한 후 각 날개를 하나씩 뺀 것 중 최대 값
 * 
 * */

public class BOJ_G5_14500_테트로미노 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		max = Integer.MIN_VALUE;
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료
		
		// 탐색 시작
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				// dfs 로 ㅜ 모양 제외한 탐색
				visited[r][c] = true;
				dfs(r, c, 1, map[r][c]);
				visited[r][c] = false;
				// ㅜ 모양 탐색
				exception(r, c);
			}
		}
		
		System.out.println(max);
		
		


	}
	
	private static void dfs(int r, int c, int depth, int sum) {
		if(depth >= 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, depth+1, sum+map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
	
	private static void exception(int r, int c) {
		int sum = map[r][c];
		int wing = 4;
		int min = Integer.MAX_VALUE;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(wing <= 2) return;
			
			if(!isIn(nr, nc)) {
				wing--;
				continue;
			}
			
			min = Math.min(min, map[nr][nc]);
			sum += map[nr][nc];
		}
		
		if(wing == 4) {
			sum -= min;
		}
		
		max = Math.max(max, sum);
	}
	
	private static boolean isIn(int nr, int nc) {
		return nr < R && nc < C && nr>=0 && nc >= 0;
	}
	
	private static String src = "4 10\r\n" + 
			"1 2 1 2 1 2 1 2 1 2\r\n" + 
			"2 1 2 1 2 1 2 1 2 1\r\n" + 
			"1 2 1 2 1 2 1 2 1 2\r\n" + 
			"2 1 2 1 2 1 2 1 2 1";

}
