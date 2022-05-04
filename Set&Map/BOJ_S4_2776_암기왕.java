package day0504;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S4_2776_암기왕 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int T, N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		/** 
		 * 수첩 1 : 연종이가 본 수
		 * 수첩 2 : 연종이가 봤다고 주장하는 수
		 * 수첩 2의 순서대로 수첩 1에 있는 경우 1, 없으면 0
		 * */
		
		T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		for(int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine()); // 수첩 1의 수: N개
			Set<Integer> list = new HashSet<Integer>(); // 수첩 1 
			st = new StringTokenizer(br.readLine());
			
			// 수첩 1 입력받기
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			M = Integer.parseInt(br.readLine()); // 수첩 2의 수: M개
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int temp = Integer.parseInt(st.nextToken()); // 수첩 2의 수
				if(list.contains(temp)) {    // 수첩 1에 있는 경우
					answer.append("1"+"\n"); // 1
				}else {                      // 수첩 1에 없는 경우
					answer.append("0"+"\n"); // 0
				}
			}
			
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);

	}
	
	private static String src="1\n" + 
			"5\n" + 
			"4 1 5 2 3\n" + 
			"5\n" + 
			"1 3 7 9 5";

}
