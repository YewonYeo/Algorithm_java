package Dong.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_일이될때까지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		while(true) {
			
			// N이 K로 나누어 떨어질 때까지 1을 뺀다.
			int target = (N/K) * K; // target: K의 배수
			cnt += (N - target); // target이 될 때 까지 1을 뺀다. N - 연산횟수 = 1
			N = target;
			
			// K보다 작은 경우 반복문 탈출
			if(N < K) {
				break;
			}
			
			// K로 나누기
			cnt += 1;
			N /= K;
		}
		
		// 마지막으로 남은 수에 1을 뺀다.
		cnt += (N - 1);
		System.out.println(cnt);

	}

}
