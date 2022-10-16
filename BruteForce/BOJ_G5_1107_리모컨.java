package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_G5_1107_리모컨 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, cnt, target, move;
	static boolean[] btn = new boolean[10];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cnt = 0;
		
		/* 문제 풀이
		 * 이동해야할 채널부터 +, - 하여 버튼으로 누를 채널을 찾는다.
		 * (버튼으로 누른 채널의 길이) + (+, - 버튼으로 이동하는 수) 와 100에서 +, - 로 이동하는 수를 비교하여 출력
		*/
		
		// 고장난 버튼이 있는 경우
		if(M != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				btn[Integer.parseInt(st.nextToken())] = true; // 고장난 버튼: true
			}
		}
		
		// 모든 버튼이 고장난 경우
		if(M == 10) {
			System.out.println(Math.abs(N - 100));
			System.exit(0);
		}
		
		// 이동해야할 채널이 100인 경우 
		if(N == 100) {
			System.out.println(0);
			System.exit(0);
		}
		
		// 100에서 +, - 로 움직이는 횟수
		move = Math.abs(100 - N);
		
		int plus = N;
		int minus = N;
		
		while(true) {
			
			if(minus < 0) {
				minus = 0;
			}
			
			// plus 한 수로 움직일 수 있는 경우
			if(findCnt(plus, cnt) && !findCnt(minus, cnt)) {
				target = plus;
				break;
			}
			// minus 한 수로 움직일 수 있는 경우
			else if(findCnt(minus, cnt) && !findCnt(plus, cnt)){
				target = minus;
				break;
			}
			// plus, minus 한 수로 움직일 수 있는 경우
			else if(findCnt(minus, cnt) && findCnt(plus, cnt)) {
				
				// 두 개의 수 중 length가 작은 수로 target을 갱신
				if(Integer.toString(plus).length() >= Integer.toString(minus).length()) {
					target = minus;
				}else {
					target = plus;
				}
				break;
			}
			// 모두 안되는 경우 수 변경, 이동 횟수 추가
			else{
				plus++;
				minus--;
				cnt++;
			};
		}
		
		// 100에서 움직인 경우와 가까운 채널에서 이동하는 경우를 비교
		int answer = Math.min(move, Integer.toString(target).length()+cnt);
		System.out.println(answer);
		
	}
	
	private static boolean findCnt(int number, int cnt) {
		
		// 이동할 채널
		String str = Integer.toString(number);
		
		// 채널의 각 자리 수가 누를 수 있는 버튼인지 확인
		for(int i = 0; i < str.length(); i++) {
			int temp = (int)(str.charAt(i)-'0');
			
			// 고장난 버튼인 경우 false
			if(btn[temp]) {
				return false;
			}
					
		}
		
		// 각 자리 수를 다 누를 수 있는 경우 true
		return true;
	}
	
	private static String src = "102\n"+ 
			"2\n" +
			"7 8"  ;

}
