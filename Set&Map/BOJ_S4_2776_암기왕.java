package BOJ.S4;

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
		
		T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		for(int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine()); // 수첩 1의 수 개수
			Set<Integer> list = new HashSet<Integer>(); // 수첩 1 
			st = new StringTokenizer(br.readLine());
			
			// 수첩 1 입력받기
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if(list.contains(temp)) {
					answer.append("1"+"\n");
				}else {
					answer.append("0"+"\n");
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
