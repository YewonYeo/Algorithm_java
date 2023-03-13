package BOJ.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_3613_JavavsC {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	

	public static void main(String[] args) throws IOException {
		
		/* 소문자 / 대문자 여부 알려주는 함수 
		 * Character.isLowerCase(char)
		 * Character.isUpperCase(char)
		 */
		
		String input = br.readLine();
		
		// _로 끝나는 경우
		if(input.charAt(input.length()-1) == '_') {
			error();
		}
		
		// _로 시작하는 경우
		if(input.charAt(0) == '_') {
			error();
		}
		
		// 첫 글자가 대문자인 경우
		if(Character.isUpperCase(input.charAt(0))) {
			error();
		}
		
		// _가 포함 되면 C로, 아닌 경우 Java로 인식
		if(input.contains("_")) {
			changeCtoJava(input);
		}else {
			changeJavatoC(input);
		}
	}
	
	// 에러 처리를 하는 함수
	private static void error() {
		System.out.println("Error!");
		System.exit(0);
	}
	
	// c -> java 변환 함수
	private static void changeCtoJava(String input) {
		StringBuilder str = new StringBuilder();
		// 직전 문자가 _였는지 확인하는 변수
		boolean flag = false;
		
		for(int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			
			// 직전 문자가 _인 경우
			if(flag) {
				// 연속으로 _면 에러
				if(temp == '_') {
					error();
				}else {
					// 대문자가 나오면 에러
					if(Character.isUpperCase(temp)) {
						error();
					}
					// 해당 문자를 대문자로 담기
					str.append(Character.toString(temp).toUpperCase());
					flag = false;
				}
			}else {
				// _인 경우 true로
				if(temp == '_') {
					flag = true;
				}else {
					if(Character.isUpperCase(temp)) {
						error();
					}
					// 해당 문자를 소문자로 담기
					str.append(temp);
				}
			}
		}
		System.out.println(str);
		
	}
	
	private static void changeJavatoC(String input) {
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			// 소문자인 경우 문자열에 추가
			if(Character.isLowerCase(temp)) {
				str.append(temp);
			}
			// 대문자인 경우 _ 추가 후 소문자로 바꾸어 문자열에 추가
			else {
				str.append("_").append(Character.toString(temp).toLowerCase());
			}
		}
		
		System.out.println(str);
	}

}
