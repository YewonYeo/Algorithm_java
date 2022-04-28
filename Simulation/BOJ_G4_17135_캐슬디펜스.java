package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G4_17135_캐슬디펜스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][]map;
	static int R, C, D, totalEnemy;
	static int answer = Integer.MIN_VALUE;
	static List<Point> enemies;
	
	static class Point implements Comparable<Point>{
		int r, c, d;
		boolean isIn;
		boolean canKill;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "P(" + r + "," + c + ","+d+")";
		}
		

		@Override
		public int compareTo(Point o) {
			if(this.d != o.d) {
				return (this.d - o.d);
			}else {
				return (this.c - o.c);
			}
		}
		
		public void distance(Point a) {
			this.d = Math.abs(a.r - this.r) + Math.abs(a.c - this.c);
			isIn = this.d <= D;
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		enemies = new ArrayList<>();
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) {
					totalEnemy++;
					enemies.add(new Point(r,c));
				}
			}
		}
		
		makeComb(3, new Point[3], 0);
		System.out.println(answer);

	}
	
	private static void makeComb(int toChoose, Point[] choosed, int idx) {
		if(toChoose == 0) {
			//System.out.println(Arrays.toString(choosed));
			answer = Integer.max(answer, goGame(choosed));
			return;
		}
		
		for(int i = idx; i <C; i++) {
			choosed[choosed.length - toChoose] = new Point(R, i);
			makeComb(toChoose-1, choosed, i+1);
		}
	}
	
	private static int goGame(Point[] choosed) {
		
		// 적군 복사
		ArrayList<Point> enemy = new ArrayList<>();
		for(Point p: enemies) {
			enemy.add(new Point(p.r, p.c));
		}

		int attackCnt = Integer.MIN_VALUE;
		
		while(enemy.size() > 0) {
		attackCnt = Integer.max(attackCnt, attack(choosed, 0, enemy));
		}
		
		return attackCnt;
	}
	
	private static int attack(Point[] archers, int attackCnt, ArrayList<Point> enemy) {
		
		// 각 궁수 별 적 조준
		for(int i = 0; i < archers.length; i++) {
			Point archer = archers[i]; // 궁수
			Point target = null;       // 궁수의 타겟
			
			// 타겟을 조준하기
			for(int j = 0; j < enemy.size(); j++) {
				
				Point e = enemy.get(i);  // 적군 선택
				e.distance(archer);      // 궁수와 거리 계산하여 거리값 추가
				
				if(e.isIn) { // 사정거리 안에 있다면
					if(target == null || target.compareTo(e) > 0) {
						target = e;
					}
				}
				
			}
			
			if(target != null) {
				target.canKill = true;
			}
			
		}
		
		// 적 공격하기
		for(int i = enemy.size()-1 ; i >= 0; i--) {
			if(enemy.get(i).canKill) {
				enemy.remove(i);
				attackCnt++;
			}
		}
		
		// 적 이동하기
		for(int i = enemy.size()-1; i >= 0; i--) {
			enemy.get(i).r++;
			// 성 밖으로 나가는 경우
			if(enemy.get(i).r == R) {
				enemy.remove(enemy.get(i));
			}
		}
		
		return attackCnt;
	}
	
	
	
	
	private static String src = "6 5 2\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 1 0 1 0\r\n" + 
			"1 1 0 0 0\r\n" + 
			"0 0 0 1 1\r\n" + 
			"1 1 0 1 1\r\n" + 
			"0 0 1 0 0";

}
