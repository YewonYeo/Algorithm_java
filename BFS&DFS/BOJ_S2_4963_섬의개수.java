package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_4963_섬의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int R, C, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			cnt = 0;
			
			if(R == 0 && C == 0) break;
			
			map = new int[R][C];
			visited = new boolean[R][C];
			
			for(int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			} //입력완료
			
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(map[r][c] == 1 && !visited[r][c]) {
						bfs(r, c);
					}
				}
			}
			
			answer.append(cnt).append("\n");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);

	}
	
	static void bfs(int r, int c) {
		visited[r][c] = true;
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(r, c));
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
			}
		}
		cnt++;
	}
	
	static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}
	private static String src = "1 1\n" + 
			"0\n" + 
			"2 2\n" + 
			"0 1\n" + 
			"1 0\n" + 
			"3 2\n" + 
			"1 1 1\n" + 
			"1 1 1\n" + 
			"5 4\n" + 
			"1 0 1 0 0\n" + 
			"1 0 0 0 0\n" + 
			"1 0 1 0 1\n" + 
			"1 0 0 1 0\n" + 
			"5 4\n" + 
			"1 1 1 0 1\n" + 
			"1 0 1 0 1\n" + 
			"1 0 1 0 1\n" + 
			"1 0 1 1 1\n" + 
			"5 5\n" + 
			"1 0 1 0 1\n" + 
			"0 0 0 0 0\n" + 
			"1 0 1 0 1\n" + 
			"0 0 0 0 0\n" + 
			"1 0 1 0 1\n" + 
			"0 0";

}
