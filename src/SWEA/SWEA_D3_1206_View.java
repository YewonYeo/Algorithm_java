package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 7:50
public class SWEA_D3_1206_View {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N, Sum;
	private static int[] buildings;
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		// delete
		System.setIn(SWEA_D3_1206_View.class.getResourceAsStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		// delete
		
		for(int t = 1; t <= 10; t++) {
			
			answer.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			buildings = new int[N];
			Sum = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}

			// 입력완료 System.out.println(Arrays.toString(buildings));
			
			for(int i = 2; i < N-2; i++) {
				if(buildings[i] == 0) continue;
				
				checkSide(i);
				
			}
			
			answer.append(Sum).append("\n");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		
	}
	
	public static void checkSide(int current) {
		if(current - 2 < 0 || current +2 >= N) return;
		
		int max = buildings[current];      // 내 기둥
		int maxSide = Integer.MIN_VALUE;   // 옆 기둥 중 최고 높이
		
		for(int j = current -2; j <= current+2; j++) {  // 내 기준 양 옆 빌딩 비교
			if(j == current) continue;                  // 내 기둥일 땐 다음
			
			if(buildings[j] >= max) return;             // 나보다 크면 조망권 x.
			
			if(buildings[j] < max) {                    // 옆 빌딩 중 가장 큰 빌딩 구하기
				if(buildings[j] > maxSide) {
					maxSide = buildings[j];
				}
			}
		}
		
		Sum += (max - maxSide);                         // 조망권: 내 높이 - 최대 옆기둥 높이 
		return;
	}

}
