package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_15686_치킨배달_bfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, house, chicken;
	static int[][] map;
	
	static int[][] deltas = {{-1,0},{1,0},{0,-1}, {0,1}};
	
	static class Point{
		int r, c, d;
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	
	static int answer, min;
	
	static List<Point> houses = new ArrayList<Point>();
	static List<Point> chickens = new ArrayList<Point>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c< N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) {
					houses.add(new Point(r, c, 0));
				}else if(map[r][c] == 2) {
					chickens.add(new Point(r, c, 0));
				}
			}
		}
		
		house = houses.size();
		if(chickens.size() == M) {
			for(int i = 0; i < house; i++) {
				Point current = houses.get(i);
				distance(current, map);
			}
			System.out.println(answer);
			System.exit(0);
		}
		min = Integer.MAX_VALUE;
		
		int temp = chickens.size() - M;
		comb(temp, new Point[temp], 0);
		
		System.out.println(min);
		
	}
	// 삭제할 치킨집 조합 구하기
	static void comb(int toChoose, Point[] choosed, int startIdx) {
		if(toChoose == 0) {
			answer = 0;
			
			
			for(int i = 0; i < choosed.length; i++) {
				int r = choosed[i].r;
				int c = choosed[i].c;
				
				map[r][c] = 0;
			}
			
			for(int i = 0; i < house; i++) {
				Point current = houses.get(i);
				distance(current, map);
			}
			
			min = Math.min(answer, min);
			for(int i = 0; i < choosed.length; i++) {
				int r = choosed[i].r;
				int c = choosed[i].c;
				
				map[r][c] = 2;
			}
			return;
		}
		
		for(int i = startIdx; i < chickens.size(); i++) {
			choosed[choosed.length - toChoose] = chickens.get(i);
			comb(toChoose-1, choosed, i+1);
		}
	}
	
	static void distance(Point start, int[][] newMap) {
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		boolean[][]visited = new boolean[N][N];
		visited[start.r][start.c] = true;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc]) {
					if(newMap[nr][nc] == 0 || newMap[nr][nc] == 1) {
						visited[nr][nc] = true;
						queue.add(new Point(nr, nc, current.d + 1));
					}else if(newMap[nr][nc] == 2) {
						visited[nr][nc] = true;
						answer += current.d + 1;
						return;
					}
				}
			}
			
		}
		
		
	}
	
	static boolean isIn(int r, int c){
		return r>=0 && c >=0 && r < N && c < N;	
	}
	
	private static String src = "5 1\n" + 
			"1 2 0 2 1\n" + 
			"1 2 0 2 1\n" + 
			"1 2 0 2 1\n" + 
			"1 2 0 2 1\n" + 
			"1 2 0 2 1";

}
