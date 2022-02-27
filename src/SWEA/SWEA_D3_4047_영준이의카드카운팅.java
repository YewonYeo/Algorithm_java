package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_D3_4047_영준이의카드카운팅 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	
	private static int T;
	private static Set<Integer> spade = new HashSet<>();
	private static Set<Integer> diamond = new HashSet<>();
	private static Set<Integer> heart = new HashSet<>();
	private static Set<Integer> clover = new HashSet<>();
	private static Set[] cards = {spade, diamond, heart, clover};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// delete
		System.setIn(SWEA_D3_4047_영준이의카드카운팅.class.getResourceAsStream("card.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		// delete
		
		T = Integer.parseInt(br.readLine());
		
	outer: for(int t = 1; t<= T; t++) {
			answer.append("#").append(t).append(" ");
			
			spade.clear();
			diamond.clear();
			heart.clear();
			clover.clear();
			
			String cardInfo = br.readLine();  // 입력받는 카드 정보 S
			int cnt = cardInfo.length() / 3;  // 카드의 개수 S / 3
			int index = 0;
			
			 for(int i = 0; i < cnt; i++) {
				String temp = cardInfo.substring(index, index+3);
				char shape = temp.charAt(0);
				int number = ((temp.charAt(1)- '0')*10 + (temp.charAt(2)) - '0') ;
			
				switch (shape) {
				case 'S':
					if(spade.contains(number)) {
						answer.append("ERROR").append("\n");
						continue outer;
					}else {
						spade.add(number);
						break;
					}
					
				case 'D':
					if(diamond.contains(number)) {
						answer.append("ERROR").append("\n");
						continue outer;
					}else {
						diamond.add(number);
						break;
					}
					
				case 'H':
					if(heart.contains(number)) {
						answer.append("ERROR").append("\n");
						continue outer;
					}else {
						heart.add(number);
						break;
					}
				case 'C':
					if(clover.contains(number)) {
						answer.append("ERROR").append("\n");
						continue outer;
					}else {
						clover.add(number);
						break;
					}
				}
				
				index += 3;
				
				
				
			}
			
			
			for(int i = 0; i < 4; i++) {
				if(cards[i].size() == 13) {
					answer.append(0).append(" ");
				}else {
					answer.append(13-cards[i].size()).append(" ");
				}
			}
			answer.append("\n");
			
		}
		
		System.out.println(answer);
		

	}

}
