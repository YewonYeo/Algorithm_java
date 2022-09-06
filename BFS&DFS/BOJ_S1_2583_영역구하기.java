package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2583_영역구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int R, C, K, totalArea;
	static int[][] map;
	static int[][] deltas = {{0,1},{-1,0},{0,-1},{1,0}};
	static List<Integer> areas = new ArrayList<Integer>();
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map= new int[R][C];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lc = Integer.parseInt(st.nextToken());
			int lr = Integer.parseInt(st.nextToken());
			int rc = Integer.parseInt(st.nextToken());
			int rr = Integer.parseInt(st.nextToken());
			
			for(int r = lr; r < rr; r++) {
				for(int c = lc; c < rc; c++) {
					map[r][c] = 1;
				}
			}
		} // 영역 칠하기
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 0) {
					count(r, c);
				}
			}
		}
		
		answer.append(totalArea).append("\n");
		Collections.sort(areas);
		
		for(int i = 0; i < areas.size(); i++) {
			answer.append(areas.get(i)).append(" ");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		
	}
	
	private static void count(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		map[r][c] = 1;
		
		int area = 1; // 영역의 넓이를 저장할 변수
		q.add(new Point(r, c));
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					area++;
					q.add(new Point(nr, nc));
				}
				
			}
		}
		areas.add(area); // 영역의 넓이 추가
		totalArea++; // 영역 개수 증가
		return;
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && c >=0 && r< R && c < C;
	}

}
