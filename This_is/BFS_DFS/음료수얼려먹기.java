package Dong.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] ice;
	static int answer, N, M;
	static int[][] deltas = {{-1,0}, {1,0}, {0,1}, {0,-1}};


	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ice = new int[N][M];
		answer = 0;
		
		for(int r = 0; r < N; r++) {
			String temp = br.readLine();
			for(int c = 0; c < M; c++) {
				ice[r][c] = temp.charAt(c) - '0';
			}
		}
		
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(dfs(r, c)) {
					answer++;
				}
			}
		
		}
		System.out.println(answer);

	}
	static boolean dfs(int r, int c) {
		
		if(r <= -1 || c <= -1 || r >= N || c >= M) {
			return false;
		}
		
		if(ice[r][c] == 0) {
			ice[r][c] = 1;
			
			dfs(r-1, c);
			dfs(r+1, c);
			dfs(r, c-1);
			dfs(r, c+1);
			return true;
		}
		return false;
		
	}
	private static String src = "15 14\n"
			+ "00000111100000\n"
			+ "11111101111110\n"
			+ "11011101101110\n"
			+ "11011101100000\n"
			+ "11011111111111\n"
			+ "11011111111100\n"
			+ "11000000011111\n"
			+ "01111111111111\n"
			+ "00000000011111\n"
			+ "01111111111000\n"
			+ "00011111111000\n"
			+ "00000001111000\n"
			+ "11111111110011\n"
			+ "11100011111111\n"
			+ "11100011111111";

}
