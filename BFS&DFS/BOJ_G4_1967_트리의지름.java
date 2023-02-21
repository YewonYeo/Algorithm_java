package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G4_1967_트리의지름 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, answer, farNode;
	static ArrayList<Node>[] adjList;
	static boolean[] visited;
	
	static class Node{
		int num, weight;
		
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		answer = 0;
		farNode = 0;
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[parent].add(new Node(child, weight));
			adjList[child].add(new Node(parent, weight));
		}
		
		visited[1] = true;
		dfs(1, 0);
		
		visited = new boolean[N+1];
		answer = 0;
		visited[farNode] = true;
		dfs(farNode, 0);
		
		System.out.println(answer);
	}
	
	static void dfs(int nodeNum, int weightSum) {
		
		if(answer < weightSum) {
			answer = weightSum;
			farNode = nodeNum;
		}
		
		for(Node next: adjList[nodeNum]) {
			
			if(visited[next.num]) continue;
			
			visited[next.num] = true;
			dfs(next.num, weightSum + next.weight);
		}
	}
	private static String src = "12\n" + 
			"1 2 3\n" + 
			"1 3 2\n" + 
			"2 4 5\n" + 
			"3 5 11\n" + 
			"3 6 9\n" + 
			"4 7 1\n" + 
			"4 8 7\n" + 
			"5 9 15\n" + 
			"5 10 4\n" + 
			"6 11 6\n" + 
			"6 12 10";

}
