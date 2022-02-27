package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_7236_저수지의물의총깊이구하기 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	
	private static int T, N;
	private static char map[][];
	private static int[][] deltas = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		System.setIn(SWEA_D3_7236_저수지의물의총깊이구하기.class.getResourceAsStream("7236.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		// delete
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			answer.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = st.nextToken().charAt(0);
				}
			}
			
			// 입력완료
			
			int max = Integer.MIN_VALUE;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int WaterDepth = 0;
					if(map[r][c] == 'W') {    // W인 경우
						
						for(int d = 0; d < deltas.length; d++) {       // 8방 탐색
							int nr = r + deltas[d][0];
							int nc = c + deltas[d][1];
							
							if(isIn(nr, nc)) {                         // 탐색한 곳이 W 라면
								if(map[nr][nc] == 'W') WaterDepth++;   // 깊이 증가
							}else {                                    // W가 아니라면 통과
								continue;
							}
						}
						
						if (WaterDepth == 0) WaterDepth = 1;           // 주변이 다 땅인 경우 저수지 깊이1
						
					}else {
						continue;
					}
					
					if(WaterDepth > max) {   // 최대 깊이 갱신
						max = WaterDepth;
					}
				}
			}
			
			answer.append(max).append("\n");
			
			
		}
		
		System.out.println(answer);

	}
	
	public static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
			return true;
		}else {
			return false;
		}
	}

}
