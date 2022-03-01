package BOJ.S5.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author yeeeh
 * @since 2022. 3. 2.
 * @see https://www.acmicpc.net/problem/11650
 * @category 정렬
 */

public class BOJ_S5_11650_좌표정렬하기 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	
	private static int T;
	private static Point[] input;
	
	static class Point{
		int x; int y;


		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}


		@Override
		public String toString() {
			return x+" "+y;
		}
		
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		input = new Point[T];
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(input, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x == o2.x) return o1.y - o2.y;
				
				return o1.x - o2.x;
			}
			
		});
		
		for(int i = 0; i < input.length; i++) {
			answer.append(input[i]).append("\n");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
	}

}
