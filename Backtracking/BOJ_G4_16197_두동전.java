package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_G4_16197_두동전 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, r1, c1, r2, c2;
	static int answer;
	static char[][] map;
	
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1,0}};
	
	static class Point{
		int r, c, cnt;
		
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		// del
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		answer = Integer.MAX_VALUE;
		
		boolean isFirst = true;
		
		for(int r = 0; r < R; r++) {
			String temp = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = temp.charAt(c);
				if(map[r][c] == 'o') {
					if(isFirst) {
						r1 = r;
						c1 = c;
						isFirst = false;
					}else {
						r2 = r;
						c2 = c;
					}
				}
			}
		}
		
		coin(r1, c1, r2, c2, 0);
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
		
	}
	
	static void coin(int r1, int c1, int r2, int c2, int cnt) {
		
		// 최소값 보다 크거나, 10회 이상인 경우 리턴
		if(cnt >= answer || cnt >= 10) {
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int out = 0;
			
			int nr1 = r1 + deltas[d][0];
			int nc1 = c1 + deltas[d][1];
			int nr2 = r2 + deltas[d][0];
			int nc2 = c2 + deltas[d][1];
			
			// 밖으로 나갔는지 체크	
			if(nr1 < 0 || nr1 >= R || nc1 < 0 || nc1 >= C) out++;
			if(nr2 < 0 || nr2 >= R || nc2 < 0 || nc2 >= C) out++;
			
			
			if(out == 2) {
				continue;
			}
			
			if(out == 1) {
				answer = Math.min(answer, cnt + 1);
				return;
			}
			
			
			if(map[nr1][nc1] == '#') {
				nr1 = r1;
				nc1 = c1;
			}
			
			if(map[nr2][nc2] == '#') {
				nr2 = r2;
				nc2 = c2;
			}
			
			if((nr1 == nr2) && (nc1 == nc2)) continue;
			
			coin(nr1, nc1, nr2, nc2, cnt + 1);
		}
		
		
	}
	
	private static String src = "5 3\n" + 
			"###\n" + 
			".o.\n" + 
			"#.#\n" + 
			".o.\n" + 
			"###";

}
