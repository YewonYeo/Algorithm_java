package Dong.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 못품_기출_만들수없는금액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] coin;
	

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		coin = new int[N];
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
			max += coin[i];
		}
		
		for(int i = 1; i <=max; i++) {
			
		}
		
	}
	private static String src = "5\n"
			+ "3 2 1 1 9";

}
