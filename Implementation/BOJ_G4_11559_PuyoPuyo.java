package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_G4_11559_PuyoPuyo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static char[][] map;
	static boolean[][] visited;
	static int answer;
	static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
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
		// del
		br = new BufferedReader(new StringReader(src));
		map = new char[12][6];
		
		for(int r = 0; r < 12; r++) {
			String temp = br.readLine();
			for(int c = 0; c < 6; c++) {
				map[r][c] = temp.charAt(c);
			}
		}
		
//		for(char[] c: map) {
//			System.out.println(c);
//		}
		
		while(true) {
			// 뿌요 없애기
			visited = new boolean[12][6];
			boolean flag = false;
			for(int r = 11; r >0; r--) {
				for(int c = 0; c < 6; c++) {
					if(!visited[r][c] && map[r][c] != '.') {
						if(popPuyo(r, c)) flag = true;
					}
				}
			}
			
			// 터뜨릴 뿌요가 없다면 종료
			if(!flag) break;
			
			// 연쇄 추가
			if(flag) answer++;
			
			
			
			// 아래로 내리기
			for(int c = 0; c < 6; c++) {
				downPuyo(c);
			}
			
//			System.out.println(answer);
//			for(char[] p : map) {
//				System.out.println(Arrays.toString(p));
//			}
		}
		
		System.out.println(answer);


	}
	
	static void downPuyo(int c) {
		int empty = 0;
		
		for(int r = 11; r >=0; r--) {
			char current = map[r][c];
			if(current == '.' ) {
				empty++;
			}else if(current != '.' && empty > 0) {
				map[r+empty][c] = current;
				map[r][c] = '.';
			}
		}
	}
	
	static boolean popPuyo(int r, int c) {
		int count = 1;
		Queue<Point> queue = new LinkedList<Point>();
		Queue<Point> pop = new LinkedList<Point>();
		
		char color = map[r][c];
		visited[r][c] = true;
		queue.add(new Point(r, c));
		pop.add(new Point(r, c));
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == color) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
					pop.add(new Point(nr, nc));
					count++;
				}
			}
		}
		
		// 그룹이 된 경우 터뜨리기
		if(count >= 4) {
			for(int i = 0; i < count; i++) {
				Point temp = pop.poll();
				map[temp.r][temp.c] = '.';
			}
			
//			for(char[] m: map) {
//				System.out.println(m);
//			}
			
			return true;
		}
		
		
		return false;
		
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >=0 && r < 12 && c < 6;
	}
	
	private static String src = "......\n" + 
			"......\n" + 
			"......\n" + 
			"......\n" + 
			"......\n" + 
			"......\n" + 
			"......\n" + 
			"......\n" + 
			"......\n" + 
			"......\n" + 
			"......\n" + 
			"......";

}
