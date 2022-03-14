package week_re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_7562_나이트의이동 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder answer = new StringBuilder();
	
	private static int T, N;
	private static int[][] deltas = {{-1,-2}, {-2, -1}, {-2, 1}, {-1, 2},{1, -2},{2, -1}, {2, 1}, {1, 2}};
	private static boolean[][] visited;
	private static Point start, end;
	
	static class Point{
		int r = 0;
		int c = 0;
		int dist = 0;

		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			
			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			answer.append(bfs()).append("\n");
			
			
		} // t.c 끝
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		

	}
	
	private static int bfs() {
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(start);
		visited[start.r][start.c] = true;
		
		while(!queue.isEmpty()) {
			
			Point current = queue.poll();
			
			if(current.r == end.r && current.c == end.c) {
				return current.dist;
			}
				
			for(int d = 0; d < deltas.length; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr,nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc, current.dist + 1));
				}
			}
			
		}
		
		return 0;
		
	}
	
	
	private static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nc >=0 && nr < N && nc < N) {
			return true;
		}else {
			return false;
		}
	}
	private static String src = "3\r\n" + 
			"8\r\n" + 
			"0 0\r\n" + 
			"7 0\r\n" + 
			"100\r\n" + 
			"0 0\r\n" + 
			"30 50\r\n" + 
			"10\r\n" + 
			"1 1\r\n" + 
			"1 1";
}
