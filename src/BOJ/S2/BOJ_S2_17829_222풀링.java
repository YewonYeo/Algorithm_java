package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_17829_222풀링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] map;
	static int N;
	static Queue<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int[] r: map) {
//			System.out.println(Arrays.toString(r));
//		}
		
		// 입력완료
		while(true) {
			if (N == 1) break; // N이 1이면 반복문 종료
		
			// r, c	 는 각 2x2 정사각행렬의 좌측 상단 인덱스이다.
			for(int r = 0; r < N; r+=2) {
				for(int c = 0; c < N; c+=2) {
					// temp 배열에 4개의 좌표를 담은 후 정렬한다.
					int[] temp = {map[r][c], map[r][c+1], map[r+1][c], map[r+1][c+1]};
					Arrays.sort(temp);
					
					// 두번째 큰 수를 map에 넣는다.
					map[r/2][c/2] = temp[2];
				}
			}
			
			N /= 2; // 사이즈 1/2로 줄이기
		
		}
		
		System.out.println(map[0][0]);
		
		
	}
	
	
	private static String src = "8\n" + 
			"-1 2 14 7 4 -5 8 9\n" + 
			"10 6 23 2 -1 -1 7 11\n" + 
			"9 3 5 -2 4 4 6 6\n" + 
			"7 15 0 8 21 20 6 6\n" + 
			"19 8 12 -8 4 5 2 9\n" + 
			"1 2 3 4 5 6 7 8\n" + 
			"9 10 11 12 13 14 15 16\n" + 
			"17 18 19 20 21 22 23 24";

}
