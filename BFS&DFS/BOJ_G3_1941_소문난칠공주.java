package BOJ.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

/* 
    1. 25명의 학생들 중에서 7명을 조합으로 뽑은 뒤
    2. 해당 조합에서 이다솜파 학생이 4명이상인지 확인 후
    3. bfs로 인접한지 체크한다. 
       (2, 3 에서는 조합에서 뽑인 좌표를 1로 칠한 배열 arr 를 공유한다.)
*/

public class BOJ_G3_1941_소문난칠공주 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static char[][] students = new char [5][5];
	private static int[][]deltas = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	private static int answer;
	private static LinkedList<Point> points = new LinkedList<Point>();
	
	
	static class Point{
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
	
		for(int r = 0 ; r < 5; r++) {
			String temp = br.readLine();
			for(int c = 0; c < 5; c++) {
				students[r][c] = temp.charAt(c);
				points.add(new Point(r,c));
			}
		}
		// 자리 배치도 입력 완료
		
		
		// 1. 조합 생성
		comb(7, new Point[7], 0);
		
		
		System.out.println(answer);
		
		
		
	}
	
	// 1. 조합 함수
	private static void comb(int toChoose, Point[] choosed, int startIdx) {
		// base part
		if(toChoose == 0) {
			check(choosed);  // 뽑힌 조합 choosed 를 check하기
			return;
		}
		
		// inductive part
		for(int i = startIdx; i < points.size(); i++) {
			choosed[choosed.length - toChoose] = points.get(i);
			comb(toChoose-1, choosed, i+1);
			
		}
	}
	
	// 2. 이다솜 >= 4 확인 함수
	
	private static void check(Point[] choosed) {
		
		int[][] arr = new int[5][5];                 // 뽑힌 좌표를 체크할 배열 arr
		
		int Ycnt = 0;                                // 임도연파 수
		for(int i = 0; i < choosed.length; i++) {
			
			arr[choosed[i].r][choosed[i].c] = 1;     // choosed의 좌표들을 1로 체크
			
			if(students[choosed[i].r][choosed[i].c] == 'Y') {  // 임도연파 수 체크
				Ycnt++;
			}
			
		}
		if(Ycnt >= 4) {      // 임도연파가 4명 이상이면 리턴, 아니면 3. bfs 확인
			return;
		}else {
			bfs(choosed, arr);
		}
	}
	
	// 3. bfs 함수
	
	private static void bfs(Point[] choosed, int[][] arr) {
		
		// 방문 준비
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		
		// 시작 점 방문
		q.offer(choosed[0]);
		visited[choosed[0].r][choosed[0].c] = true;
		int num = 1;  // 방문한 횟수 카운트
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			
			int r = current.r;
			int c = current.c;
			
			for(int d=0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				// 탐색한 좌표가 배열 안에 있고, 방문하지 않았고, arr 가 1인(=choosed 에 있는 좌표) 경우
				if(isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] == 1) {
					visited[nr][nc] = true; // 방문처리 후
					num++;                  // 방문 횟수 증가
					q.offer(new Point(nr,nc));
				}
			}
		}
		
		if(num == 7) { // 방문을 7번 성공하면 정답 수 증가
			answer++;
		}
		
		
	}
	
	// 배열의 범위 내에 있는지 확인하는 함수
	private static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nc >= 0 && nr < 5 && nc <5) {
			return true;
		}else {
			return false;
		}
	}
	
	
	private static String src = "SSSSS\r\n" + 
			"SSSSS\r\n" + 
			"SSSSS\r\n" + 
			"SSSSS\r\n" + 
			"SSSSS";

}
