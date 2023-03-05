package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_11724_연결요소의개수 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M, answer;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		answer = 0;
		
		for(int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(adj[u].contains(v)) continue;
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);
		

	}
	
	static void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);
		visited[vertex] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i = 0; i < adj[current].size(); i++) {
				if(!visited[adj[current].get(i)]) {
					visited[adj[current].get(i)] = true;
					queue.add(adj[current].get(i));
				}
			}
		}
	}
	
	static void dfs(int vertex) {
		if(visited[vertex]) {
			return;
		}
		
		visited[vertex] = true;
		
		for(int i = 0; i < adj[vertex].size(); i++) {
			int current = adj[vertex].get(i);
			
			if(!visited[current]) {
				dfs(current);
			}
		}
		
	}
	private static String src = "6 8\n" + 
			"1 2\n" + 
			"2 5\n" + 
			"5 1\n" + 
			"3 4\n" + 
			"4 6\n" + 
			"5 4\n" + 
			"2 4\n" + 
			"2 3";

}
