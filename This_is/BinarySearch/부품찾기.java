package Dong.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] items = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(items);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N-1;
			
			boolean flag = false;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(items[mid] == target) {
					flag = true;
					answer.append("yes ");
					break;
				}else if(items[mid] > target) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
			if(!flag) {
				answer.append("no ");
			}
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);

	}

}
