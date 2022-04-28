package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @since
 * @category 투포인터, 슬라이딩윈도우
 */

public class BOJ_G4_15961_회전초밥 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, typeCnt, maxEatCnt, coupon;
	static int belt[], ate[];
	static int res, cnt;
	static boolean hasCoupont;
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시 수
		typeCnt = Integer.parseInt(st.nextToken()); // 초밥의 가짓 수
		maxEatCnt = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		coupon = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		belt = new int[N];
		ate = new int[typeCnt+1];
		
		for(int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		// 입력 완료
		
		for(int i = 0; i < maxEatCnt; i++) {
			if(ate[belt[i]] == 0) {
				res++;
			}
			ate[belt[i]]++;
		}
		
		cnt = res;
		res = (ate[coupon] == 0)? cnt+1: cnt;
		
		eatMore();
		System.out.println(res);
	}
	
	private static void eatMore() {
		
		int start = maxEatCnt;
		
		while(true) {
			
			// 이전 초밥 제거
			ate[belt[(start - maxEatCnt) % N]] --;
			if(ate[belt[(start - maxEatCnt) % N]] == 0) cnt--;
			
			// 다음 위치 초밥이 새로운 초밥인 경우
			if(ate[belt[start % N]] == 0) {
				cnt++;
			}
			ate[belt[start % N]]++;
			
			res = Math.max(res, (ate[coupon] == 0)? cnt+1 : cnt);
			
			start++;
			
			if(start == (N-1) + maxEatCnt) break;
			
		}
	}
	
	private static String src = "8 30 4 30\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25";

}
