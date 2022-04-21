package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1926_그림_bfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int[][] paper;
	static boolean[][] visited;
	static int R, C;
	static int max, cnt;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	static class Point{
		int r, c, cnt;
		
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
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
					bfs(r, c);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
	
	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		int index = 1;
		
		queue.add(new Point(r, c, index));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			
			Point current = queue.poll();
			max = Math.max(max, current.cnt);
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc] && paper[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc, ++index));
				}
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
