package BOJ.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_G3_1941_소문난칠공주 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static char[][] students = new char [5][5];
	private static int[][]deltas = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	private static boolean[][] visited = new boolean[5][5];
	private static int answer;
	private static LinkedList<Point> points = new LinkedList<Point>();
	
	
	static class Point{
		int r;
		int c;
		
		Point(int r, int c) {
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
	
		for(int r = 0 ; r < 5; r++) {
			String temp = br.readLine();
			for(int c = 0; c < 5; c++) {
				students[r][c] = temp.charAt(c);
				points.add(new Point(r,c));
			}
		}
		
		comb(7, new Point[7], 0);
		
		System.out.println(answer);
		
		
		
	}
	
	private static void comb(int toChoose, Point[] choosed, int startIdx) {
		if(toChoose == 0) {
			check(choosed);
			return;
		}
		
		for(int i = startIdx; i < points.size(); i++) {
			choosed[choosed.length - toChoose] = points.get(i);
			comb(toChoose-1, choosed, i+1);
			
		}
	}
	
	private static void check(Point[] choosed) {
		int[][] arr = new int[5][5];
		
		int Ycnt = 0;
		for(int i = 0; i < choosed.length; i++) {
			
			arr[choosed[i].r][choosed[i].c] = 1;
			
			if(students[choosed[i].r][choosed[i].c] == 'Y') {
				Ycnt++;
			}
			
		}
		if(Ycnt >= 4) {
			return;
		}else {
			bfs(choosed, arr);
		}
	}
	
	private static void bfs(Point[] choosed, int[][] arr) {
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		
		q.offer(choosed[0]);
		visited[choosed[0].r][choosed[0].c] = true;
		int num = 1;
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			int r = current.r;
			int c = current.c;
			
			for(int d=0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] == 1) {
					visited[nr][nc] = true;
					num++;
					q.offer(new Point(nr,nc));
				}
			}
		}
		
		if(num == 7) {
			answer++;
		}
		
		
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nc >= 0 && nr < 5 && nc <5) {
			return true;
		}else {
			return false;
		}
	}
	
	
	private static String src = "SSSSS\r\n" + 
			"SSSSS\r\n" + 
			"SSSSS\r\n" + 
			"SSSSS\r\n" + 
			"SSSSS";

}
