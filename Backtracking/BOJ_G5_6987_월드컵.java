package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_G5_6987_월드컵2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
	
	static int[][] resultInput = new int [6][3];
	static int[][] possibleResult = new int [6][3];
	static int[] result = new int[4];
	
	public static void main(String[] args) throws IOException {
		
		// del
		br = new BufferedReader(new StringReader(src));
		
		for(int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			resultInput = new int [6][3];
			possibleResult = new int [6][3];
			
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					resultInput[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(t, 0);
		}
		
		for(int i = 0; i < 4; i++) {
			answer.append(result[i]+" ");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		

	}
	
	static void dfs (int tc, int round) {
		
		// 15번째 경기인 경우
		if(round == 15) {
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					if(resultInput[i][j] != possibleResult[i][j]) {
						return;
					}
				}
			}
			
			result[tc] = 1;
			return;
		}
		
		int t1 = team1[round];
		int t2 = team2[round];
		
		// t1 승, t2 패
		possibleResult[t1][0]++;
		possibleResult[t2][2]++;
		dfs(tc, round+1);
		possibleResult[t1][0]--;
		possibleResult[t2][2]--;
		
		// t1 패, t2 
		possibleResult[t1][2]++;
		possibleResult[t2][0]++;
		dfs(tc, round+1);
		possibleResult[t1][2]--;
		possibleResult[t2][0]--;
		
		// 무승부
		possibleResult[t1][1]++;
		possibleResult[t2][1]++;
		dfs(tc, round+1);
		possibleResult[t1][1]--;
		possibleResult[t2][1]--;
	}
	
	
	private static String src = "5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4\n" + 
			"4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3\n" + 
			"5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5\n" + 
			"5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4";
	
}
