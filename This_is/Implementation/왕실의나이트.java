package Dong.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의나이트 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String current = br.readLine();
		
		int[][] deltas = {{-1, 2}, {1, 2}, {-1, -2}, {1, -2}, {-2, 1}, {-2, -1}, {2, 1}, {2,-1}};
		int c = (int)current.charAt(0)-96;
		int r = current.charAt(1) - '0';
		int cnt = 0;
		
		for(int d = 0; d < 8; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr >= 1 && nc >=1 && nc <= 8 && nc <=8) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
		
		
	}

}
