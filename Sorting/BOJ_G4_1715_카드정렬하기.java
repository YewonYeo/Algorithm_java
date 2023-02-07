package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BOJ_G4_1715_카드정렬하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int[] card;
	static int answer;
	
	static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		answer = 0;
		
		for(int i = 0; i < N; i++) {
			queue.add(Integer.parseInt(br.readLine()));
		}
		
		if(queue.size()== 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		while(!queue.isEmpty()) {
			if(queue.size() == 1) {
				break;
			}
			
			int a = queue.poll();
			int b = queue.poll();
			
			answer += (a+b);
			queue.add(a+b);
		}
		
		
		
		System.out.println(answer);
	}

}
