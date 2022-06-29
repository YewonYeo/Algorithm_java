package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_14395_4연산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	
	static int s, t;
	
	static class Num{
		long sum;
		String signs;
		
		public Num(long sum, String signs) {
			this.sum = sum;
			this.signs = signs;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		// s랑 t랑 같은 경우 0 출력
		if(s==t) {
			answer.append(0);
		}
		else {
			bfs();
		}
		
		System.out.println(answer);
		
		
	}
	
	static void bfs() {
		Queue<Num> queue = new LinkedList<Num>();
		queue.add(new Num(s, ""));
		
		// 중복된 결과는 큐에 넣지 않기 위해 set선언
		HashSet<Long> set = new HashSet<>();
		
		// 사전순 출력
		while(!queue.isEmpty()) {
			Num current = queue.poll();
			
			if(current.sum == t) {
				answer.append(current.signs);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				long newSum = 0L;
				String newSigns = "";
				
				switch (i){
				case 0:
					newSum = current.sum * current.sum;
					newSigns = current.signs+"*";
					break;
				case 1:
					newSum = current.sum + current.sum;
					newSigns = current.signs+"+";
					break;
				case 2:
					newSum = current.sum - current.sum;
					newSigns = current.signs+"-";
					break;
				case 3:
					// 0이 아닌 경우만 나누기 계산
					if(current.sum != 0) {
						newSum = current.sum / current.sum;
						newSigns = current.signs + "/";
					}
					break;
				}
				
				// 나왔던 값이 아닌 경우 queue에 추가
				if(!set.contains(newSum)) {
					set.add(newSum);
					queue.add(new Num(newSum, newSigns));
				}
				
			}
		}
		// 만들 수 없는 경우 -1 출력
		answer.append(-1);
		return;
	}

}
