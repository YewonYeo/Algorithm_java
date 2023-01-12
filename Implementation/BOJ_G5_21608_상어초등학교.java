package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_G5_21608_상어초등학교 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] seatInfo, emptySeat;
	
	static int[][] deltas = {{1,0},{-1,0}, {0,1},{0,-1}};
	
	
	static class Student{
		int r, c;
		int[] like;
		
		public Student(int r, int c, int[] like) {
			this.r = r;
			this.c = c;
			this.like = like;
		}
	}
	
	static Map<Integer, Student> list = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		int size = N*N;
		int answer = 0;
		seatInfo = new int[N][N];
		checkEmptySeat();
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			
			int index = Integer.parseInt(st.nextToken());
			int[] like = new int[4];
			
			for(int j = 0; j < 4; j++) {
				like[j] = Integer.parseInt(st.nextToken());
			}
			
			findSeat(index, like);
		}
		
		for(int i = 1; i <= size; i++) {
			int[] friend = list.get(i).like;
			int cnt = 0;
			
			for(int f = 0; f < 4; f++) {
				int index = friend[f];
				if(Math.abs(list.get(index).r - list.get(i).r) + Math.abs(list.get(index).c - list.get(i).c) == 1) {
					cnt++;
				}
			}
			
			switch(cnt) {
			case 1:
				answer += 1;
				break;
			case 2:
				answer += 10;
				break;
			case 3:
				answer += 100;
				break;
			case 4:
				answer += 1000;
				break;
			}
		}
		
		System.out.println(answer);
		
		
		
	
	}
	
	static void checkEmptySeat() {
		emptySeat = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int cnt = 4;
				if(r == 0 || r == N-1) cnt--;
				if(c == 0 || c == N-1) cnt--;
				emptySeat[r][c] = cnt;
			}
		}
	}
	
	static void findSeat(int index, int[] like) {
		
		// 좋아하는 친구와 가장 인접한 자리를 담을 배열
		int[][] nearFriend = new int [N][N];
		
		// 좋아하는 친구의 인접 자리 찾기
		for(int i = 0; i < like.length; i++) {
			if(list.containsKey(like[i])) {
				Student s = list.get(like[i]);
				int r = s.r;
				int c = s.c;
				
				// 해당 학생의 인접 좌석을 찾아 좋아하는 친구 수 증가
				for(int d = 0; d < 4; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					if(nr >= 0 && nc >= 0 && nr < N && nc < N && seatInfo[nr][nc] == 0) {
						nearFriend[nr][nc]++;
					}
				}
			}
		}
		
		int emptyMax = -1;
		int nearMax = -1;
		int seatR = -1;
		int seatC = -1;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 앉은 사람이 있으면 통과
				if(seatInfo[r][c] != 0) continue;
				
				// 좋아하는 친구가 많은 경우 최대 값 갱신
				if(nearMax < nearFriend[r][c]) {
					seatR = r;
					seatC = c;
					nearMax = nearFriend[r][c];
					emptyMax = emptySeat[r][c];
				}
				// 좋아하는 친구가 같은 경우 남은 칸이 많은 경우
				else if (nearMax == nearFriend[r][c] && emptyMax < emptySeat[r][c]) {
					emptyMax = emptySeat[r][c];
					seatR = r;
					seatC = c;
				}
			}
		}
		
		seatInfo[seatR][seatC] = index;
		list.put(index, new Student(seatR, seatC, like));
		
		// 배치한 자리의 인접 자리 남은 좌석수 줄이기
		for(int d = 0; d < 4; d++) {
			int nr = seatR + deltas[d][0];
			int nc = seatC + deltas[d][1];
			
			if(nr >= 0 && nc >= 0 && nr < N && nc < N && seatInfo[nr][nc] == 0) {
				emptySeat[nr][nc]--;
			}
		}
	
	
		
	}
	
	private static String src = "3\n" + 
			"4 2 5 1 7\n" + 
			"2 1 9 4 5\n" + 
			"5 8 1 4 3\n" + 
			"1 2 9 3 4\n" + 
			"7 2 3 4 8\n" + 
			"9 8 4 5 7\n" + 
			"6 5 2 3 4\n" + 
			"8 4 9 2 1\n" + 
			"3 9 2 1 4";

}
