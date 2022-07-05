package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;



public class RE_BOJ_G4_1339_단어수학 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, index, result;
	static int[] coefficients = new int[26];	

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray(); // 각 알파벳의 배열로 만든다
			index = temp.length; // 문자열의 길이 = 지수
			
			for(int j = 0; j < temp.length; j++) {
				coefficients[temp[j]-65] += (int) Math.pow(10, --index);
			}
		}
		
		// 배열을 오름차순 정리
		Arrays.sort(coefficients);
		
		// 계수가 큰 수부터 9~1 순으로 할당
		int num = 9;
		for(int i = 25; i >= 0; i--) {
			if(coefficients[i] == 0) {
				break;
			}else {
				result += coefficients[i] * num--;
			}
		}
		
		System.out.println(result);
	}

}
