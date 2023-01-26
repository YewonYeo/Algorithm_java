package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_S1_5525_IOIOI {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M;
	static char[] S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine().toCharArray();
		
		int result = 0;
		int cnt = 0;
		
		for(int i = 1; i < M-1; i++) {
			if(S[i-1] == 'I' && S[i] == 'O' && S[i+1] == 'I') {
				cnt++;
				if(cnt == N) {
					result++;
					// 한 패턴만큼 오른쪽으로 이동 후 확인해야 하므로 패턴 수 1 감소
					cnt--;
				}
				// 다음 으로 이동
				i++;
			}else {
				cnt = 0;
			}
		}
		
		System.out.println(result);
		

	}
	private static String src = "2\n" + 
			"13\n" + 
			"OOIOIOIOIIOII";

}
