package Dong.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int answer, R, C;
	static int[][] map;
	
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static class Point{
		int r, c, cnt;
		
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			String temp = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = temp.charAt(c) - '0';
			}
		}
		
		for(int[]r: map) {
			System.out.println(Arrays.toString(r));
		}
		bfs();
		System.out.println(answer);

	}
	
	static void bfs() {
		Queue<Point>queue = new LinkedList<Point>();
		queue.add(new Point(0, 0, 1));
		map[0][0] = 0;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			if(current.r == R-1 && current.c == C-1) {
				answer = current.cnt;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				
				if(nr >= 0 && nc >=0 && nr < R && nc < C && map[nr][nc] == 1) {
					
					map[nr][nc] = 0;
					queue.add(new Point(nr, nc, current.cnt + 1));
				}
			}
		}
	}
	private static String src = "5 6\n"
			+ "101010\n"
			+ "111111\n"
			+ "000001\n"
			+ "111111\n"
			+ "111111";

}
