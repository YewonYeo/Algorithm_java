package Dong.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기출_모험가길드_1회 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] adventurer;
	static int group;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N명의 모험가 공포도 x인 모험가는 x명이상으로 구성. 구성 가능한 그룹의 최대값.
		N = Integer.parseInt(br.readLine());
		adventurer = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			adventurer[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(adventurer);
		
		int current = 0;
		int group = 0;
		
		for(int i = 0; i < N; i++) {
			// 현재 모험가 추가
			current += 1;
			
			// 그룹 조건을 만족한 경우 그룹 수 증가 및 현재 그룹 인원 수 초기화
			if(current >= adventurer[i]) {
				group++;
				current = 0;
			}
			
		}
		
		System.out.println(group);
	}

}
