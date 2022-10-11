package Dong.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰수의법칙 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, K;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열의 크기 N 
		M = Integer.parseInt(st.nextToken()); // 숫자가 더해지는 횟수 M
		K = Integer.parseInt(st.nextToken()); // K번 초과 
		
		int[] nums = new int[N];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int first = nums[N-1];
		int second = nums[N-2];
		
		//////////////
		while(true) {
			for(int i = 0; i < K; i++) {
				if(M == 0) break;
				answer += first;
				M -= 1;
			}
			
			if(M == 0) break;
			
			answer += second;
			M -= 1;
		}
		////////////////
		
		// 시간 초과 해결법
		
		// 가장 큰 수를 만들기 위해 반복되는 패턴을 찾자
		// 가장 큰 수가 K 번 더해지고 두번째 큰 수가 1번 더해지는 패턴이 반복된다.
		// 따라서 가장 큰 수가 나오는 횟수는 M / (K+1) * K 에다가 나머지 부분을 더해준다.
		
		int count = (int)( M / (K+1)) * K;
		count += M % (K+1);
		
		answer += count * first;
		answer += (M-count) * second;
		
		
		///////////////
		
		System.out.println(answer);
		
	}
}
