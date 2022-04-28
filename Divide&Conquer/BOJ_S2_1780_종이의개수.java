package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_S2_1780_종이의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();

	static int N;
	static int[] colors = new int[3];
	static int[][] paper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력완료

		cut(0, 0, N);

		for (int i = 0; i < colors.length; i++) {
			answer.append(colors[i]).append("\n");
		}
		System.out.println(answer);

	}

	private static boolean colorCheck(int startR, int startC, int size) {
		int color = paper[startR][startC];
		for (int r = startR; r < startR + size; r++) {
			for (int c = startC; c < startC + size; c++) {
				if (paper[r][c] != color)
					return false;
			}
		}
		return true;
	}

	private static void cut(int startR, int startC, int size) {

		if (colorCheck(startR, startC, size)) {
			if (paper[startR][startC] == -1)
				colors[0]++;
			if (paper[startR][startC] == 0)
				colors[1]++;
			if (paper[startR][startC] == 1)
				colors[2]++;
			return;
		}

		cut(startR, startC, size / 3);
		cut(startR, startC + size / 3, size / 3);
		cut(startR, startC + (size / 3) * 2, size / 3);

		cut(startR + size / 3, startC, size / 3);
		cut(startR + size / 3, startC + size / 3, size / 3);
		cut(startR + size / 3, startC + (size / 3) * 2, size / 3);

		cut(startR + (size / 3) * 2, startC, size / 3);
		cut(startR + (size / 3) * 2, startC + (size / 3), size / 3);
		cut(startR + (size / 3) * 2, startC + (size / 3) * 2, size / 3);

		return;
	}

	private static String src = "9\r\n" + "0 0 0 1 1 1 -1 -1 -1\r\n" + "0 0 0 1 1 1 -1 -1 -1\r\n"
			+ "0 0 0 1 1 1 -1 -1 -1\r\n" + "1 1 1 0 0 0 0 0 0\r\n" + "1 1 1 0 0 0 0 0 0\r\n" + "1 1 1 0 0 0 0 0 0\r\n"
			+ "0 1 -1 0 1 -1 0 1 -1\r\n" + "0 -1 1 0 1 -1 0 1 -1\r\n" + "0 1 -1 1 0 -1 0 1 -1";

}
