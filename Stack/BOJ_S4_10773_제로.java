package BOJ.S4;

import java.io.*;
import java.util.*;

public class BOJ_S4_10773_제로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int K;
	static Stack<Integer> numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(br.readLine());
		numbers = new Stack<Integer>();
		
		for(int i = 0; i < K; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0 && !numbers.isEmpty()) {
				numbers.pop();
			}else if(temp != 0) {
				numbers.add(temp);
			}
		}
		
		int sum = 0;
		int size = numbers.size();
		for(int i = 0; i < size; i++) {
			sum += numbers.pop();
		}
		
		System.out.println(sum);
	}
	
}
