package BOJ.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_1475_방번호 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int[] numbers = new int[9];  // 숫자 배열 0 ~ 8
	private static int max;                     
	
	public static void main(String[] args) throws IOException {
		
		// 9와 6인 경우를 하나로 합친 후, 그 합이 홀수/짝수 인 경우로 나누어 풀이.
		
		String roomNumber = br.readLine();    // 방번호 입력받기
		
		for(int i = 0; i < roomNumber.length(); i++) {
			int temp = roomNumber.charAt(i) - '0';   // 방번호 한글자씩 temp 에 할당
			
			if(temp == 9) {         // 9일 때는 6의 개수 증가
				numbers[6]++;
			}else {
				numbers[temp]++;    // 9가 아닌경우 해당 숫자 증가
			}
	
		}
		
		if(numbers[6] % 2 == 0) {       // 9+6 의 합이 짝수인 경우
			numbers[6] /= 2;            // 2 나눈 값으로 할당
		}else {
			numbers[6] = numbers[6] / 2 + 1;   // 2 나눈 값 + 1
		}
		
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
			}
		}
		
		System.out.println(max);
		
	}

}
