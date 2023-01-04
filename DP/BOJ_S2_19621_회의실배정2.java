package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_S2_19621_회의실배정2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, before, sum;
	static int[] people;
	static int[] dp;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		// N이 3미만인 경우 해당 값을 출력 후 종
		if(N == 1) {
			System.out.println(people[1]);
			System.exit(0);
		}else if(N == 2) {
			System.out.println(Math.max(people[1], people[2]));
			System.exit(0);
		}
		
		// N이 3 이상인 경우
		// dp[i] = i번째 회의까지의 최대 값
		//		 = ( i-1 번째 까지의 최대 회의 인원, i-2번째 까지의 최대 회의 인원 + i번째 회의 인원) 중 최대 인원
		
		dp[1] = people[1];
		dp[2] = Math.max(dp[1], people[2]);
		
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2] + people[i], dp[i-1]);
		}
		
		System.out.println(dp[N]);
		
		
		
	}
	private static String src = "6\n" + 
			"10 40 80\n" + 
			"30 60 60\n" + 
			"50 80 70\n" + 
			"70 100 100\n" + 
			"90 120 40\n" + 
			"110 140 50";

}
