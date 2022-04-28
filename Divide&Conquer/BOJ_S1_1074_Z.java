package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이차원 배열을 만들어 인덱스를 넣자
 * 재귀 함수에서 n이 1인경우 인덱스를 부여하자
 * 인덱스는 main영역 밖에서 사용해야 하므로 멤버변수로!
 * 메모리 초과...
 * 
 * 확인해야할 R, C 에 해당하는 범위만 탐색하자!
 */

public class BOJ_S1_1074_Z {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, R, C, M, num;

	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = (int) Math.pow(2, N);
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());


	}

	

	private static String src = "10 511 511";

}
