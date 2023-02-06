package BOJ.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_10825_국영수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int N;
	static Score[] scores;
	
	static class Score implements Comparable<Score>{
		int K, E, M;
		String name;
		
		public Score(String name, int K, int E, int M) {
			this.K = K;
			this.E = E;
			this.M = M;
			this.name = name;
		}
		
		@Override public int compareTo(Score o) {
			if(this.K == o.K) {
				if(this.E == o.E) {
					if(this.M == o.M) {
						return this.name.compareTo(o.name);
					}else {
						return (this.M - o.M) * (-1);
					}
				}else {
					return this.E - o.E;
				}
			}else {
				return (this.K - o.K)* (-1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		scores = new Score[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			scores[i] = new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(scores);
		
		for(int i = 0; i < N; i++) {
			answer.append(scores[i].name).append("\n");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		
	}
	private static String src = "12\n" + 
			"Junkyu 50 60 100\n" + 
			"Sangkeun 80 60 50\n" + 
			"Sunyoung 80 70 100\n" + 
			"Soong 50 60 90\n" + 
			"Haebin 50 60 100\n" + 
			"Kangsoo 60 80 100\n" + 
			"Donghyuk 80 60 100\n" + 
			"Sei 70 70 70\n" + 
			"Wonseob 70 70 90\n" + 
			"Sanghyun 70 70 80\n" + 
			"nsj 80 80 80\n" + 
			"Taewhan 50 60 90";

}
