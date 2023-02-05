package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2174_로봇시뮬레이션 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static String answer;
	static int A, B, N, M;
	
	static int[][] map;
	static Info[] robots;
	static int[][] deltas = {{0,1}, {-1,0}, {0,-1}, {1,0}}; // E, S, W, N
	
	static class Info{
		int index, dir, r, c;
		
		public Info(int r, int c, int index, int dir) {
			this.r = r;
			this.c = c;
			this.index = index;
			this.dir = dir;
		}
			
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); // 행렬의 열
		B = Integer.parseInt(st.nextToken()); // 행렬의 행
		map = new int[B+1][A+1];
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 로봇의 수
		M = Integer.parseInt(st.nextToken()); // 명령의 수
		robots = new Info[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			int d = 0;
			
			if(dir.equals("E")) {
				d = 0;
			}else if(dir.equals("S")) {
				d = 1;
			}else if(dir.equals("W")){
				d = 2;
			}else {
				d = 3;
			}
			
			map[r][c] = i;
			robots[i] = new Info(r, c, i, d);
			
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			String order = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			
			Info current = robots[index];
			
			for(int j = 0; j < cnt; j++) {
				switch(order) {
				// 전진인 경우 이동
				case "F":
					moveRobots(index);
					break;
				// 왼쪽으로 회전(방향 배열에서 왼쪽으로 1칸씩 이동)
				case "L":
					current.dir = (current.dir +3) % 4;
					robots[index] = new Info(current.r, current.c, index, current.dir);
					break;
				// 오른쪽으로 회전(방향 배열에서 오른쪽으로 1칸씩 이동)
				case "R":
					current.dir = (current.dir +1) % 4;
					robots[index] = new Info(current.r, current.c, index, current.dir);
					break;
				}
			}
		}
		
		System.out.println("OK");
	}
	static void moveRobots(int index) {
		Info current = robots[index];
		int nr = current.r + deltas[current.dir][0];
		int nc = current.c + deltas[current.dir][1];
		
		// 이돌할 위치가 맵 범위 내인 경우
		if(isIn(nr, nc)) {
			// 빈 칸인 경우 이동
			if(map[nr][nc] == 0) {
				map[current.r][current.c] = 0;
				robots[index] = new Info(nr, nc, index, current.dir);
				map[nr][nc] = index;
			}
			// 해당 칸에 로봇이 있는 경우 충돌
			else {		
				System.out.println("Robot "+index+" crashes into robot "+map[nr][nc]);
				System.exit(0);
			}
			
		}
		// 범위 내에 없다면 벽에 충돌
		else {
			System.out.println("Robot "+index+" crashes into the wall");
			System.exit(0);
		}
		
	}
	
	private static String src = "1 3\n" + 
			"2 1\n" + 
			"1 1 N\n" + 
			"1 2 N\n" + 
			"1 F 2";
	
	static boolean isIn(int nr, int nc) {
		return nr > 0 && nr <= B && nc > 0 && nc <= A;
	}

}
