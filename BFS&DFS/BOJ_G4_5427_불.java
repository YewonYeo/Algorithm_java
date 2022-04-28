package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_5427_불 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();

	static int T;
	static int C, R;
	static char[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Point start;
	static Queue<Point> fire;

	static class Point {
		int r, c, d;

		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			fire = new LinkedList<Point>();

			for (int r = 0; r < R; r++) {
				String temp = br.readLine();
				for (int c = 0; c < C; c++) {
					map[r][c] = temp.charAt(c);
					if (map[r][c] == '@') {
						start = new Point(r, c, 0);
					} else if (map[r][c] == '*') {
						fire.add(new Point(r, c, 0));
					}
				}
			}
			// 입력완료

			bfs();

		}
		System.out.println(answer);
		br.close();

	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(start);

		while (!queue.isEmpty()) {

			// 불 확산
			int size = fire.size();
			for (int i = 0; i < size; i++) {
				Point current = fire.poll();

				for (int d = 0; d < 4; d++) {
					int nr = current.r + deltas[d][0];
					int nc = current.c + deltas[d][1];

					if (isIn(nr, nc) && map[nr][nc] != '#' && map[nr][nc] != '*') {
						map[nr][nc] = '*';
						fire.add(new Point(nr, nc, 0));
					}
				}

			}
			// 상근 이동

			int sizeS = queue.size();
			for (int i = 0; i < sizeS; i++) {
				Point sang = queue.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = sang.r + deltas[d][0];
					int nc = sang.c + deltas[d][1];

					// 범위 밖인 경우: 거리 리턴
					if (isOut(nr, nc)) {
						answer.append(sang.d+1).append("\n");
						return;
					}

					// 범위 아닌 경우: 빈 칸인 경우 이동
					if (map[nr][nc] == '.') {
						map[nr][nc] = '@';
						queue.add(new Point(nr, nc, sang.d + 1));
					}
				}

			}
		}
		answer.append("IMPOSSIBLE" + "\n");
		return;
	}

	private static boolean isIn(int nr, int nc) {
		return nr < R && nc < C && nr >= 0 && nc >= 0;
	}

	private static boolean isOut(int nr, int nc) {
		return nr >= R || nc >= C || nr < 0 || nc < 0;
	}

	private static String src = "5\r\n" + "4 3\r\n" + "####\r\n" + "#*@.\r\n" + "####\r\n" + "7 6\r\n" + "###.###\r\n"
			+ "#*#.#*#\r\n" + "#.....#\r\n" + "#.....#\r\n" + "#..@..#\r\n" + "#######\r\n" + "7 4\r\n" + "###.###\r\n"
			+ "#....*#\r\n" + "#@....#\r\n" + ".######\r\n" + "5 5\r\n" + ".....\r\n" + ".***.\r\n" + ".*@*.\r\n"
			+ ".***.\r\n" + ".....\r\n" + "3 3\r\n" + "###\r\n" + "#@#\r\n" + "###";

}
