package Dong.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_S1_14888_연산자끼워넣기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int N, min, max;
	static int[] number;
	static int[] operator;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		operator = new int[4];
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		makePermutation(N-1, number[0]);
		
		answer.append(max).append("\n").append(min);
		System.out.println(answer);

	}
	
	static void makePermutation(int toChoose, int sum) {
		if(toChoose == 0) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				switch(i) {
				case 0:
					makePermutation(toChoose-1, sum + number[N-toChoose]);
					break;
				case 1:
					makePermutation(toChoose-1, sum - number[N-toChoose]);
					break;
				case 2:
					makePermutation(toChoose-1, sum * number[N-toChoose]);
					break;
				case 3:
					makePermutation(toChoose-1, sum / number[N-toChoose]);
					break;
				}
				operator[i]++;
			}
		}
	}
	private static String src = "3\n" + 
			"3 4 5\n" + 
			"1 0 1 0";

}
