package BOJ.G5;

import java.io.*;
import java.util.*;

public class BOJ_G5_1041_주사위 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static long N;
	static int[] dice = new int[7];
	static long[] minSum = new long[3];
	static long[] cnt = new long[3];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		
		N = Long.parseLong(br.readLine());
		st = new StringTokenizer(br.readLine());
		min = Integer.MAX_VALUE;
		long answer = 0;
		
		
		for(int i = 1; i <= 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
			if(min > dice[i]) {
				min = dice[i];
				minSum[0] = dice[i];
			}
		}
		
		if(N == 1) {
			int sum = 0;
			Arrays.sort(dice);
			for(int i = 1; i <= 5; i++) {
				sum += dice[i];
			}
			System.out.println(sum);
		}else {
		
		/** 3개의 면 : 4개
		 *  2개의 면 : (N-2) * 8 + 4
		 *  1개의 면 : (N-2) * 4 + 5*(N-2)^2
		 * */
		
		cnt[0] = (N-2) * 4 + 5*(N-2)*(N-2);
		cnt[1] = (N-2) * 8 + 4;
		cnt[2] = 4;
		
		// 3개의 면의 합 최소 구하기 : 서로 평행인 면(1-6, 2-5, 3-4) 중 최소 값을 구하면 된다.
		for(int i = 1; i <=3; i++) {
			minSum[2] += Math.min(dice[i], dice[7-i]);
		}
		
		// 2개의 면의 합 최소 구하기 : 서로 평행인 면이 아니면 된다.
		min = Integer.MAX_VALUE;
		for(int i = 1; i <= 6; i++) {
			for(int j = i+1; j <=6; j++) {
				if(i + j == 7) continue; // 서로 평행인 면인 경우 통과
				min = min > dice[i]+ dice[j] ? dice[i]+dice[j] : min; // 최소값 갱신
			}
		}
		minSum[1] = min;
		
		// 최종 답 구하기
		for(int i = 0; i <= 2; i++) {
			answer += minSum[i] * cnt[i];
		}
		
		System.out.println(answer);
		}
		
	}
	private static String src = "1000000\r\n" + 
			"50 50 50 50 50 50";

}
