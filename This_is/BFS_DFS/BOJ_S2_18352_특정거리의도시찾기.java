package Dong.bfs_dfs;

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
	
	
	static int N, M, K, X;
	static int[] distance;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		distance = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
		}
		
		distance[X] = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(X);
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int i = 0; i < graph.get(current).size(); i++) {
				int next = graph.get(current).get(i);
				if(distance[next] == Integer.MAX_VALUE) {
					distance[next] = distance[current] + 1;
					q.offer(next);
				}
			}
		
		}
		
		boolean check = false;
		for(int i = 1; i <= N; i++) {
			if(distance[i] == K) {
				answer.append(i).append("\n");
				check = true;
			}
		}
		
		if(!check) {
			System.out.println(-1);
		}else {
			answer.setLength(answer.length()-1);
			System.out.println(answer);
		}
		
		
	}
	
	private static String src = "4 4 2 1\n" + 
			"1 2\n" + 
			"1 3\n" + 
			"2 3\n" + 
			"2 4";

}
