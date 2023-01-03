package Dong.greedy;

import java.util.*;
import java.io.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42891

public class PROG_무지의먹방라이브 {
	static int[] food_times = {3, 1, 2};
	static long k;
	
	static class Food{
        int index, amount;
        
        public Food(int index, int amount){
            this.index = index;
            this.amount = amount;
        }
    }

	public static void main(String[] args) {
		ArrayList<Food> food_info = new ArrayList<Food>();
        long sum = 0;
        for(int i = 0; i < food_times.length; i++){
            food_info.add(new Food(i+1, food_times[i]));
            sum += food_times[i];
        }
        
        if(k >= sum){
            System.out.print(-1);
            System.exit(0);
        }
        
        Collections.sort(food_info, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2){
                return o1.amount - o2.amount;
            }
        });
        
        long sum_time = 0;
        long prev_time = 0;
        
        // 제일 작은 음식들을 다 먹는데 걸린 총 시간 + 현재 제일 작은 음식을 다먹는데 걸린 시간 <= K
        while(sum_time + ((long) food_info.size() * ((long) food_info.get(0).amount - prev_time)) <= k){
            sum_time += ((long) food_info.get(0).amount - prev_time) * food_info.size();
            prev_time = (long) food_info.get(0).amount;
            food_info.remove(0);
            
        }
        
        
        
        Collections.sort(food_info, new Comparator<Food>(){
            @Override
            public int compare(Food o1, Food o2){
                return o1.index - o2.index;
            }
        });
        
        
            
        long answer = (k - sum_time) % (long) food_info.size();
        
        System.out.print(food_info.get((int) answer).index); 

	}

}
