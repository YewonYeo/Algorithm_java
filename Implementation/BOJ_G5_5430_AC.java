package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_G5_5430_AC {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer = new StringBuilder();
	static StringTokenizer st;
	
	static Deque<Integer> num;
	
	static int T;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		
		outer: for(int t = 0; t < T; t++) {
			
			String orders = br.readLine(); // 명령의 개수를 입력받을 변수
			int n = Integer.parseInt(br.readLine()); // 수의 개수를 입력받을 변수
			String numbers = br.readLine(); // 수열의 수를 입력받을 변수
			boolean isRight = true; // 정방향인지 역방향인지 구분하는 변수
			
			// 숫자가 0인 경우
			if(n == 0) {
				// D 연산이 있다면 error 출력 후 다음 t.c 로
				if(orders.contains("D")) {
					answer.append("error").append("\n");
					continue outer;
				}
				else {
					answer.append("[]").append("\n");
					continue;
				}
			}
			
			// numbers 를 필요한 숫자로 가공하기
			st = new StringTokenizer(numbers, "[,]", false); // 문자열, 구분자, true/false
			num = new ArrayDeque<Integer>();
			
			for(int i = 0; i < n; i++) {
				num.add(Integer.parseInt(st.nextToken()));
			}
			
			// 명령의 개수 만큼 반복문을 실행하여 연산
			for(int o = 0; o < orders.length(); o++) {
				char order = orders.charAt(o);
				
				switch (order) {
				case 'R':
					isRight = !isRight;
					break;
				case 'D':
					// 배열이 비어있는 경우 error 출력 후 다음 t.c 로
					if(num.size() == 0) {
						answer.append("error").append("\n");
						continue outer;
					}
					
					else {
						// 정방향이면 앞에서 제거
						if(isRight) {
							num.pollFirst();
						}
						// 역방향이면 뒤에서 제거
						else {
							num.pollLast();
						}
					}
					break;
				}
				
			}
			
			if(num.size()==0) {
				answer.append("[]").append("\n");
			}
			else{
				answer.append("[");
				if(isRight) {
					while(!num.isEmpty()) {
						answer.append(num.pollFirst()).append(",");
					}
				}else {
					while(!num.isEmpty()){
						answer.append(num.pollLast()).append(",");
					}
				}
				answer.setLength(answer.length()-1);
				answer.append("]").append("\n");
			}
		}
		System.out.println(answer);

	}
	private static String src = "4\n" + 
			"RDD\n" + 
			"4\n" + 
			"[1,2,3,4]\n" + 
			"DD\n" + 
			"1\n" + 
			"[42]\n" + 
			"RRD\n" + 
			"6\n" + 
			"[1,1,2,3,5,8]\n" + 
			"D\n" + 
			"0\n" + 
			"[]";

}
