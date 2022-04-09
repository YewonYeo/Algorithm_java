package week_re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_S5_7568_덩치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static class Info{
		int weight, height, order;
		
		public Info(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}

		@Override
		public String toString() {
			return "Info [weight=" + weight + ", height=" + height + "]";
		}
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		int N = Integer.parseInt(br.readLine());
		Info[] list = new Info[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		for(int i = 0; i < N; i++) {
			int rank = 1;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				
				if(list[i].height < list[j].height && list[i].weight < list[j].weight) {
					rank++;
				}
			}
			answer.append(rank).append(" ");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
	}
	
	private static String src = "5\r\n" + 
			"55 185\r\n" + 
			"58 183\r\n" + 
			"88 186\r\n" + 
			"60 175\r\n" + 
			"46 155";

}
