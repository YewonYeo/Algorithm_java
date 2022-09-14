package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_S1_2667_단지번호붙이기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer = new StringBuilder();
	
	static int N, danji;
	static int[][] map;
	static int[][] deltas = {{1,0}, {0,1},{-1,0},{0,-1}};
	
	static ArrayList<Integer> houses;
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		houses = new ArrayList<Integer>();
		
		for(int r = 0; r < N; r++) {
			String temp = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = temp.charAt(c) - '0';
			}
		}
		
		// 입력완료
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					danji++;
					bfs(r, c);
				}
			}
		}
		
		answer.append(danji).append("\n");
		Collections.sort(houses);
		
		for(int i = 0; i < houses.size(); i++) {
			answer.append(houses.get(i)).append("\n");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		

	}
	
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		map[r][c] = 2;
		int house = 1;
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && map[nr][nc] == 1) {
					map[nr][nc] = 2;
					house++;
					
					q.add(new Point(nr, nc));
				}
			}
		}
		
		houses.add(house);
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	
	private static String src = "7\n" + 
			"0110100\n" + 
			"0110101\n" + 
			"1110101\n" + 
			"0000111\n" + 
			"0100000\n" + 
			"0111110\n" + 
			"0111000";

}
