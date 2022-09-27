package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_18352_특정거리의도시찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int city, road, K, start;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int[] d;
	
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		city = Integer.parseInt(st.nextToken());
		road = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		d = new int[city+1];
		
		// 그래프 초기화
		for(int i = 0; i <= city; i++) {
			graph.add(new ArrayList<Integer>());
			d[i] = -1;
		}
		
		// 간선 정보 입력받기
		for(int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}
	
		
		dijkstra();
		
		boolean isCheck = false;
		for(int i = 1; i <= city; i++) {
			if(d[i] == K) {
				answer.append(i).append("\n");
				isCheck = true;
			}
		}
		
		if(isCheck == false) {
			answer.append(-1);
		}
		
		System.out.println(answer);

	}
	
	private static void dijkstra() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		d[start] = 0;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int i = 0; i < graph.get(current).size(); i++) {
				int next = graph.get(current).get(i);
				if(d[next] == -1) {
					d[next] = d[current] + 1;
					q.offer(next);
				}
			}	
		}
	}
	
	private static String src = "4 4 2 1\n" + 
			"1 2\n" + 
			"1 3\n" + 
			"2 3\n" + 
			"2 4";

}
