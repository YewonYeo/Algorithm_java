package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/*
 *  왼쪽 방향 {(d+3)%4} 과 후진방향 {(d+2)%4} 구하기
 * 
 */

public class BOJ_G5_14503_로봇청소기 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int[][] map;
	private static int R, C, cnt;
	private static int currentR, currentC, dir;
	
	private static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};  // 북, 동, 남, 서
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		currentR = Integer.parseInt(st.nextToken());
		currentC = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력완료
		
		clean(currentR, currentC, dir);
		System.out.println(cnt);

	}
	
	private static void clean(int r, int c, int direction) {
		boolean status = false;  //청소 여부
		
		// 1. 현재 위치 청소
		if(map[r][c] == 0) {
			map[r][c] = 2;
			cnt++;
		}
		// 2. 왼쪽 방향 탐색
		int origin = direction;
		for(int d = 0; d < deltas.length; d++) {
			int nd = (direction + 3) % 4;
			int nr = r + deltas[nd][0];
			int nc = c + deltas[nd][1];
			
			if(isIn(nr, nc)) {
				if(map[nr][nc] == 0) { // 청소하지 않았다면
					clean(nr, nc, nd);
					status = true;
					break;
				}
			}
			direction = nd;
		}
		if(!status) {
			int nd = (origin + 2) % 4;
			int nr = r + deltas[nd][0];
			int nc = c + deltas[nd][1];
			
			if(isIn(nr, nc) && map[nr][nc] != 1) {
				clean(nr, nc, origin);
			}else {
				return;
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r < R && c < C && r >= 0 && c >=0;
	}
	private static String src = "11 10\r\n" + 
			"7 4 0\r\n" + 
			"1 1 1 1 1 1 1 1 1 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 1 1 1 1 0 1\r\n" + 
			"1 0 0 1 1 0 0 0 0 1\r\n" + 
			"1 0 1 1 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 0 0 0 1 0 1\r\n" + 
			"1 0 0 0 0 0 1 1 0 1\r\n" + 
			"1 0 0 0 0 0 1 1 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 1 1 1 1 1 1 1 1 1";

}
