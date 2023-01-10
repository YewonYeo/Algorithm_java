package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_G4_3190_뱀 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, L, answer;
	static int[][] map;
	static int dir;
	static Deque<Point> snake = new ArrayDeque<>();
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return r +" "+c;
		}
	}
	
	static Point[] apple;
	
	static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1, 0}}; // 동, 남, 서, 북
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// delete
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		map[1][1] = 2;
		dir = 0;
		
		snake.add(new Point(1,1));
		
		// 사과의 위치: 1
		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		
		
		// 뱀의 위치: 2
		L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String order = st.nextToken();
			int cnt = time- answer;
			
			for(int t = 0; t < cnt; t++) {
				moveSnake();
			}

			// L: +3, R: +1
			if(order.equals("L")) {
				dir = (dir + 3) % 4;
			}else{
				dir = (dir + 1) % 4;
			}
		}
		
		
		while(true) {
			moveSnake();
		}
		
		
	}
	
	static void moveSnake() {

			answer++;
			
			Point head = snake.getLast();
			Point tail = snake.getFirst();
			
			int nr = head.r + deltas[dir][0];
			int nc = head.c + deltas[dir][1];
			
			if(isIn(nr, nc)) {
				// 사과라면 해당 위치는 뱀으로 바뀐다
				if(map[nr][nc] == 1) {
					map[nr][nc] = 2;				
					snake.add(new Point(nr, nc));	
				}
				// 빈 칸이라면 이동
				else if(map[nr][nc] == 0) {
					map[nr][nc] = 2;
					
					snake.add(new Point(nr, nc));
					
					map[tail.r][tail.c] = 0;
					
					snake.poll();
					
					tail = snake.getFirst();
					
				}
				// 자기 몸이라면 게임 끝
				else if(map[nr][nc] == 2) {
					System.out.println(answer);			
					System.exit(0);
				}				
			}else {
				System.out.println(answer);
				System.exit(0);
			}
		

		
		
	}
	
	static boolean isIn(int r, int c) {
		return r > 0 && c > 0 && r <= N && c <= N;
	}
	
	private static String src = "10\n" + 
			"4\n" + 
			"1 2\n" + 
			"1 3\n" + 
			"1 4\n" + 
			"1 5\n" + 
			"4\n" + 
			"8 D\n" + 
			"10 D\n" + 
			"11 D\n" + 
			"13 L";
	
	
}
