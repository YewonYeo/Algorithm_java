package Dong.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// int -> String : Integer.toString("int")
// String -> int : Integer.parseInt("String")

public class 시각 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		
		for(int h = 0; h <= N; h++) {
			for(int m = 0; m <= 59; m++) {
				for(int s = 0; s <= 59; s++) {
					if(Integer.toString(h).contains("3") | Integer.toString(m).contains("3") | Integer.toString(s).contains("3")) {
						cnt++;
					}
					
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
