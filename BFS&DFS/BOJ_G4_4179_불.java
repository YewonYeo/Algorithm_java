package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_4179_불 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C;
	static Point start;
	static char[][] map;
	static int result;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	static Queue<Point> fire = new LinkedList<>();
	
	static class Point{
		int r, c, d;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "P(" + r + "," + c + ")";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int r = 0; r < R; r++) {
			String temp = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = temp.charAt(c);
				if(map[r][c] == 'J') {
					start = new Point(r,c,0);
				}
				if(map[r][c] == 'F') {
					fire.add(new Point(r, c));
				}
			}
		}
		
		
		if(go(start)) {
			System.out.println(result);
		}else {
			System.out.println("IMPOSSIBLE");
		}
		
		

	} // main
	
	private static boolean go(Point start) {
		Queue<Point> JQueue = new LinkedList<Point>();
		JQueue.add(start);
		
		while(!JQueue.isEmpty()) {
			
			// 불 확산
			int sizeF = fire.size();
			for(int i = 0; i < sizeF; i++) {
				Point currentF = fire.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = currentF.r + deltas[d][0];
					int nc = currentF.c + deltas[d][1];
					
					if(isIn(nr, nc) && map[nr][nc] != '#' && map[nr][nc] != 'F') {
						map[nr][nc] = 'F';
						fire.add(new Point(nr, nc));
					}
				}
			}
			
			int sizeJ = JQueue.size();
			for(int i = 0 ; i < sizeJ; i++) {
				Point currentJ = JQueue.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = currentJ.r + deltas[d][0];
					int nc = currentJ.c + deltas[d][1];
					
					if(nr < 0 || nc < 0 || nr >= R || nc >=C) {
						result = currentJ.d +1;
						return true;
					}
					
					if(map[nr][nc] == '.') {
						map[nr][nc] = 'J';
						JQueue.add(new Point(nr, nc, currentJ.d + 1));
					}
				}
			}
			
		}
		
		return false;
	}
	
	
	
	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}
	
	private static String src = "4 6\r\n" + 
			"######\r\n" + 
			"......\r\n" + 
			"#.J###\r\n" + 
			"#F####";

}
