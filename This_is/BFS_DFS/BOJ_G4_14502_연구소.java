package Dong.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_14502_연구소 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] map;
	static int max, R, C;
	
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static ArrayList<Point> empty = new ArrayList<Point>();
	
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
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				if(map[r][c] == 0) {
					empty.add(new Point(r, c));
				}
			}
		} // 입력완료
		
		max = Integer.MIN_VALUE;
		makeComb(3, new Point[3], 0);
		
		System.out.println(max);
	}
	
	static void makeComb(int toChoose, Point[]choosed, int idx) {
		if(toChoose == 0) {
			spread(choosed);
			return;
		}
		
		for(int i = idx; i < empty.size(); i++) {
			choosed[choosed.length - toChoose] = empty.get(i);
			makeComb(toChoose-1, choosed, i + 1);
		}
	}
	static void spread(Point[] choosed) {
		// 0: 빈 칸, 1: 벽, 2: 바이러스
		int[][] copy = new int[R][C];
		Queue<Point> queue = new LinkedList<Point>();
		int safe = 0;

		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				copy[r][c] = map[r][c];
				
				// 바이러스라면 큐에 추가
				if(copy[r][c] == 2) {
					queue.add(new Point(r, c));
				}
				
				if(copy[r][c] == 0) {
					safe++;
				}
			}
		}

		
		// 벽 세우기
		for(int i = 0; i < 3; i++) {
			Point cur = choosed[i];
			copy[cur.r][cur.c] = 1;
		}

		safe -= 3;

		// 바이러스 확산
		while(!queue.isEmpty()) {
			
			Point current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && copy[nr][nc] == 0) {
					copy[nr][nc] = 2;
					queue.add(new Point(nr, nc));
					safe--;
				}
			}
			
		}
		
		max = Math.max(max, safe);
		return;
		
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	private static String src = "3 3\n" + 
			"0 0 0\n" + 
			"0 0 0\n" + 
			"0 0 0" ;

}
