package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_3055_탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, currentR, currentC;
	static char[][] map;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static Queue<Point> queue = new LinkedList<Point>();
	static Queue<Point> water = new LinkedList<Point>();
	
	static class Point{
		int r, c, time;
		
		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		///
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r = 0; r<R; r++) {
			char[] temp = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				map[r][c] = temp[c];
				if(map[r][c] == 'S') {
					queue.add(new Point(r, c));
					currentR = r;
					currentC = c;
				}
				if(map[r][c] == '*') {
					water.add(new Point(r, c));
				}
			}
		}
		
		// 입력완료
		int answer = bfs();
		
		if(answer == 0) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(answer);
		}
	
	}
	
	static int bfs() {
		// 방문준비
		boolean[][] visited = new boolean[R][C];
		visited[currentR][currentC] = true;
		
		while(!queue.isEmpty()) {
			
			// 물 확산
			int waterSize = water.size();
			
			for(int i = 0; i < waterSize; i++) {
				Point temp = water.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = temp.r + deltas[d][0];
					int nc = temp.c + deltas[d][1];
					
					// 범위 내에 있고, 비어있는 곳인 경우
					if(isIn(nr, nc) && map[nr][nc] == '.') {
						map[nr][nc] = '*';
						water.add(new Point(nr, nc));
					}
				}
			}
			// 고슴도치 이동
			
			int animalSize = queue.size();
			
			for(int i = 0; i < animalSize; i++) {
				Point current = queue.poll();
				
				if(map[current.r][current.c] == 'D') {
					return current.time;
				}
				
				for(int d = 0; d < 4; d++) {
					int nr = current.r + deltas[d][0];
					int nc = current.c + deltas[d][1];
					
					// 범위 내에 있고, 물, 돌 아니면 이동 가능
					if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != '*' && map[nr][nc] != 'X') {
						queue.add(new Point(nr, nc, current.time+1));
						visited[nr][nc] = true;
						map[current.r][current.c] = '.';
					}
					
					
				}
				
				
			}
			
			
			
		}
		
		return 0;
		
		
	}
	
	static boolean isIn(int r, int c) {
		return r < R && r >= 0 && c < C && c >= 0;
	}
	
	
	private static String src = "3 3\n" + 
			"D.*\n" + 
			"...\n" + 
			".S.";

}
