package Dong.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tteok = new int[N];
		int start = 0;
		int end = 0;
		int target = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tteok[i] = Integer.parseInt(st.nextToken());
			
			if(end < tteok[i]) end = tteok[i];
		}
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				if(tteok[i] > mid) {
					sum += (tteok[i] - mid);
				}
			}
			
			System.out.println(target);
			
			if(sum >= M) {
				target = mid;
				start = mid+1;
			}else {
				end = mid -1;
			}
			
		}
		System.out.println(target);

	}

}
