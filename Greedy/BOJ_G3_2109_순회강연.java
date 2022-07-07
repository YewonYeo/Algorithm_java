package BOJ.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_2109_순회강연 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static boolean[] visited;
	static Lecture[] lectures;
	
	static class Lecture implements Comparable<Lecture>{
		int day, pay;
		
		public Lecture(int pay, int day) {
			this.day = day;
			this.pay = pay;
		}
		
		@Override
		public int compareTo(Lecture o) {
			// pay를 기준으로 내림차순 정
			if(this.pay != o.pay) {
				return (this.pay - o.pay)*(-1);
			}else {
				// 만약 같은 pay라면 날짜가 더 먼 것을 기준으로 정렬
				return (this.day - o.day)*(-1);
			}
		}

		@Override
		public String toString() {
			return "Lecture [day=" + day + ", pay=" + pay + "]";
		}
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		lectures = new Lecture[N];
		visited = new boolean[10001];
		int result = 0;
		
		if(N == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lectures);
		
		
		for(int i = 0; i < N; i++) {
			int currentDay = lectures[i].day;
			int currentPay = lectures[i].pay;
			
			// 해당 날짜부터 1일까지 빈 자리가 있는 경우 해당 날짜에 강연.
			for(int j =currentDay; j >=1; j--) {
				if(!visited[j]) {
					visited[j] = true;
					result += currentPay;
					break;
				}
			}
		}
		
		System.out.println(result);
		
	}
	private static String src = "3\n" + 
			"100 2\n" + 
			"50 2\n" + 
			"30 1\n" ;

}
