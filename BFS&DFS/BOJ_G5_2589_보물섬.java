package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_2589_보물섬 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C;
	static char[][]map;
	static int max = Integer.MIN_VALUE;
	
	static int[][] deltas = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	static class Point{
		int r, c, d;
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// 육지: L, 바다: W, 최단 거리로 동 시 가장 긴 시간이 걸리는 두 육지의 이동 시간
		
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		
		for(int r = 0; r < R; r++) {
			String temp = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = temp.charAt(c);
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 'L') {
					max = Math.max(max, bfs(r, c));
				}
			}
		}
		
		System.out.println(max);
		

	}
	
	private static int bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][] visited = new boolean[R][C];
		
		visited[r][c] = true;
		queue.add(new Point(r, c, 0));
		
		int distance = 0;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			distance = current.d;
			
			for(int i = 0; i < 4; i++) {
				int nr = current.r + deltas[i][0];
				int nc = current.c + deltas[i][1];
				
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 'L') {
					visited[nr][nc] = true;
					distance++;
					queue.add(new Point(nr, nc, current.d+1));
				}
				
				
			}
			
		}
		
		return distance;
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	private static String src = "5 7\n" + 
			"WLLWWWL\n" + 
			"LLLWLLL\n" + 
			"LWLWLWW\n" + 
			"LWLWLLL\n" + 
			"WLLWLWW";

}
