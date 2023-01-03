package Dong.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
public class 기출_곱하기혹은더하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] nums;
	static int max;

	public static void main(String[] args) throws IOException {
		// 숫자로만 이루어진 문자열 s. 숫자 이에 * 혹은 + 연산자를 넣어 가장 큰 수
		br = new BufferedReader(new StringReader(src));
		
		String temp = br.readLine();
		nums = new int[temp.length()];
		for(int i = 0; i < temp.length(); i++) {
			nums[i] = temp.charAt(i) - '0';
		}
		
		max = nums[0];
		for(int i = 1; i < temp.length(); i++) {
			int plus = max + nums[i];
			int multiple = max * nums[i];
			
			max = Math.max(plus, multiple);
		}
		
		System.out.print(max);
		

	}
	private static String src = "567";
}
