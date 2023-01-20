package Dong.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_16234_인구이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Point> list;
	
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N, L, R, answer;
	
	static boolean flag;
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			
			flag = false;
			visited = new boolean[N][N];
			
			
			for(int r = 0; r< N; r++) {
				for(int c = 0; c < N; c++) {
					if(!visited[r][c]) {
						int sum = bfs(r, c);
						
						if(list.size() > 1) {
							change(sum);
							flag = true;
						}
					}
				}
			}
			
			if(!flag) {
				break;
			}
			
			answer++;
			
			
		}
		
		System.out.println(answer);
		
		
	}
	static void change(int sum) {
		sum = sum / list.size();
		
		for(int i = 0; i < list.size(); i++) {
			Point cur = list.get(i);
			map[cur.r][cur.c] = sum;
		}
	}
	
	static int bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		list = new ArrayList<Point>();
		
		visited[r][c] = true;
		queue.add(new Point(r, c));
		list.add(new Point(r,c));
		int sum = map[r][c];
				
		while(!queue.isEmpty()) {
			
			Point current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc]) {
					int temp = Math.abs(map[current.r][current.c] - map[nr][nc]);
					
					if(temp >= L && temp <= R) {
						visited[nr][nc] = true;
						flag = true;
						queue.add(new Point(nr, nc));
						list.add(new Point(nr, nc));
						sum += map[nr][nc];
					}
				}
				
			}
		}
		
		return sum;
		
	}
	
	
	static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >=0 && nr < N && nc < N;
	}
	private static String src = "2 20 50\n" + 
			"50 30\n" + 
			"20 40";

}
