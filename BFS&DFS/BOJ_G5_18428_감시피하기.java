package Dong.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_18428_감시피하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static String[][] map;
	static int N;
	static ArrayList<Point> empty = new ArrayList<Point>();
	static ArrayList<Point> teacher = new ArrayList<Point>(); 
	
	static int[][] deltas = {{1,0}, {-1,0}, {0,1},{0,-1}};
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "("+r+ " "+c+")";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = st.nextToken();
				if(map[r][c].equals("T")) {
					teacher.add(new Point(r, c));
				}else if(map[r][c].equals("X")) {
					empty.add(new Point(r, c));
				}
			}
		}
		
		//System.out.println(empty);
		
		comb(3, new Point[3], 0);
		System.out.println("NO");

	}
	
	static void comb(int toChoose, Point[] choosed, int idx) {
		if(toChoose == 0) {
			searchTeacher(choosed);
			return;
		}
		
		for(int i = idx; i < empty.size(); i++) {
			choosed[choosed.length-toChoose] = empty.get(i);
			comb(toChoose-1, choosed, i + 1);
		}
	}
	
	static void searchTeacher(Point[] choosed) {
		for(int i = 0; i < 3; i++) {
			Point current = choosed[i];
			map[current.r][current.c] = "O";
		}
		
		for(int i = 0; i < teacher.size(); i++) {
			for(int d = 0; d < 4; d++) {
				if(!watch(teacher.get(i).r, teacher.get(i).c, d)) {
					for(int j = 0; j < 3; j++) {
						Point current = choosed[j];
						map[current.r][current.c] = "X";
					}
					return;
				}
			}
		}
		System.out.println("YES");
		System.exit(0);
	}
	
	static boolean watch(int r, int c, int dir) {
		switch(dir) {
		// 위로 감시
		case 0:
			while(r >= 0) {
				if(map[r][c].equals("S")) {
					return false;
				}else if(map[r][c].equals("O")) {
					return true;
				}
				r -= 1;
			}
			break;
		// 아래로 감시
		case 1:
			while(r < N) {
				if(map[r][c].equals("S")) {
					return false;
				}else if(map[r][c].equals("O")) {
					return true;
				}
				r += 1;
			}
			break;
		// 좌로 감시
		case 2:
			while(c >= 0) {
				if(map[r][c].equals("S")) {
					return false;
				}else if(map[r][c].equals("O")) {
					return true;
				}
				c -= 1;
			}
			break;
		// 우로 감시
		case 3:
			while(c < N) {
				if(map[r][c].equals("S")) {
					return false;
				}else if(map[r][c].equals("O")) {
					return true;
				}
				c += 1;
			}
			break;
			
		}
		return true;
	}
	
	private static String src = "5\n" + 

			"X X S X X\n" + 
		
			"X X X X X\n" + 
		
			"S X T X S\n" + 
		
			"X X X X X\n" + 
		
			"X X S X X";

}
