package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S2_2644_촌수계산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, depth, x, y, result;
	static List<Integer>[] nodes;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// del
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		nodes = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			nodes[parent].add(child);
			nodes[child].add(parent);
		}
		visited[x] = true;
		dfs(x, 0);
		
		if(result == 0) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
	
	private static void dfs(int current, int cnt) {
		
		if(current == y) {
			result = cnt;
			return;
		}
		
		// 자식 탐색
		for(int i = 0; i < nodes[current].size(); i++) {
			int next = nodes[current].get(i);
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, cnt+1);
			}
		}
		
	}
	private static String src = "5\n" + 
			"1 5\n" + 
			"4\n" + 
			"1 2\n" + 
			"1 3\n" + 
			"2 4\n" + 
			"3 5";

}
