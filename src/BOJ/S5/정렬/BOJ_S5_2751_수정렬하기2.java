package BOJ.S5.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// sort 함수 사용시 시간초과

public class BOJ_S5_2751_수정렬하기2 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	
	private static int N;
	private static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		boolean[] count = new boolean[2000001];
		
		for(int i = 0; i < N; i++) {
			count[Integer.parseInt(br.readLine())+1000000] = true;
		}
		
		for(int i = 0; i < count.length; i++) {
			if(count[i]) {
				answer.append(i - 1000000).append("\n");
			}
		}
		
		answer.setLength(answer.length());
		System.out.println(answer);

	}

}
