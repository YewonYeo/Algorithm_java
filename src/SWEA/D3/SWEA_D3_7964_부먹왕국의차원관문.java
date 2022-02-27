package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_7964_부먹왕국의차원관문 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	
	private static int T, N, D;
	private static int[] city;
	private static int cnt, broken;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		System.setIn(SWEA_D3_7964_부먹왕국의차원관문.class.getResourceAsStream("7964.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		// delete
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			answer.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			city = new int[N+2];  // 0번 위치와 N+1 위치는 차원관문 존재.
			city[0] = 1; city[N+1] = 1;
			cnt = 0;
			broken = 0; // 망가진 관문의 수 - D개가 되면 0으로 초기화, cnt++
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				city[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 0; i <= N; i++) {
				if(city[i] == 1) {   // 도시에 차원관문이 있는 경우, 망가진 관문의 수 초기화
					broken = 0;      // 관문이 있으면 망가진 개수는 0
					continue;
				}else {
					broken++;        // 관문이 없으면 망가진 개수 1 증가
				}
				if(broken == D) {    // 망가진 개수가 최대 개수 D가 되면
					cnt++;           // 관문 설치
					broken = 0;      // 망가진 개수 초기화
				}
				
			}
			
			answer.append(cnt).append("\n");
		}
		System.out.println(answer);
		br.close();
	}

}
