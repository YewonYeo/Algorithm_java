package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_18405_경쟁적전염 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] map;
	static int N, K, S, X, Y;
	static Queue<Point> pq = new LinkedList<Point>();
	static List<Point> list = new ArrayList<Point>();
	
	static int[][] deltas = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	static class Point implements Comparable<Point>{
		int r, c, num;
		
		public Point(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public int compareTo(Point o) {
			return this.num - o.num;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", num=" + num ;
		}
		
		
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++){
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				if(map[r][c] != 0) {
					list.add(new Point(r, c, map[r][c]));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		Collections.sort(list);
		
		for(Point p : list) {
			pq.add(p);
		}
		
		spread();
		
		System.out.println(map[X-1][Y-1]);
	}
	
	public static void spread() {
		while(S --> 0) { // 시간 S만큼 탐색
			
		int size = pq.size(); // 같은 시간에 있는 바이러스만 탐색
		while(size --> 0) {
		
			Point current = pq.poll();
			if(current.r == X-1 && current.c == Y-1) {
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = current.num;
					pq.add(new Point(nr, nc, current.num));
				}
			}
		
		}
		
	}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	
	private static String src = "3 3\n" + 
			"1 0 1\n" + 
			"3 0 0\n" + 
			"0 0 2\n" + 
			"2 1 1";
	

}
