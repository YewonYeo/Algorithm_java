package Dong.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_숫자카드게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, result;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		result = 0;
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			int minValue = Integer.MAX_VALUE;
			for(int c = 0; c < C; c++) {
				minValue = Math.min(minValue, Integer.parseInt(st.nextToken()));
			}
			result = Math.max(result, minValue);
		}
		
		System.out.println(result);
	}

}
