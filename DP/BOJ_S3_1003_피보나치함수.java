package BOJ.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S3_1003_피보나치함수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer = new StringBuilder();

	static int T, N;
	static long[] dp = new long[41];
	static int[] input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		input = new int[T];
		int max = 0;

		for (int i = 0; i < T; i++) {
			int temp = Integer.parseInt(br.readLine());
			input[i] = temp;
			max = Math.max(temp, max);
		}

		dp = new long[max + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= max; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		for (int i = 0; i < input.length; i++) {
			int temp = input[i];
			if (temp == 0) {
				answer.append(1 + " " + 0+"\n");
			} else if (temp == 1) {
				answer.append(0 + " " + 1+"\n");
			} else {
				answer.append(dp[temp - 1] + " " + dp[temp]+"\n");
			}
		}
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		br.close();
	}

}
