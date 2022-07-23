package BOJ.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_25307_시루의백화점구경 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, K;
	static int[][] map;
	
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static Queue<Point> siroo = new LinkedList<Point>();
	static Queue<Point> mannequin = new LinkedList<Point>();
	static boolean[][] visited;
	
	static int chairCnt;
	static Point start;
	
	static class Point{
		int r, c, power;
		
		public Point(int r, int c, int power) {
			this.r = r;
			this.c = c;
			this.power = power;
		}
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		//// del
		br = new BufferedReader(new StringReader(src));
		// 
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 4) {
					start = new Point(r, c, 0);
				}else if(map[r][c] == 2) {
					chairCnt++;
				}else if(map[r][c] == 3) {
					visited[r][c] = true;
					mannequin.add(new Point(r, c));
				}
			}
		}
		
		if(chairCnt == 0) {
			System.out.println(-1);
			System.exit(0);
		}
		
		changeMap();
		
		
		// 시루 이동
		System.out.println(moveSiroo());
		
	}
	public static int moveSiroo() {
		siroo.add(start);
		map[start.r][start.c] = -1;
		
		while(!siroo.isEmpty()) {
			Point current = siroo.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + deltas[d][0];
				int nc = current.c + deltas[d][1];
				
				if(isIn(nr, nc) && map[nr][nc] != 1 && map[nr][nc] != -1 && map[nr][nc] != 3) {
					if(map[nr][nc] == 2) {
						return current.power + 1;
					}else {
						map[nr][nc] = -1;
						siroo.add(new Point(nr, nc, current.power + 1));
					}
				}
			}
		}
		return -1;
		
	}
	
	public static void changeMap() {
		
		///// 다시보기
		for(int j = 0; j < K; j++){

            int size = mannequin.size();

            for(int i = 0; i < size; i++){
                Point current = mannequin.poll();
         
                for(int d = 0; d < 4; d++) {
                    int nr = current.r + deltas[d][0];
                    int nc = current.c + deltas[d][1];
                    
                    if(!isIn(nr, nc) || visited[nr][nc]) {
                        continue;
                    }
                    
                    map[nr][nc] = 1;
                    visited[nr][nc] = true;
                    
                    mannequin.add(new Point(nr, nc));

                }
            }
        }
		map[start.r][start.c] = 4;
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	private static String src = "5 5 0\n" + 
			"4 0 0 0 0\n" + 
			"3 3 3 3 0\n" + 
			"0 0 0 0 0\n" + 
			"0 3 1 1 3\n" + 
			"0 0 0 0 2";
	
}
