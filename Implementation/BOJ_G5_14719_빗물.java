package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_G5_14719_빗물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] block;
	static int R, C, sum;
	
	/*
	 * 맨 처음과 맨 끝은 물이 찰 수 없다.
	 * 1) 현재 인덱스의 높이보다 크고, 
	 * 2) 현재 인덱스 기준으로 (왼쪽에서 가장 높은 높이)와 (오른쪽에서 가장 높은 높이) 중 작은 높이를 구하여
	 * 3) 해당 높이가 현재 인덱스보다 큰 경우 (해당 높이 - 현재 높이) 만큼 물이 찬다.
	 * */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		block = new int[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < C-1; i++) {
			int current = block[i];
			int leftMax = current;
			int rightMax = current;
			
			// 왼쪽 최대 블록 찾기
			for(int l = i-1; l>=0; l--) {
				leftMax = Math.max(leftMax, block[l]);
			}
			// 오른쪽 최대 블록 찾기
			for(int r = i+1; r < C; r++) {
				rightMax = Math.max(rightMax, block[r]);
			}
			
			// 물 채우기
			if(Math.min(leftMax, rightMax) > current) {
				sum += Math.min(leftMax, rightMax) - current;
			}
		}
		
		System.out.println(sum);

	}
	private static String src = "3 5\n" + 
			"0 0 0 2 0";

}
