package Dong.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 기출_볼링공고르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, answer;
	static int[] balls;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		balls = new int[M+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int weight = Integer.parseInt(st.nextToken());
			balls[weight]++;
		}
		
		answer = N * (N - 1) / 2; 
				
		for(int i = 1; i <= M; i++) {
			if(balls[i] >= 2) {
				answer -= (	balls[i] * (balls[i] - 1) / 2) ;
			}
		}
		
		System.out.println(answer);
	}

	
	private static String src = "8 5\n"
			+ "1 5 4 3 2 4 5 2";

}
