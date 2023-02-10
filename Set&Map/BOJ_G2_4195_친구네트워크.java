package BOJ.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_G2_4195_친구네트워크 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int[] parent, count;
	static int T, F;
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			if(a < b) {
				parent[b] = a;
				count[a] += count[b];
				return count[a];
			}else {
				parent[a] = b;
				count[b] += count[a];
				return count[b];
			}
		}
		
		return count[a];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			F = Integer.parseInt(br.readLine());
			parent = new int[F*2];
			count = new int[F*2];
			for(int i = 0; i < F*2; i++) {
				parent[i] = i;
			}
			Arrays.fill(count, 1);
			
			HashMap<String, Integer> map = new HashMap<>();
			int index = 0;
			for(int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				
				if(!map.containsKey(f1)) {
					map.put(f1, index++);
				}
				if(!map.containsKey(f2)) {
					map.put(f2, index++);
				}
				answer.append(union(map.get(f1), map.get(f2))).append("\n");
			}
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
		

	}
	private static String src = "2\n" + 
			"3\n" + 
			"Fred Barney\n" + 
			"Barney Betty\n" + 
			"Betty Wilma\n" + 
			"3\n" + 
			"Fred Barney\n" + 
			"Betty Wilma\n" + 
			"Barney Betty";

}
