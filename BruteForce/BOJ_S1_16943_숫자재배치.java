package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_16943_숫자재배치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static String A;
	static int[] strA;
	static boolean[] visited;
	static int answer, B;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = Integer.parseInt(st.nextToken());
		strA = new int[A.length()];
		String b = Integer.toString(B);
		
		if(A.length() > b.length()) {
			System.out.println(-1);
			System.exit(0);
		}
		
		for(int i = 0; i < A.length(); i++) {
			strA[i] = A.charAt(i) - '0';
		}
		
		visited = new boolean[A.length()];	
		answer = -1;
		makePermu(A.length(), 0);
		
		System.out.println(answer);
		
		
		
		
	}
	static void makePermu(int toChoose, int choosed) {
		
		if(toChoose == 0) {
			answer = Math.max(answer, choosed);
		}
		
		for(int i = 0; i < strA.length; i++) {
			if(visited[i]) continue;
			if(toChoose == A.length() && strA[i] == 0) continue;
			if(choosed * 10 + strA[i] > B) continue;
			
			visited[i] = true;
			makePermu(toChoose-1, choosed * 10 + strA[i]);
			visited[i] = false;
		}
		
		
	}

}
