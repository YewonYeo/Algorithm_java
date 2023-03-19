package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_14891_톱니바퀴 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] wheel = new int[5][8];
	static int[][] pointer = {{},{6,2},{6,2},{6,2},{6,2}};
	static int score;
	
	public static void main(String[] args) throws IOException {
		score = 0;
		br = new BufferedReader(new StringReader(src));
		
		for(int i = 1; i <= 4; i++) {
			String str = br.readLine();
			for(int j = 0; j < 8; j++) {
				wheel[i][j] = str.charAt(j) - '0';
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] turn = new int[5];
	
			int target = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			turn[target] = dir;
			
			checkLeft(target, dir, turn);
			checkRight(target, dir, turn);
			
			rotate(turn);
			
			
		}
		
		for(int i = 1; i <= 4; i++) {
			int target = (pointer[i][0] + 2) % 8;
			
			if(wheel[i][target] == 0) {
				continue;
			}else {
				score += (int) Math.pow(2, i-1);
			}
		}
		
		System.out.println(score);
		
	}
	
	static void rotate(int[] turn) {
		for(int i = 1; i <= 4; i++) {
			if(turn[i] == 0) continue;
			
			for(int j = 0; j < 2; j++) {
				if(turn[i] == 1) {
					pointer[i][j] = (pointer[i][j] + 7) % 8;
				}else {
					pointer[i][j] = (pointer[i][j] + 1) % 8;
				}
			}
		}
	}

	static void checkLeft(int target, int dir, int[] turn) {
		if(target - 1 < 1) {
			return;
		}
		
		if(wheel[target][pointer[target][0]] == wheel[target-1][pointer[target-1][1]]) {
			return;
		}else {
			turn[target-1] = dir * (-1);
			checkLeft(target-1, dir * (-1), turn);
		}
		
	}
	static void checkRight(int target, int dir, int[] turn) {	
		
		if(target + 1 > 4) {
			return ;
		}
		
		if(wheel[target][pointer[target][1]] == wheel[target+1][pointer[target+1][0]]) {
			return;
		}else {
			turn[target+1] = dir * (-1);
			checkRight(target+1, dir * (-1), turn);
		}
	}
	
	private static String src = "10010011\n" + 
			"01010011\n" + 
			"11100011\n" + 
			"01010101\n" + 
			"8\n" + 
			"1 1\n" + 
			"2 1\n" + 
			"3 1\n" + 
			"4 1\n" + 
			"1 -1\n" + 
			"2 -1\n" + 
			"3 -1\n" + 
			"4 -1";

}
