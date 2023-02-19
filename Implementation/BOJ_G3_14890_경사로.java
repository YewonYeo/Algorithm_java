package BOJ.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_14890_경사로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, L;
	static int [][]map;
	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
			check(map[r]);
		}
		
		for(int c = 0; c < N; c++) {
			int[] temp = new int[N];
			for(int r = 0; r < N; r++) {
				temp[r] = map[r][c];
			}
			check(temp);
		}
		
		
		System.out.println(answer);
		
	}
	static void check(int[] row) {
		int cnt = 1;
		int before = row[0];
		
		for(int i = 1; i < N; i++) {
			int current = row[i];
			
			// 현재 높이가 이전과 같은 경우
			if(current == before) {
				cnt++;
				continue;
			}
			// 현재 높이가 이전보다 1 큰 경우
			else if(before+1 == current) {
				// 지나온 높이의 개수가 L 이상인 경우
				if(cnt >= L) {
					cnt = 1;
					before = current;
				}
				// 경로가 될 수 없다
				else {
					return;
				}
			}
			// 현재 높이가 이전보다 1 작은 경우
			else if(current+1 == before) {
				// 현재부터 L만큼의 거리가 있다면
				if(i+L <= N) {
					// 현재부터 L까지 거리 만큼 있는지 확인
					for(int j = i; j < i+L; j++) {
						if(current == row[j]) {
							continue;
						}else {
							return;
						}
					}
					before = current;
					cnt = 0;
					i = i+L-1;
					
				}else {
					return;
				}
				
			}else {
				return;
			}
		}
		answer++;
	}
	
	private static String src = "6 2\n" + 
			"3 3 3 3 3 3\n" + 
			"2 3 3 3 3 3\n" + 
			"2 2 2 3 2 3\n" + 
			"1 1 1 2 2 2\n" + 
			"1 1 1 3 3 1\n" + 
			"1 1 2 3 3 2";

}
