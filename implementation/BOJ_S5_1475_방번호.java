package BOJ.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_S5_1475_방번호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, answer;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		// 1세트: 0~9 , 6/9 는 같이 쓸 수 있음
		String room = br.readLine();
		numbers = new int[9];
		int max = 0;
		
		for(int i = 0; i < room.length(); i++) {
			
			int number = room.charAt(i) - '0';
			
			if(number == 9) {
				numbers[6]++;
			}else {
				numbers[number]++;
			}
		}
		
		
		for(int i = 0; i < numbers.length; i++) {
			if(i == 6) {
				int temp = numbers[i];
				if(temp % 2 != 0) {
					temp = temp/2 + 1;
				}else {
					temp /= 2;
				}
				
				if(temp > max) {
					max = temp;
				}
			}else {
				if(numbers[i] > max) {
					max = numbers[i];
				}
			}
		}
		
		
		System.out.println(max);
		

	}
	
	private static String src = "9991";

}
