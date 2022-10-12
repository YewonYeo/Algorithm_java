package Dong.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] map;
	static boolean[][] visited;
	static int R, C, startR, startC, dir, cnt;
	static int[][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 1;
		bfs();
		
		System.out.println(cnt);
	}
	
	public static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		visited[startR][startC] = true;
		queue.add(new Point(startR, startC));
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			int turnCnt = 0;
			
			for(int d = 0; d < 4; d++) {
				
				turnCnt++;
				int nd = ( dir + 3 ) % 4;
				int nr = current.r + deltas[nd][0];
				int nc = current.c + deltas[nd][1];
				
				if(!visited[nr][nc] && nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
					cnt++;
					dir = nd;
					break;
				}else {
					dir = nd;
				}
				
			}
			
			if(turnCnt == 4) {
				int nd = (dir + 2) % 4;
				int nr = current.r + deltas[nd][0];
				int nc = current.c + deltas[nd][0];
				
				if(!visited[nr][nc] && nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
					cnt++;
				}else {
					return;
				}
			}
		}
	}
	
	

}
