package Dong.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class 기출_문자열재정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		String input = br.readLine();
		char[] str = input.toCharArray();		
		Arrays.sort(str);
		int sum = 0;
		StringBuilder answer = new StringBuilder();
		
		for(int i = 0; i < str.length; i++) {
			char temp = str[i];
			
			if(temp - 'A' >= 0 && temp-'A' < 25) {
				answer.append(temp);
			}else {
				sum += temp-'0';
			}
		}
		
		answer.append(sum);
		System.out.println(answer);
		

	}
	private static String src = "AJKDLSI412K4JSJ9D";

}
