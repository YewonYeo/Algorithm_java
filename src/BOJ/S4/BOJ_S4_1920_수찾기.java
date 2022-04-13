package BOJ.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_1920_수찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int N, M;
	static int[] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			int start = 0;
			int end = N-1;
			
			while(true) {
				
				if(start > end) {
					answer.append(0+"\n");
					break;
				}
				
				int mid = (start + end) / 2;

				if(nums[mid] == target) {
					answer.append(1+"\n");
					break;
				}else if(nums[mid] < target) {
					start = mid+1;
				}else if(target < nums[mid]) {
					end = mid - 1;
				}
			
			}
		}
		
		System.out.println(answer);
		
		
	}
	
	private static String src = "5\r\n" + 
			"4 1 5 2 3\r\n" + 
			"5\r\n" + 
			"1 3 7 9 5";

}
