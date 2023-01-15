package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_G4_1717_집합의표현 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int n, m;
	static int[] parent;
	
	static void makeSet() {
		parent = new int[n+1];
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	static int findParent(int a) {
		if(a == parent[a]) return a;
		return parent[a] = findParent(parent[a]);
	}
	
	static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a == b) return;
		
		if(a > b) {
			parent[a] = b;
		}else {
			parent[b] = a;
		}
	}
	
	static boolean isSameParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a == b) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		makeSet();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(type == 0) {
				union(a, b);
			}else {
				if(isSameParent(a, b)) {
					answer.append("YES").append("\n");
				}else {
					answer.append("NO").append("\n");
				}
			}
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
	}
	private static String src = "7 8\n" + 
			"0 1 3\n" + 
			"1 1 7\n" + 
			"0 7 6\n" + 
			"1 7 1\n" + 
			"0 3 7\n" + 
			"0 4 2\n" + 
			"0 1 1\n" + 
			"1 1 1";

}
