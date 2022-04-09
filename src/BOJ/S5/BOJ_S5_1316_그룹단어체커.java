package BOJ.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ_S5_1316_그룹단어체커 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		N = Integer.parseInt(br.readLine());
		outer: for(int i = 0; i < N; i++) {
			String str = br.readLine();
			boolean[] alpha = new boolean[26];
			// 입력 된 문자열의 길이만큼 반복문 수행
			for(int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				// 나온적 없는 경우? 방문처리 후 다음 알파벳으로
				if(!alpha[c - 97]){
					alpha[c-97] = true;
					continue;
				}
				// 나온 적 있는 경우? 이전 단어와 같은지 체크
				else {
					// 이전 단어와 같다면? 연속된 문자
					if(str.charAt(j-1) == c) {
						continue;
					}
					// 이전 단어와 다르다면? 그룹 문자 아님
					else {
						continue outer;
					}
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	private static String src = "1\r\n" + 
			"z";

}
