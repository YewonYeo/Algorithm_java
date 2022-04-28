package BOJ.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_2629_양팔저울 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer st; 
	static StringBuilder answer = new StringBuilder(); 
	
	static int N, M; 
	static boolean[][] dp; 
	static boolean[] numbers; 
	static int[] weight; 
	static int[] marble; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine()); 
		weight = new int[N+1]; 
		st = new StringTokenizer(br.readLine()); 
		for(int i = 1; i <= N; i++) { 
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine()); 
		marble = new int[M+1]; 
		st = new StringTokenizer(br.readLine()); 
		for(int i = 1; i <= M; i++) { 
			marble[i] = Integer.parseInt(st.nextToken()); 
		}
		
		dp = new boolean[N+1][N*500 +1]; 
		numbers = new boolean[N*500 +1]; 
		
		// dp[i][j] : i번째 추를 고려하여 만들수 있는 무게 j;
		
		dp[1][0] = true;
		dp[1][weight[1]] = true;
        numbers[weight[1]] = true;
		
		for(int r = 2; r <= N; r++) {
			for(int c = 0; c < N*500 +1; c++) {
				if(dp[r-1][c]) {
					int sum = c + weight[r];
					int dif = Math.abs(c - weight[r]);
					
					dp[r][sum] = true;
					numbers[sum] = true;
					
					dp[r][dif] = true;
					numbers[dif] = true;
                    
                    dp[r][c] = true;
				}
			}
		}
		
		for(int i = 1; i <= M; i++) {
			int temp = marble[i];
			
			if(temp > N*500 +1) {
				answer.append("N"+" ");
				continue;
			}
			
			if(numbers[temp]) {
				answer.append("Y"+" ");
			}else {
				answer.append("N"+" ");
			}
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		

	}


}