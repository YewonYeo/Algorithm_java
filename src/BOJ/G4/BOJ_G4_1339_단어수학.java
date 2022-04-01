package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 	GCF = 100*G + 10*C + 1*F
 	ACDEB = 10000*A + 1000*C + 100*D + 10*E + 1*B
 	
 	10000*A + 1000*C + 100*D + 10*E + 1*B + 100*G + 10*C + 1*F
 	= 10000*A + 1000*C +100*D + 100*G + 10*E + 10*C + 1*B +1*F
 	
 	위의 순서에 맞게 9부터 대입하여 최종 값 계산.

 */

public class BOJ_G4_1339_단어수학 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N;  // 단어의 개수
	private static int[] alphabets = new int[26];  // 알파벳 계수 배열
	private static Alph[] answer = new Alph[26];   // 알파벳 정보 (계수, 알파벳)
	private static int result;                     // 수의 합
	
	static class Alph implements Comparable<Alph>{
		char alphabet;  // 알파벳
		int size;       // 계수
		
		Alph(char alphabet, int size) {
			this.alphabet = alphabet;
			this.size = size;
		}

		@Override
		public int compareTo(Alph o) {             // 계수가 큰 순서로 정렬
			return (this.size - o.size) * (-1) ;
		}

		@Override
		public String toString() {
			return "Alph [alphabet=" + alphabet + ", size=" + size + "]";
		}
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			int cnt = temp.length()-1;      // 각 문자열의 첫번째문자: 10^(문자열길이-1)
			
			for(int j = 0; j < temp.length(); j++) { // 지수를 줄여주면서, 해당 문자의 인덱스를 증가
				alphabets[temp.charAt(j) - 65] += (Math.pow(10, cnt--));  // 0번째 : A
			}
		}
		
		for(int i = 0; i < alphabets.length; i++) { // Alph 객체를 만들어 answer 배열에 추가
			answer[i] = new Alph((char)(65+i), alphabets[i]);
		}
		
		Arrays.sort(answer); // answer 배열 정렬
		
		int num = 9;  // 대입할 수는 9부터
		
		for(int i = 0; i < answer.length; i++) {
			result += (answer[i].size) * (num--);   // 결과 += (알파벳의 계수 * 대입수)
		}
		
		System.out.println(result);
	}

}
