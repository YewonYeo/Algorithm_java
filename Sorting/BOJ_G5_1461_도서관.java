package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_1461_도서관 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, answer;
	static int[] books;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
		// 0에서 가장 먼 거리를 마지막에 방문(=편도로 방문)
		// 이후 가장 끝 점을 기준으로 3권씩 방문
		
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		books = new int[N+1];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			books[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N == 1) {
			System.out.println(books[0]);
			System.exit(0);
		}
		
		Arrays.sort(books);
		
//		System.out.println(Arrays.toString(books));
		
		if(Math.abs(books[0]) > Math.abs(books[N])) {
			answer += Math.abs(books[0]);
			for(int i = 0; i < M; i++) {
				visited[i] = true;
			}
		}else {
			answer += Math.abs(books[N]);
			for(int i = N; i > N-M; i--) {
				visited[i] = true;
			}
		}
		
//		System.out.println("=====마지막 편도=====");
//		System.out.println(answer);
//		System.out.println(Arrays.toString(visited));
//		System.out.println(Arrays.toString(books));
//		System.out.println();
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			// 0이후 부터는 거꾸로 탐색
			if(books[i] == 0) {
				break;
			}
			// 방문하지 않은 지점인 경우
			if(!visited[i]) {
				// 첫번째 책인 경우 거리 더하기
				if(cnt == 0) {
					answer += Math.abs(books[i]) * 2;
				}
				visited[i] = true;
				cnt++;
				
				// 편도가 끝난 경우 카운트 0으로
				if(cnt == M) {
					cnt = 0;
				}
			}
//			System.out.println(cnt);
//			System.out.println(answer);
//			System.out.println(Arrays.toString(visited));
//			System.out.println(Arrays.toString(books));
//			System.out.println();
		}
		
		cnt = 0;
		for(int i = N; i >= 0; i--) {
			// 0 이후는 이미 방문한 지점이므로 탐색 종료
			if(books[i] == 0) {
				break;
			}
			
			if(!visited[i]) {
				if(cnt == 0) {
					answer += (books[i] * 2);
				}
				visited[i] = true;
				cnt++;
				
				if(cnt == M) {
					cnt = 0;
				}
			}
//			System.out.println(cnt);
//			System.out.println(answer);
//			System.out.println(Arrays.toString(visited));
//			System.out.println(Arrays.toString(books));
//			System.out.println();
		}
		
		System.out.println(answer);
		
		
		
	}
	private static String src = "1 50\n" + 
			"1";

}
