package BOJ.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S5_1018_체스판다시칠하기 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static char[][] map;
	private static int R, C;
	private static int min;
	
    static char [][] startB = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
    };
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r = 0; r<R; r++) {
			String temp = br.readLine();
			for(int c = 0; c <C; c++) {
				map[r][c] = temp.charAt(c);
			}
		}
		
		// 입력완료
		int Rcnt = R - 7;
		int Ccnt = C - 7;
		int min = Integer.MAX_VALUE;
		
		for(int r = 0; r < Rcnt; r++) {
			for(int c = 0; c < Ccnt; c++) {
				min = Integer.min(min, find(r,c));		
			}
		}
		
		System.out.println(min);
		
		
	}
	
	public static int find(int r, int c) {
		
		int endR = r + 8;
		int endC = c + 8;
		int wCnt = 0; int bCnt = 0;
		// startB 는 0~7 행, 0~7 열 이므로 i-r, i-c 탐색.
		for(int i = r; i < endR; i++) {
			for(int j = c; j < endC; j++) {
				if(map[i][j] == startB[i-r][j-c]) {
					wCnt++;
				}else {
					bCnt++;
				}
				
			}
		}
		
		return Integer.min(wCnt, bCnt);
	}
	
	private static String src = "10 13\r\n" + 
			"BBBBBBBBWBWBW\r\n" + 
			"BBBBBBBBBWBWB\r\n" + 
			"BBBBBBBBWBWBW\r\n" + 
			"BBBBBBBBBWBWB\r\n" + 
			"BBBBBBBBWBWBW\r\n" + 
			"BBBBBBBBBWBWB\r\n" + 
			"BBBBBBBBWBWBW\r\n" + 
			"BBBBBBBBBWBWB\r\n" + 
			"WWWWWWWWWWBWB\r\n" + 
			"WWWWWWWWWWBWB";

}
