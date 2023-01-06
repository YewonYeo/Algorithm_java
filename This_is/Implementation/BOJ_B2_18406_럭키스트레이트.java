package Dong.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B2_18406_럭키스트레이트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String N = br.readLine();
		int left = 0;
		int right = 0;
		
		for(int i = 0; i < N.length(); i++) {
			if(0<= i && i <= (N.length()/2) -1) {
				left += N.charAt(i) - '0';
			}else {
				right += N.charAt(i) - '0';
			}
		}
		
		if(left == right) {
			System.out.println("LUCKY");
		}else {
			System.out.println("READY");
		}
		
		
	}

}
