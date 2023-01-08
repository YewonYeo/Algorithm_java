package BOJ.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_9655_돌게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		    int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N+1];
			
			if(N == 1) {
				System.out.println("SK");
                System.exit(0);
			}else if(N == 2) {
				System.out.println("CY");
				System.exit(0);
			}
			
			dp[1] = 1;
			dp[2] = 0;
			for(int i = 3; i <= N; i++) {
				dp[i] = (dp[i-1] + 1) % 2;
			}
			
			if(dp[N] == 1) {
				System.out.println("SK");
			}else {
				System.out.println("CY");
			}
        
		}
	

}
