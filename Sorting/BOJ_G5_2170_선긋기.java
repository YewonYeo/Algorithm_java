package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2170_선긋기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int start, end;
	static int answer;
	static Line[] lines;
	
	static class Line implements Comparable<Line>{
		int start, end;
		
		public Line(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Line o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}else {
				return this.start - o.start;
			}
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 선을 입력받아 시작 좌표로 졍렬 후 이을 수 있는 선이면 있고, 이을 수 없다면 길이 저장 후 새 범위로 갱신
		br = new BufferedReader(new StringReader(src));
		
		
		answer = 0;
		N = Integer.parseInt(br.readLine());
		lines = new Line[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lines);
		
		start = lines[0].start;
		end = lines[0].end;
		
		
		for(int i = 1; i < N; i++) {
			Line cur = lines[i];
			
			// 시작 점이 현재 범위 내에 있는 경우
			if(start <= cur.start && cur.start <= end) {
				// 끝 점이 현재 범위 내에 있는 경우
				if(cur.end <= end) {
					continue;
				}
				// 끝 점 갱신
				else {
					end = cur.end;
				}
			}
			// 시작 점이 현재 범위 밖인 경우, 이전 길이 더해준 후 범위 갱신
			else if(cur.start > end) {
				answer += (end-start);
				start = cur.start;
				end = cur.end;
			}
			
			
		}
		
		answer += (end - start);
		System.out.println(answer);

	}
	private static String src = "4\n" + 
			"1 3\n" + 
			"2 5\n" + 
			"3 5\n" + 
			"6 7";

}
