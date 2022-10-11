package Dong.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C;
	static int[][] card;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		card = new int[R][C+1];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			int minCol = Integer.MAX_VALUE;
			for(int c = 0; c < C; c++) {
				card[r][c] = Integer.parseInt(st.nextToken());
				if(card[r][c] < minCol) minCol = card[r][c];
			}
			card[r][C] = minCol;
		}
		
		int max = Integer.MIN_VALUE;
		for(int r = 0; r < R; r++) {
			if(card[r][C] > max) {
				max = card[r][C];
			}
		}
		System.out.println(max);
	}

}
