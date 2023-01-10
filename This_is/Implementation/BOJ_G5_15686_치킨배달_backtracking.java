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

public class BOJ_G5_15686_치킨배달_backtracking {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[][] map;
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int answer;
	
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
					houses.add(new Point(r, c));
				}else if(map[r][c] == 2) {
					chickens.add(new Point(r, c));
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		comb(M, new Point[M],0);
		
		System.out.println(answer);
		
	}
	// 치킨집 조합 구하기
	static void comb(int toChoose, Point[] choosed, int startIdx) {
		if(toChoose == 0) {
			int sum = 0;
			
			for(int i = 0; i < houses.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for(int j = 0; j < choosed.length; j++) {
					int distance = Math.abs(houses.get(i).r - choosed[j].r) + Math.abs(houses.get(i).c - choosed[j].c);
					temp = Math.min(temp, distance);
				}
				sum += temp;
			}
			answer = Math.min(answer, sum);
			return;	

		}
		
		for(int i = startIdx; i < chickens.size(); i++) {
			choosed[choosed.length - toChoose] = chickens.get(i);
			comb(toChoose-1, choosed, i+1);
		}
	}
	
	private static String src = "5 1\n" + 
			"1 2 0 2 1\n" + 
			"1 2 0 2 1\n" + 
			"1 2 0 2 1\n" + 
			"1 2 0 2 1\n" + 
			"1 2 0 2 1";

}
