package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_G5_2116_주사위쌓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] dices;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		// 마주보는 면: a(0)-f(5), b(1)-d(3), c(2)-e(4)
		// 첫 주사위의 6개의 면이 바닥인 경우를 모두 구해서 최대 값을 구한다.
		
		N = Integer.parseInt(br.readLine());
		dices = new int[N][6];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = Integer.MIN_VALUE;
		
		// 첫 주사위의 모든면을 계산
		for(int i = 0; i < 6; i++) {
			sumDice(dices[0][i], 0, 0);
		}
		
		System.out.println(answer);
		
	}
	static void sumDice(int bottom, int num, int sum) {
		
		// N번째 주사위까지 다 구한 경우 리턴
		if(num == N) {
			answer = Math.max(answer, sum);
			return;
		}
		
		int index = 0; // 주사위 면
		int nextBottom = 0; // 현 주사위의 윗면
		int[] dice = dices[num]; // 현재 탐색하는 주사위
		
		// bottom에 해당하는 숫자의 면(인덱스) 찾기
		for(int i = 0; i < 6; i++) {
			if(dice[i] == bottom) {
				index = i;
			}
		}
		
		// 가능한 옆면 중 제일 큰 숫자 고르기
		int temp = 0;
		
		// a면이 바닥인 경우 -> 윗면은 f
		if(index == 0) {
			for(int i = 1; i <= 4; i++) {
				temp = Math.max(temp, dice[i]);
			}
			sum += temp;
			nextBottom = dice[5];
		}
		// b면이 바닥인 경우 -> 윗면은 d
		else if(index == 1) {
			for(int i = 0; i < 6 ; i++) {
				if(i == 1 || i == 3) continue;
				temp = Math.max(temp, dice[i]);
			}
			sum += temp;
			nextBottom = dice[3];
		}
		// c면이 바닥인 경우 -> 윗면은 e
		else if(index == 2) {
			for(int i = 0; i < 6; i++) {
				if(i == 2 || i == 4) continue;
				temp = Math.max(temp, dice[i]);
			}
			sum += temp;
			nextBottom = dice[4];
		}
		// d면이 바닥인 경우 -> 윗면은 b
		else if(index == 3) {
			for(int i = 0; i < 6; i++) {
				if(i == 1 || i == 3) continue;
				temp = Math.max(temp, dice[i]);
			}
			sum += temp;
			nextBottom = dice[1];
		}
		// e면이 바닥인 경우 -> 윗면은 c
		else if(index == 4) {
			for(int i = 0; i < 6 ; i++) {
				if(i == 2 || i == 4) continue;
				temp = Math.max(temp, dice[i]);
			}
			sum += temp;
			nextBottom = dice[2];
		}
		// f면이 바닥인 경우 -> 윗면은 a
		else if(index == 5) {
			for(int i = 1; i <= 4; i++) {
				temp = Math.max(temp, dice[i]);
			}
			sum += temp;
			nextBottom = dice[0];
		}
		sumDice(nextBottom, num+1, sum);
		
	}
	private static String src = "5\n" + 
			"2 3 1 6 5 4\n" + 
			"3 1 2 4 6 5\n" + 
			"5 6 4 1 3 2\n" + 
			"1 3 6 2 4 5\n" + 
			"4 1 6 5 2 3";

}
