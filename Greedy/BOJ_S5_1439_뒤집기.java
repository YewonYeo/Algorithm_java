package Dong.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_S5_1439_뒤집기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int before;
	static int[] nums = new int[2];

	public static void main(String[] args) throws IOException {
		// del
		br = new BufferedReader(new StringReader(src));
		String input = br.readLine();
		
		before = input.charAt(0) - '0';
		nums[before]++;
		for(int i = 0; i < input.length(); i++) {
			int cur = input.charAt(i) - '0';
			
			if(cur == before) {
				continue;
			}else {
				nums[cur]++;
				before = cur;
			}
		}
		
		if(nums[0] == 0 | nums[1] == 0) {
			System.out.print(0);
		}else {
			System.out.print(Math.min(nums[0], nums[1]));
		}
		
		
	}
	
	private static String src = "11101101";

}
