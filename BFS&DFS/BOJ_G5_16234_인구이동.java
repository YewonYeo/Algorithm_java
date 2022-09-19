package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_16234_인구이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] map;
	static boolean[][] visited;
	static LinkedList<Point> list; // 연합을 이루는 좌표를 담는 배열
	
	static int N, L, R, day;
	static int[][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	
	static boolean isOpen;
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료
		
		while(true) {
		
		visited = new boolean[N][N];
		isOpen = false; // 국경선이 열려있는지 여부를 파악하는 변수
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					int sum = bfs(r, c); // 연합을 이루는 나라 수
					
					if(list.size() > 1) { // 연합이 있는 경우
						move(sum); // 인구 이동
						isOpen = true;
					}
				}
			}
		}

		if(!isOpen) { // 국경선이 닫혀있는 경우 인구 이동이 없다.
			break;
		}
		
		day++;
		
		}
		
		
		System.out.println(day);
	}
	
	private static int bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		list = new LinkedList<>(); 
		
		q.add(new Point(r, c));
		visited[r][c] = true;
		list.add(new Point(r, c));
		int sum = map[r][c]; // 연합 내의 총 인구수를 담는 배열
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc]) { // 범위 내에 있고, 방문한 적 없는 경우
					
					// 인구 이동 조건 확인
					int temp = Math.abs(map[nr][nc] - map[current.r][current.c]);
					
					if(temp >= L && temp <= R) {
						visited[nr][nc] = true;
						q.add(new Point(nr, nc));
						list.add(new Point(nr, nc));
						sum += map[nr][nc];
					}
				}
			}
		}
		
		return sum;
	}
	
	private static void move(int sum) {
		
		int people = sum / list.size();
		
		while(!list.isEmpty()) {
			Point current = list.poll();
			map[current.r][current.c] = people;
		}
	}
	
	
	private static boolean isIn(int r, int c) {
		return r < N && c < N && r >=0 && c >= 0;
	}
	
	private static String src = "3 5 10\n" + 
			"10 15 20\n" + 
			"20 30 25\n" + 
			"40 22 10";

}
