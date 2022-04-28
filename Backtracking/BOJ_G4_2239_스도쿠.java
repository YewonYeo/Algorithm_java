package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

/* 재귀를 멈추는 방법
 * 1. 함수를 boolean 타입으로 종료 시 return true 시켜주기
 * 2. boolean 타입의 flag 변수를 이용하기
 * 3. system.exit(0); -> 프로그램 자체가 종료되므로 되도록 지양
 */

/**
 * 22.04.06 수업
 **/

public class BOJ_G4_2239_스도쿠 {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer = new StringBuilder();

	static ArrayList<Point> list = new ArrayList<Point>();
	static int[][] map = new int[9][9];
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		for (int r = 0; r < 9; r++) {
			String temp = br.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = temp.charAt(c) - '0';
				if (map[r][c] == 0) {
					list.add(new Point(r, c));
				}
			}
		} // 입력완료
		makePerDup2(0);
		System.out.println(answer);

	}
	static boolean isDone = false;
	
	private static void makePerDup(int idx) {
		// base part
		if (idx == list.size()) {
			// 정답 출력
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					answer.append(map[r][c]);
				}
				answer.append("\n");
			}
			isDone = true;
			return;
		}

		// inductive part
		Point p = list.get(idx);
		for (int i = 1; i < 10; i++) {
			// p에 i를 할당할 수 있는가?
			if(canUse(p, i)) {
				// 가능하다면 놓고 다음 재귀
				map[p.r][p.c] = i;
				if(!isDone) {
					makePerDup(idx+1);
				}
				// 다음 반복으로 갈 때는 안한척
				map[p.r][p.c] = 0;
			}	
		}

	}
	
	private static boolean makePerDup2(int idx) {
		// base part
		if (idx == list.size()) {
			// 정답 출력
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					answer.append(map[r][c]);
				}
				answer.append("\n");
			}
			return true;
		}

		// inductive part
		Point p = list.get(idx);
		for (int i = 1; i < 10; i++) {
			// p에 i를 할당할 수 있는가?
			if(canUse(p, i)) {
				// 가능하다면 놓고 다음 재귀
				map[p.r][p.c] = i;
				if(makePerDup2(idx+1)) {
					return true;
				}
				// 다음 반복으로 갈 때는 안한척
				map[p.r][p.c] = 0;
			}	
		}
		
		return false;

	}

	private static boolean canUse(Point p, int v) {
		int pr = p.r;
		int pc = p.c;
		
		// 같은 열에 혹시 v가 사용된 적이 있나?
		for (int r = 0; r < 9; r++) {
			if (map[r][pc] == v) {
				return false;
			}
		}
		// 같은 행에 혹시 v가 사용된 적이 있나?
		for (int c = 0; c < 9; c++) {
			if (map[pr][c] == v) {
				return false;
			}
		}
		// 작은 사각형에 v가 사용된 적이 있나?
		int sr = pr / 3 * 3;
		int sc = pc / 3 * 3;
		for(int r = sr; r < sr+3; r++) {
			for(int c = sc; c < sc+3; c++) {
				if(map[r][c] == v) {
					return false;
				}
			}
		}
		return true;
	}

	private static String src = "103000509\r\n" + "002109400\r\n" + "000704000\r\n" + "300502006\r\n" + "060000050\r\n"
			+ "700803004\r\n" + "000401000\r\n" + "009205800\r\n" + "804000107";

}
