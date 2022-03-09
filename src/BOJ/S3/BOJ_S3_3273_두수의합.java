package BOJ.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 조합은 시간초과


public class BOJ_S3_3273_두수의합 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int n, x;
	private static int[] numbers;
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		n = Integer.parseInt(br.readLine());
		numbers = new int [n];
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		int start = 0; int end = n -1;
		
		while(start < end) {
			int temp = numbers[start] + numbers[end];
			
			if(temp == x) {
				cnt++;
				start++;
				end--;
			}else if(temp < x) {
				start++;
			}else {
				end--;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	
	private static String src = "9\r\n" + 
			"5 12 7 10 9 1 2 3 11\r\n" + 
			"13";

}
