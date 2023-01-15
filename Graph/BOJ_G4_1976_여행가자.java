package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_1976_여행가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[] parent;
	static ArrayList<ArrayList<Integer>> graph;
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return false;
		
		if(xRoot < yRoot) {
			parent[yRoot] = xRoot;
		}else {
			parent[xRoot] = yRoot;
		}
		return true;
	}
	
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) {
			return true;
		}else {
			return false;
		}
				
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= N; c++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					union(r, c);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int root = find(Integer.parseInt(st.nextToken()));
		
		for(int i = 0; i < M-1; i++) {
			int temp = find(Integer.parseInt(st.nextToken()));
			if(root == temp) {
				continue;
			}else {
				System.out.println("NO");
				System.exit(0);
			}
					
		}
		System.out.println("YES");
		
		
	}
	
	private static String src = "3\n" + 
			"3\n" + 
			"0 1 0\n" + 
			"1 0 1\n" + 
			"0 1 0\n" + 
			"1 2 3";
}
