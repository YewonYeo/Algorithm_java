package Dong.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상하좌우 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 상 하 좌 우
	static int N;
	static int r, c;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		r = 1;
		c = 1;
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			String dir = st.nextToken();
			
			switch (dir) {
			case "U":
				move(0);
				break;
			case "D":
				move(1);
				break;
			case "L":
				move(2);
				break;
			case "R":
				move(3);
				break;
			}
			
			System.out.println(dir);
			System.out.println(r+" "+c);
		}
		
		//System.out.println(r+" "+c);

	}
	public static void move(int dir) {
		int nr = r + deltas[dir][0];
		int nc = c + deltas[dir][1];
		
		if(isIn(nr, nc)) {
			r = nr;
			c = nc;
		}else {
			return;
		}
	}
	public static boolean isIn(int r, int c) {
		return r >= 1 && c >= 1 && r <= N && c <= N;
	}

}
