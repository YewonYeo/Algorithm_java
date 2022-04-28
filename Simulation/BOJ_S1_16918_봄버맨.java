package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_16918_봄버맨 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder answer = new StringBuilder();
	
	private static int[][] map;
	private static int R, C, N;
	private static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	private static Queue<Point> list = new LinkedList<Point>();
	
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
	
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			String temp = br.readLine();
			for(int c = 0; c < C; c++) {
				char a = temp.charAt(c);
				if(a == '.') {
					map[r][c] = 0;
				}else {
					map[r][c] = 3;
				}
			}
		}
		// 입력완료
		
		for(int t = 2; t <= N; t++) {
			if(t % 2 == 0) {
				setBoom(t);
			}else {
				bomb(t);
				goBomb(t);
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 0) {
					answer.append('.');
				}else {
					answer.append('O');
				}
			}
			answer.append("\n");
		}
		
		System.out.println(answer);
		
		
	}
	
	private static void setBoom(int t) {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 0) {
					map[r][c] = t+3;
				}
			}
		}
	}
	
	private static void bomb(int t) {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == t) {
					list.add(new Point(r, c));
					map[r][c] = 0;
				}
			}
		}
		
		
	}
	
	private static void goBomb(int t) {
		while(!list.isEmpty()) {
			Point current = list.poll();
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && map[nr][nc] != 0) {
					map[nr][nc] = 0;
				}
			}
		}
		
	
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nc >= 0 && nr < R && nc < C) {
			return true;
		}else {
			return false;
		}
	}
	
	private static String src = "6 7 4\r\n" + 
			".......\r\n" + 
			"...O...\r\n" + 
			"....O..\r\n" + 
			".......\r\n" + 
			"OO.....\r\n" + 
			"OO.....";

}
