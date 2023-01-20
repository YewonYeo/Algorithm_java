package Dong.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_18405_경쟁적전염 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, S, X, Y;
	static int[][]map;
	
	static ArrayList<Point> virus = new ArrayList<Point>();
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static class Point implements Comparable<Point>{
		int r, c, idx;
		
		public Point(int r, int c, int idx) {
			this.r = r;
			this.c = c;
			this.idx =idx;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.idx - o.idx;
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				if(map[r][c] > 0) {
					virus.add(new Point(r, c, map[r][c]));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		Collections.sort(virus);
		
		bfs();
		
		System.out.println(map[X-1][Y-1]);
		
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		
		for(int i = 0; i < virus.size(); i++) {
			queue.add(virus.get(i));
		}
		
		while(!queue.isEmpty() && S > 0) {
			S--;
			int size = queue.size();
			
			while(size --> 0) {
				Point cur = queue.poll();
				
				if(cur.r == X-1 && cur.c == Y-1) {
					System.out.println(map[cur.r][cur.c]);
					System.exit(0);
					return;
				}
				
				for(int d = 0; d < 4; d++) {
					int nr = cur.r + deltas[d][0];
					int nc = cur.c + deltas[d][1];
					
					if(isIn(nr, nc) && map[nr][nc] == 0) {
						map[nr][nc] = cur.idx;
						queue.add(new Point(nr, nc, cur.idx));
					}
				}
			}
			
		}
		
	}
	static boolean isIn(int r, int c) {
		return r >= 0 && c >=0 && r < N && c < N;
	}
	
	private static String src = "3 3\n" + 
			"1 0 2\n" + 
			"0 0 0\n" + 
			"3 0 0\n" + 
			"2 3 2";

}
