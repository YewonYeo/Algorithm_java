package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2230_수고르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
		int end = 0; // 빼는 수
		int min = Integer.MAX_VALUE; // 최소 값
		
		for(int start = 0; start < N; start++) { // 빼어지는 수
			
			// 두 수의 차가 M보다 작거나 빼는 수 인덱스가 N보다 작다면 빼는 수 증가
			while(end < N && nums[end] - nums[start] < M) {
				end++;
			}
			
			// 빼는 수 인덱스가 N과 같다면 break
			if(end == N) {
				break;
			}
			
			// 최소 값 갱신
			min = Integer.min(min, nums[end] - nums[start]);
			
		}
		
		System.out.println(min);


	}
	
	private static String src = "3 3\r\n" + 
			"1\r\n" + 
			"5\r\n" + 
			"3";

}
