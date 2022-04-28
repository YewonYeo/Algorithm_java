package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1697_숨바꼭질 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K;
	static int dist[];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dist = new int[100002];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		int time = 1;
		dist[N] = 1;
		
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			
			if(current == K) System.out.println(dist[K]-1);
			
			// x-1
			if(current-1 >= 0 && dist[current-1] == 0) {
				queue.add(current-1);
				dist[current-1] = dist[current]+1;
			}
			// x+1
			if(current+1 <= 100000 && dist[current+1] == 0) {
				queue.add(current+1);
				dist[current+1] = dist[current]+1;
			}
			
			// x*2
			if(current*2 <= 100000 && dist[current*2] == 0) {
				queue.add(current*2);
				dist[current*2] = dist[current]+1;
			}
		
		}
		
		
		

	}

}
