package BOJ.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_S3_2108_통계학 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer = new StringBuilder();
	
	static int N;
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		num = new int[8001];
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int mid = 10000;
		int mode = 10000;
		
		for(int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			sum += number;
			num[number+4000]++;
			
			if(max < number) {
				max = number;
			}
			if(min > number) {
				min = number;
			}
		}
		
		int cnt = 0;
		int mode_max = 0;
		
		boolean flag = false;
		
		for(int i = min+4000; i <= max+ 4000; i++) {
			if(num[i] > 0) {
				
				if( cnt < (N+1) / 2) {
					cnt += num[i];
					mid = i-4000;
				}
				
				
				if(mode_max < num[i]) {
					mode_max = num[i];
					mode = i - 4000;
					flag = true;
				}
				else if(mode_max == num[i] && flag == true) {
					mode = i-4000;
					flag = false;
				}
				
			}
		}
		
		answer.append((int)Math.round((double) sum / N)).append("\n");
		answer.append(mid).append("\n");
		answer.append(mode).append("\n");
		answer.append(max - min);
		
		System.out.println(answer);
		
		
		

	}
	private static String src = "5\n" + 
			"1\n" + 
			"3\n" + 
			"8\n" + 
			"-2\n" + 
			"2";
	

}
