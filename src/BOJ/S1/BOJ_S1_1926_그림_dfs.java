package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_S1_1926_그림_dfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int[][] paper;
	static boolean[][] visited;
	static int R, C;
	
	static int max, cnt, area;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		paper = new int[R][C];
		visited = new boolean[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력완료
		
		
		max = 0;
		cnt = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(paper[r][c] == 1 && !visited[r][c]) {
					visited[r][c] = true;
					cnt++;
					dfs(r, c);
					
					max = Math.max(max, area);
					area = 0;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
	
	private static void dfs(int r, int c) {
		area++;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc) && !visited[nr][nc] && paper[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}
	
	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}
	
	private static String src="6 5\r\n" + 
			"1 1 0 1 1\r\n" + 
			"0 1 1 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 0 1 1 1\r\n" + 
			"0 0 1 1 1\r\n" + 
			"0 0 1 1 1";

}
