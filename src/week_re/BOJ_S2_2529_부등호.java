package week_re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S2_2529_부등호 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;

	private static int k;
	private static char[] signs;
	private static boolean visited[] = new boolean[10];;

	private static String s;
	private static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		signs = new char[k];

		for (int i = 0; i < k; i++) {
			signs[i] = st.nextToken().charAt(0);
		}

		// 입력완료
		
		for (int i = 0; i <= 9; i++) {
			visited[i] = true;
			
			// 첫번 째 숫자, 부등호 뽑은 횟수, 뽑은 숫자들, 부등호 개수
			dfs(i, k, i + "");
		}

		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));

	}

	private static void dfs(int prev, int toChoose, String s) {
		// 부등호를 n개 뽑은 경우 list에 추가
		if (toChoose == 0) {
			list.add(s);
		}

		else {
			for (int i = 0; i <= 9; i++) {
				if (!visited[i]) {
					// 부등호가 < 일 때,
					if (signs[signs.length - toChoose] == '<') {
						// 뽑은 수(num) < 뽑을 수(i) 이어야 하므로 반대의 경우 continue
						if (prev >= i) {
							continue;
						}
					} 
					
					// 부등호가 > 일 때,
					else {
						// 뽑은 수(num) > 뽑을 수(i) 이어야 하므로 반대의 경우는 continue
						if (prev <= i) {
							continue;
						}
					}
					
					// 위의 조건을 통과한 경우 재귀 호출
					visited[i] = true;
					dfs(i, toChoose - 1, s + i);
				}
			}
		}
		visited[prev] = false;
	}

	private static String src = "2\r\n" + "< >";

}
