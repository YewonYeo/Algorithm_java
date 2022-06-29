package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_20055_컨베이어벨트위의로봇 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, stage;
	static Item[] belt;
	
	static class Item {
		int d;
		boolean robot;
		
		Item(int d, boolean robot){
			this.d = d;
			this.robot = robot;
		}

		@Override
		public String toString() {
			return "Item [" +d + "," + robot + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new Item[2*N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 2*N; i++) {
			belt[i] = new Item(Integer.parseInt(st.nextToken()), false);
		}
		
		while(true) {
			stage++;
				
			// 1. 벨트 회전
			rotateBelt();
			belt[N].robot = false; // 로봇 내려주기
			
			// 2. 로봇 이동
			moveRobot();
			belt[N].robot = false; // 로봇 내려주기
			
			// 3. 로봇 올리기
			if(belt[1].d > 0) {
				belt[1].robot = true;
				belt[1].d--;
			}
			
			// System.out.println("====== 로봇 올리기 ======");
			// System.out.println(Arrays.toString(belt));
			
			// 4. 내구도 체크
			if(!isOkay()) {
				System.out.println(stage);
				break;
			};
		}
	}
	
	static void rotateBelt() {
		Item temp = belt[2*N];
		for(int i = 2*N; i > 1; i--) {
			belt[i] = belt[i-1];
		}
		belt[1] = temp;
		// System.out.println("====== 벨트 회전 ======");
		// System.out.println(Arrays.toString(belt));
	}
	
	static void moveRobot() {
		// N번 부터 이동
		for(int i = N; i > 1; i--) {
			if(!belt[i].robot && belt[i-1].robot && belt[i].d > 0) {
				belt[i].robot = true;
				belt[i-1].robot = false;
				belt[i].d--;
			}
		}
		// System.out.println("====== 로봇 이동 ======");
		// System.out.println(Arrays.toString(belt));
	}
	
	static boolean isOkay() {
		int cnt = 0;
		
		for(int i = 1; i <= 2*N; i++) {
			if(belt[i].d == 0) {
				cnt++;
			}
			if(cnt >= K) {
				return false;
			}
		}
		return true;
	}

}
