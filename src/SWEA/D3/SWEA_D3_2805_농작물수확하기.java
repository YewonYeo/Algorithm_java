package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_2805_농작물수확하기 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	
	private static int T, N, value;
	private static int[][]map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		System.setIn(SWEA_D3_2805_농작물수확하기.class.getResourceAsStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		// delete
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <=T; t++) {
			answer.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			value = 0;
			map = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				String row = br.readLine();
				for(int c = 0; c < N; c++) {
					map[r][c] = row.charAt(c) - '0';
				}
			} // 입력 완료
			
			int center = N/2;
			for(int r = 0; r <= center; r++) {   // 첫 행부터 중앙행까지
				for(int c = center-r; c <= center+r; c++) { // 중앙을 기준으로 -r 부터 +r 까지
					value += map[r][c];
				}
			}
			int i = 1;
			for(int r = center+1; r < N; r++) {  // 중앙행부터 끝행까지
				for(int c = i; c < N-i; c++) {   // 시작 열은 1, 2, 3, 증가 끝 열은 N-1, N-2, N-3 으로 감소
					value += map[r][c];
					
				}
				i++;
			}
			
			answer.append(value+"\n");
			
		} // T.C 종료
		
		System.out.println(answer);
	}
	
	

}
