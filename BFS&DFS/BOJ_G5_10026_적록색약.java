package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_G5_10026_적록색약 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer;
	
	static char[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int N, cnt1, cnt2;
	
	static class Point{
		int r, c;
		char color;
		
		public Point(int r, int c, char color) {
			this.r = r;
			this.c = c;
			this.color = color;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int r = 0; r < N; r++) {
			String temp = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = temp.charAt(c);
			}
		} // 입력완료
		
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visited1[r][c]) {
					bfs1(r, c);
					cnt1++;
				}
				
				if(!visited2[r][c]) {
					bfs2(r, c);
					cnt2++;
				}
			}
		}
		
		System.out.printf("%d %d", cnt2, cnt1);

	}
	
	private static void bfs1(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(r, c, map[r][c]));
		visited1[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited1[nr][nc]) {
					if(check1(current.color, map[nr][nc])) {
						visited1[nr][nc] = true;
						queue.add(new Point(nr, nc, map[nr][nc]));
					}
				}
			}
		}
		
		
	}
	
	private static void bfs2(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(r, c, map[r][c]));
		visited2[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited2[nr][nc]) {
					if(check2(current.color, map[nr][nc])) {
						visited2[nr][nc] = true;
						queue.add(new Point(nr, nc, map[nr][nc]));
					}
				}
			}

		}
		
		
	}
	
	private static boolean check1(char oColor, char nColor) {
		if(oColor == 'R') {
			return nColor == 'G' || nColor == 'R';
		}else if(oColor == 'G') {
			return nColor == 'G' || nColor == 'R';
		}else if(oColor == 'B'){
			return nColor == 'B';
		}
		return false;
	}
	
	private static boolean check2(char oColor, char nColor) {
		if(oColor == 'R') {
			return nColor == 'R';
		}else if(oColor == 'G') {
			return nColor == 'G';
		}else if(oColor == 'B'){
			return nColor == 'B';
		}
		return false;
	}
	
	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nc >= 0 && nr< N && nc < N;
	}
	
	private static String src = "5\r\n" + 
			"RRRBB\r\n" + 
			"GGBBB\r\n" + 
			"BBBRR\r\n" + 
			"BBRRR\r\n" + 
			"RRRRR";
}
