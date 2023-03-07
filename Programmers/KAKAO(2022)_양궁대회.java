package PROG.kakao2022;

import java.util.*;
import java.io.*;

class Solution {
    static int[] apeach, lion;
    static int max;
    static boolean flag;
    
    public int[] solution(int n, int[] info) {
        
        apeach = info.clone();
        lion = new int[11];
        max = Integer.MIN_VALUE;
        
        shoot(0, n, new int[11], 0, 0);
        
        if(!flag){
            lion = new int[]{-1};
        }
        
        return lion;
        
        // System.out.println(Arrays.toString(this.lion));
        
        // 10점 ~ 0점 까지 탐색하면서 세가지 경우로 진행
        // 1. 어피치가 점수를 얻는 경우, 2. 라이언이 점수를 얻는 경우, 3. 둘다 점수를 얻지 못하는 경우
        // 낮은 점수를 최대한 맞추기 위해 이기는 경우는 어피치+1 로 한다.
        
        
    }
    
    public void shoot(int round, int arrow, int[] choosed, int sum_apeach, int sum_lion){
       if(round == 11){
			 	if(arrow != 0) return;
			 	
	            if(sum_apeach >= sum_lion){
                    flag = false;
	                return;
	            }else{
                    flag = true;
	                int diff = sum_lion - sum_apeach;
	                
	                if(max < diff){
	                    max = diff;
	                    lion = choosed.clone();
	                }else if(max == diff){
	                    for(int i = 10; i >= 0; i--){
	                        int old_cnt = lion[i];
	                        int new_cnt = choosed[i];
	                        
	                        if(new_cnt > old_cnt){
	                            max = diff;
	                            lion = choosed.clone();
	                            break;
	                        }else if(new_cnt == old_cnt){
	                            continue;
	                        }else{
	                            break;
	                        }
	                    }
	                }
	                
	            }
	            return;
	        }
		 
		 	// 둘 다 점수를 얻지 못하는 경우
	        if(apeach[round] == 0){
	            shoot(round+1, arrow, choosed, sum_apeach, sum_lion);
	        }
	        
	        // 어피치가 점수를 얻는 경우
	        if(apeach[round] > 0){
	        	for(int i = 0; i < apeach[round]; i++) {
	        		if(arrow >= i) {
	        			choosed[round] = i;
	        			shoot(round+1, arrow - i, choosed, sum_apeach + (10-round), sum_lion);
	        			choosed[round] = 0;
	        		}
	        	}
	            
	        }
	        
	        // 라이언이 점수를 얻는 경우
	        if(arrow > apeach[round]){
	        	choosed[round] = apeach[round] + 1;
	            shoot(round+1, arrow-apeach[round]-1, choosed, sum_apeach, sum_lion + (10-round));
	            choosed[round] = 0;
	        }
    }
    
}