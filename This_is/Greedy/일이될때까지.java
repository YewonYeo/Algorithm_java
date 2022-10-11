package Dong.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이될때까지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		while(true) {
			if(N == 1) {
				System.out.println(cnt);
				break;
			}
			
			if(N % K == 0) {
				N = N/K;
				cnt++;
			}else {
				N = N-1;
				cnt++;
			}
		}

	}

}
