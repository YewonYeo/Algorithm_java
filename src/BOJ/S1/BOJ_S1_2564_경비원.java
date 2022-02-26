package BOJ.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author yeeeh
 * @since 2022. 2. 26.
 * @see https://www.acmicpc.net/problem/2564
 * @category 구현
 */

public class BOJ_S1_2564_경비원 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int Y,X, circum, number;
	private static int answer;
	private static ArrayList<Locate> locations = new ArrayList<>();
	
	static class Locate{
		int dir;
		int locate;
		int index;
		
		public Locate(int dir, int locate) {
			this.dir = dir;
			this.locate = locate;
		}
		
		@Override
		public String toString() {
			return "store [dir=" + dir + ", locate=" + locate + "]";
		}
		
		
		
	}
	public static void main(String[] args) throws IOException {
		// delete
		System.setIn(BOJ_S1_2564_경비원.class.getResourceAsStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		// delete
		
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		circum = 2*(X+Y);
		number = Integer.parseInt(br.readLine());
		answer = 0;
		
		for(int i = 0; i < number+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			locations.add(new Locate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// 입력 완료
		// 직사각형 둘레를 직선으로 생각하기
		
		for(int i = 0; i < locations.size(); i++) {
			Locate temp = locations.get(i);
			if(temp.dir == 1) { // 북쪽인 경우: 좌표 = 위치
				temp.index = temp.locate;
				
			}else if(temp.dir == 2) { // 남쪽인 경우: 좌표 = 가로+세로+(가로-위치)
				temp.index = X+Y+(X-temp.locate);
				
			}else if(temp.dir == 3) { // 서쪽인 경우: 좌표 = 가로+세로+가로+(세로-위치)
				temp.index = 2*X + Y + (Y - temp.locate);
			}else { // 동쪽인 경우: 좌표 = 가로 + 위치
				temp.index = X + temp.locate;
			}
		}
		
		System.out.print(getSum());
		
	}
	
	public static int getSum() {
		answer = 0;
		for(int i = 0; i < locations.size()-1; i++) { // 동근이 전까지 비교. 동근이는 가장 마지막 요소
			Locate s = locations.get(i);
			int distance = Math.abs(s.index - locations.get(locations.size()-1).index);   // 동근이와 상점 위치의 거리
			answer += Math.min(distance, circum - distance); // 위에서 구한 거리와 (전체 둘레-거리) 를 비교.
		}
		
		return answer;
	}

}
