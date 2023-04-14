package BOJ.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_S4_2164_카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Queue<Integer> cards = new LinkedList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			cards.add(i);
		}
		
		while(cards.size() > 1) {
			// 맨 윗장 카드 버리기
			cards.poll();
			
			// 그 다음 위 카드 아래로 옮기기
			int top = cards.poll();
			cards.add(top);
		}
		
		System.out.print(cards.peek());
	}

}
