package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_133335_트럭 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int N, W, L;
	private static Queue<Integer> bridge;
	private static Queue<Integer> trucks;
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		bridge = new LinkedList<Integer>();
		
		
		trucks = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}
		
		// 입력완료
		
		int time = 0;
		int sum = 0;
		
		// 다리는 0으로 초기화
		for(int i = 0; i < W; i++) {
			bridge.add(0);
		}
		
		
		while(!bridge.isEmpty()) {
			time++;
			
			// 다리의 가장 왼쪽 트럭 빼기
			sum -= bridge.poll();
			
			// 건너갈 트럭이 남아 있다면
			if(!trucks.isEmpty()) {
				if(sum + trucks.peek() <= L) {
					sum += trucks.peek();
					bridge.add(trucks.poll());
				}else {
					bridge.add(0);
				}
			}
		}
		
		System.out.println(time);
	}
	
	private static String src = "4 2 10\r\n" + 
			"7 4 5 6";

}
