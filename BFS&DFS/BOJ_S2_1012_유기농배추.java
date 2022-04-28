package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1012_유기농배추 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int T, C, R, K;
	static int cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[R][C];
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			// 입력완료
			
			cnt = 0;
			visited = new boolean[R][C];
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(map[r][c] == 1 && !visited[r][c]) {
						//bfs(r, c);
						dfs(r, c);
						cnt++;
					}
				}
			}
			
			answer.append(cnt+"\n");
			
			
		}// t.c
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		br.close();
		

	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}
	
	public static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(new Point(r, c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
			}
		}
		
		return;
	}
	
	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 & nr < R && nc < C;
	}
	
	
	
	private static String src = "2\r\n" + 
			"10 8 17\r\n" + 
			"0 0\r\n" + 
			"1 0\r\n" + 
			"1 1\r\n" + 
			"4 2\r\n" + 
			"4 3\r\n" + 
			"4 5\r\n" + 
			"2 4\r\n" + 
			"3 4\r\n" + 
			"7 4\r\n" + 
			"8 4\r\n" + 
			"9 4\r\n" + 
			"7 5\r\n" + 
			"8 5\r\n" + 
			"9 5\r\n" + 
			"7 6\r\n" + 
			"8 6\r\n" + 
			"9 6\r\n" + 
			"10 10 1\r\n" + 
			"5 5";

}
