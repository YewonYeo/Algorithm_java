package BOJ.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class BOJ_S2_2304_창고다각형 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int N, maxHeight, maxIndex;
	private static LinkedList<Pillar> pillars;
	private static int area;
	
	static class Pillar implements Comparable<Pillar>{
		int locate;
		int height;
		
		public Pillar(int locate, int height) {
			this.locate = locate;
			this.height = height;
		}

		@Override
		public String toString() {
			return "Pillar [locate=" + locate + ", height=" + height + "]";
		}

		@Override
		public int compareTo(Pillar o) {
			return this.locate - o.locate;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());
		pillars = new LinkedList<Pillar>();
		maxHeight = Integer.MIN_VALUE;
		maxIndex = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			pillars.add(new Pillar(l, h));
			if(h > maxHeight) {
				maxHeight = h;
			}
			
			
		}
		
		Collections.sort(pillars);
		// 입력 완료
		
		// 왼쪽 기준으로 처음 나온 최대 높이 기둥을 maxIndex에 담기.
		for(int i = 0; i < pillars.size(); i++) {
			if(pillars.get(i).height == maxHeight) {
				maxIndex = i;
				break;
			}
		}
		
		int area = 0;
		// 왼 -> 오른
		for(int i = 0; i < maxIndex; i++) { // 채울 기둥 인덱스       
			for(int j = i+1; j <= maxIndex; j++) { // 비교할 기둥
				if(pillars.get(i).height <= pillars.get(j).height) { // 채울 기둥 높이 <= 비교 기둥 높이
					area += pillars.get(i).height * (pillars.get(j).locate - pillars.get(i).locate); // 채우기
					i = j; // 채울 기둥을 비교한 기둥으로 바꿈.
				}
				// 채울 기둥 > 비교기둥 인 경우 -> 다음 기둥과 비교.
			}
		}
		
		// 오른 -> 왼
		for(int i = N-1; i > maxIndex; i--) { // 채울 기둥 인덱스 ( maxIndex 까지 본다. )
			for(int j = i-1; j >= maxIndex; j--) {  // 비교할 기둥
				if(pillars.get(i).height <= pillars.get(j).height) { // 채울 기둥 <= 비교 기둥
					area += pillars.get(i).height * (pillars.get(i).locate - pillars.get(j).locate); // 채우기
					i = j; // 채울 기둥을 비교한 기둥으로 바꿔줌
				}
				
			}
		}
		area += pillars.get(maxIndex).height; // 최대 높이 기둥 한 개 추가.
		
		System.out.println(area);
		
		
		
	}

}
