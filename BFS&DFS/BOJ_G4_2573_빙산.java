package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2573_빙산 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
		
	static int R, C, year, cnt; //행, 열, 시간, 덩어리
	static int[][]bingsan;
	static int[][]copy;
	static int[][] deltas = {{0, 1}, {1,0}, {-1, 0}, {0,-1}};
	static boolean[][]visited;
	
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
		// delete
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		bingsan = new int[R][C];
		copy = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				bingsan[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			
			// 1년 증가
			year++;
			
			// 빙산을 녹이기 위해 주변 0의 개수 세기
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(bingsan[r][c] != 0) {
						meltCount(r, c);
					}
				}
			}
			
			// 주변 0의 개수 만큼 빙산 녹이기
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					int result = bingsan[r][c] - copy[r][c];
					if(result >= 0) {
						bingsan[r][c] = result;
					}else {
						bingsan[r][c] = 0;
					}
				}
			}
			

			
			
			// 빙산 덩어리 세기
			visited = new boolean[R][C];
			cnt = 0; // 빙산 개수
			
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					// 빙하가 녹지 않고,방문하지 않은 경우 탐색
					if(bingsan[r][c] != 0 && !visited[r][c]) {
						count(r, c);
					}
				}
			}
			
			// 덩어리 개수가 2 이상인 경우 연도 출력 및 종료
			if(cnt >= 2) {
				answer.append(year);
				break;
			}
			
			// 빙하가 모두 녹은 경우 0 출력 및 종료
			if(meltAll()) {
				answer.append(0);
				break;
			}
		}
		
		System.out.println(answer);
		
		
	}
	
	// 빙산 4방 탐색하여 0의 개수 세는 함수
	public static void meltCount(int r, int c) {
		int temp = 0;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc) && bingsan[nr][nc] == 0) {
				temp++;
			}
			
		}
		
		// 0의 개수를 copy 배열에 담아준다.
		copy[r][c] = temp;
		
		return;
	}
	
	// 빙산 덩어리 개수 세는 함수
	public static void count(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				// 영역 안에 있고, 0이 아니고, 방문하지 않은 경우
				if(isIn(nr, nc) && bingsan[nr][nc] != 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}
		// 덩어리 개수 증가
		cnt++;
	}
	
	// 빙산이 모두 녹았는지 확인하는 함수
	public static boolean meltAll() {
		int total = R*C;
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c< C; c++) {
				if(bingsan[r][c] == 0) {
					total--;
				}
			}
		}
		
		if(total == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	private static boolean isIn(int r, int c) {
		return r < R && c < C && r >= 0 && c >= 0;
	}
	
	private static String src = "5 7\n" + 
			"0 0 0 0 0 0 0\n" + 
			"0 2 4 5 3 0 0\n" + 
			"0 3 0 2 5 2 0\n" + 
			"0 7 6 2 4 0 0\n" + 
			"0 0 0 0 0 0 0";
}
