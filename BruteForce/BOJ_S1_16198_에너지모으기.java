package day0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S1_16198_에너지모으기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static List<Integer> marbles = new ArrayList<>();
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		N = Integer.parseInt(br.readLine());      // 구슬 개수
		marbles = new ArrayList<>();              // 구슬 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			marbles.add(Integer.parseInt(st.nextToken()));
		}
		
		permutation(N-2, 0);          // 첫 번째, 마지막 번째 구슬을 뺀 개수만큼 뽑기
		System.out.println(answer);
		
	}
	
	/** 구슬을 고르는 순열 : visited 방문 처리 대신 marbles에서 제거(=방문) , 추가(=미방문) 처리하기
	 * @param toChoose : 골라야 하는 개수
	 * @param sum : 고른 구슬의 에너지 합
	 */
	
	private static void permutation(int toChoose, int sum) {
		// base part
		if(toChoose == 0) {
			answer = Math.max(answer, sum);
			return;
		}
		
		// inductive part
		for(int i = 1; i < marbles.size()-1; i++) {        // 구슬의 개수만큼 반복문 실행
			//System.out.println(marbles);
			int temp = marbles.get(i);                     // i번째 구슬의 값
			int cal = marbles.get(i-1) * marbles.get(i+1); // 양 옆 에너지 모으기
			
			marbles.remove(i);                             // 구슬 뽑기
			permutation(toChoose-1, sum + cal);            // 다음 구슬 뽑기
			marbles.add(i, temp);                          // 다시 넣어주기
		
		}
	}
	
	
	
	private static String src="5\n" + 
			"1 2 3 4 5";

}
