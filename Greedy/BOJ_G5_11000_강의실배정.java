package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G5_11000_강의실배정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int count, N;
	static Lecture[] array;
	
	static class Lecture implements Comparable<Lecture>{
		int start, end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}else {
				return this.start - o.start;
			}
		}
	}
	
	static PriorityQueue<Integer> lectures = new PriorityQueue<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// del
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		array = new Lecture[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			array[i] = new Lecture(start, end);
		}
		
		Arrays.sort(array);
		lectures.add(array[0].end);
		
		for(int i = 1; i < N; i++) {
			Lecture current = array[i];
			
			if(current.start >= lectures.peek()) {
				lectures.poll();
			}
			
			lectures.add(current.end);
		}
		
		System.out.println(lectures.size());

	}
	private static String src = "3\n" + 
			"1 3\n" + 
			"2 4\n" + 
			"3 5";

}
