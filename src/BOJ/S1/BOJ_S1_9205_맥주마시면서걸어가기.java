package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 좌표를 담는 Point 클래스 만들기 
 * 집, 페스티벌은 start, goal 로 따로 Point 만들기
 * 편의점을 Point[]에 넣기
 * bfs 탐색 
 */

public class BOJ_S1_9205_맥주마시면서걸어가기 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder answer = new StringBuilder();
	
	private static int T, N;
	private static Point start, goal;
	private static Point[] store;
	private static boolean[] visited;
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine());
			store = new Point[N];
			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				store[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			goal = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			// 입력완료
			
			bfs();
			
			
		} // t.c 끝
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);

	}
	
	private static void bfs() {
		// 방문 준비
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[N];
		
		// 출발점 넣기
		q.add(start);
		
		while(!q.isEmpty()) {
			
			Point current = q.poll();
			
			if( (Math.abs(current.x - goal.x)+Math.abs(current.y - goal.y)) <= 1000 ) {
				answer.append("happy").append("\n");
				return;
			}
			
			for(int i = 0; i < store.length; i++) {
				if(!visited[i]) {
					int d = (Math.abs(current.x - store[i].x)+Math.abs(current.y - store[i].y));
					if(d <= 1000) {
						visited[i] = true;
						q.add(store[i]);
					}
				}
			}
			
			
		}
		
		answer.append("sad").append("\n");
		
	}
	
	private static String src = "2\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"1000 1000\r\n" + 
			"2000 1000\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"2000 1000\r\n" + 
			"2000 2000";
}
