package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G5_12865_평범한배낭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, W;
	
	static class Bag{
		int weight, value;
		
		Bag(int weight, int value){
			this.weight = weight;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Bag[] bags = new Bag[N+1];
		int[][] dp = new int[N+1][W+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			bags[i] = new Bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i <=N; i++) {
			for(int w = 1; w <= W; w++) {
				int value = bags[i].value;
				int weight = bags[i].weight;
				
				if(weight > w) {
					dp[i][w] = dp[i-1][w];
				}else {
					dp[i][w] = Integer.max(dp[i-1][w-weight]+value, dp[i-1][w]);
				}
			}
		}
		
		for(int[]r: dp) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println(dp[N][W]);
	
	}
	
	private static String src = "4 7\r\n" + 
			"6 13\r\n" + 
			"4 8\r\n" + 
			"3 6\r\n" + 
			"5 12";

}
