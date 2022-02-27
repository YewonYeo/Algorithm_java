package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_11315_오목판정 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;

	private static int T, N;
	private static char[][] map;

	private static int[][] deltas = { { 0, 1 }, { 1, -1 }, { 1, 1 }, { 1, 0 } }; // 오른쪽, 왼쪽 대각선 아래, 오른쪽 대각선 아래, 아래

	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		T = Integer.parseInt(br.readLine());

	outer: for (int t = 1; t <= T; t++) {
			answer.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int r = 0; r < N; r++) {
				String temp = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = temp.charAt(c);
				}
			}

			// 입력완료
			int cnt = 1;
		
		
			for(int r = 0; r < N; r++) {
				 for(int c = 0; c <N; c++) {
					if(map[r][c] == 'o') { // 돌이 있는 칸
						
						for(int d = 0; d < deltas.length; d++) {  // 오목 탐색 시작
							cnt = 1;
							int rr = r;
							int cc = c;
							
							for(int i = 0; i <4; i++) {  // 같은 방향으로 4번 탐색
								int nr = rr + deltas[d][0];
								int nc = cc + deltas[d][1];
								
								if(isIn(nr,nc) && map[nr][nc] == 'o') {  // 탐색한 칸이 돌이 범위 내이고, 돌이 있는 경우
									cnt++;   // 돌 개수 증가
									rr = nr;
									cc = nc;
								}else { // 없는 경우 다음 방향으로
									break;
								}
								
							}
							if(cnt == 5) { // 돌 개수가 5인 경우 답 출력 후 다음 돌 탐색종료
								answer.append("YES").append("\n");
								continue outer; //다음 테스트케이스로 이동
							}
						
						}
					}
					
				}
			}
			answer.append("NO").append("\n");
			
		}
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		

	}
	private static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
			return true;
		}else {
			return false;
		}
	}
	private static String src = "4\r\n" + 
			"5\r\n" + 
			"....o\r\n" + 
			"...o.\r\n" + 
			"..o..\r\n" + 
			".o...\r\n" + 
			"o....\r\n" + 
			"6\r\n" + 
			"....o.\r\n" + 
			"oooooo\r\n" + 
			"....o.\r\n" + 
			"....o.\r\n" + 
			"......\r\n" +
			"......\r\n" +
			"5\r\n" + 
			".o.oo\r\n" + 
			"oo.oo\r\n" + 
			".oo..\r\n" + 
			".o...\r\n" + 
			".o...\r\n" + 
			"5\r\n" + 
			".o.o.\r\n" + 
			"o.o.o\r\n" + 
			".o.o.\r\n" + 
			"o.o.o\r\n" + 
			".o.o.";

}
