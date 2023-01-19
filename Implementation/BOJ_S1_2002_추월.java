package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_S1_2002_추월 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, answer;
	static String[] daeguen;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		daeguen = new String[N];
		Queue<String> youngsik = new LinkedList<String>();
		
		for(int i = 0; i < N; i++) {
			daeguen[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			youngsik.add(br.readLine());
		}
		
		int idx = 0;
		while(!youngsik.isEmpty()) {
			String cur = daeguen[idx];
			
			// 현재 탐색하려는 대근의 차가 이미 영식에서 빠진 차라면(= 이전 차를 추월한 차) 다음 차 탐색
			if(!youngsik.contains(cur)) {
				idx++;
				continue;
			}
			// 대근의 차와 영식의 차 순서가 같으면 다음 차 탐색
			if(youngsik.peek().equals(cur)) {
				youngsik.poll();
				idx++;
			}
			// 차 순서가 다르다면 추월한 차이므로 빼기
			else {
				answer++;
				youngsik.poll();
			}
		}
		
		System.out.println(answer);
	}
	private static String src = "5\n" + 
			"ZG206A\n" + 
			"PU234Q\n" + 
			"OS945CK\n" + 
			"ZG431SN\n" + 
			"ZG5962J\n" + 
			"ZG5962J\n" + 
			"OS945CK\n" + 
			"ZG206A\n" + 
			"PU234Q\n" + 
			"ZG431SN";

}
