package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_2251_물통 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static int A, B, C;
	
	static class Water {
		int a, b, c;
		
		public Water(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		bfs();
		
		Collections.sort(numbers);
		
		for(int i = 0; i < numbers.size(); i++) {
			answer.append(numbers.get(i)).append(" ");
		}
		
		answer.setLength(answer.length()-1);
		System.out.println(answer);
	}
	
	static void bfs() {
		
		Queue<Water> queue = new LinkedList<Water>();
		boolean[][][] visited = new boolean[201][201][201];
		
		queue.add(new Water(0, 0, C));
		visited[A][B][C] = true;
		
		while(!queue.isEmpty()) {
			Water current = queue.poll();
			
			if(current.a == 0) {
				if(!numbers.contains(current.c)) {
					numbers.add(current.c);
				}
			}
			
			// A -> B
			if(current.a + current.b <= B) {
				if(!visited[0][current.b + current.a][current.c]) {
					queue.add(new Water(0, current.b + current.a, current.c));
					visited[0][current.b + current.a][current.c] = true;
				}
			}else{
				if(!visited[current.a - (B - current.b)][B][current.c]) {
					queue.add(new Water(current.a - (B - current.b), B, current.c));
					visited[current.a - (B - current.b)][B][current.c] = true;
				}
			}
			// A -> C
			if(current.a + current.c <= C) {
				if(!visited[0][current.b][current.c+current.a]) {
					queue.add(new Water(0, current.b, current.c + current.a));
					visited[0][current.b][current.a + current.c] = true;
				}
			}else{
				if(!visited[current.a - (C - current.c)][current.b][C]) {
					queue.add(new Water(current.a - (C - current.c), current.b, C));
					visited[current.a - (C - current.c)][current.b][C] = true;
				}
			}
			// B -> A
			if(current.a + current.b <= A) {
				if(!visited[current.a + current.b][0][current.c]) {
					queue.add(new Water(current.a + current.b, 0, current.c));
					visited[current.a + current.b][0][current.c] = true;
				}
			}else{
				if(!visited[A][current.b - (A - current.a)][current.c]) {
					queue.add(new Water(A, current.b - (A - current.a), current.c));
					visited[A][current.b - (A - current.a)][current.c] = true;
				}
			}
			// B -> C
			if(current.c + current.b <= C) {
				if(!visited[current.a][0][current.c + current.b]) {
					queue.add(new Water(current.a, 0, current.c + current.b));
					visited[current.a][0][current.c + current.b] = true;
				}
			}else{
				if(!visited[current.a][current.b - (C - current.c)][C]) {
					queue.add(new Water(A, current.b - (C - current.c), C));
					visited[current.a][current.b - (C - current.c)][C] = true;
				}
			}
			// C -> A
			if(current.c + current.a <= A) {
				if(!visited[current.a + current.c][current.b][0]) {
					queue.add(new Water(current.a + current.c, current.b, 0));
					visited[current.a + current.c][current.b][0] = true;
				}
			}else {
				if(!visited[A][current.b][current.c - (A - current.a)]) {
					queue.add(new Water(A, current.b, current.c - (A - current.a)));
					visited[A][current.b][current.c - (A - current.a)] = true;
				}
			}
			// C -> B
			if(current.c + current.b <= B) {
				if(!visited[current.a][current.b + current.c][0]) {
					queue.add(new Water(current.a, current.b + current.c, 0));
					visited[current.a][current.b + current.c][0] = true;
				}
			}else {
				if(!visited[current.a][B][current.c - (B - current.b)]) {
					queue.add(new Water(current.a, B, current.c - (B - current.b)));
					visited[current.a][B][current.c - (B - current.b)] = true;
				}
			}
		
		}
	}
	
	private static String src = "8 9 10";

}
