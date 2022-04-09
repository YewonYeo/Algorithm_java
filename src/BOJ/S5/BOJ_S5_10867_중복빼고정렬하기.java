package BOJ.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_S5_10867_중복빼고정렬하기 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	
	private static int T;
	private static Set<Integer> numbers = new TreeSet<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < T; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		
		Iterator<Integer> it = numbers.iterator();
		while(it.hasNext()) {
			answer.append(it.next()+" ");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		
		br.close();
	}
}
