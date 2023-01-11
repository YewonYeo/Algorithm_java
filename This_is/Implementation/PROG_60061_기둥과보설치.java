package Dong.implementation;

import java.util.Arrays;

public class PROG_60061_기둥과보설치 {
	
	static int n = 5;
	static int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
	
	static boolean[][] pillar;
	static boolean[][] bo;
	
	public static void main(String[] args) {
		pillar = new boolean[n+1][n+1];
        bo = new boolean[n+1][n+1];
        
        int count = 0;
    

        for(int i = 0; i < build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int build = build_frame[i][3];
            
            // 기둥인 경우
            if(type == 0){
                // 삭제
                if(build == 0){
                    pillar[x][y] = false;
                    if(!canDelete(n)){
                     pillar[x][y] = true;   
                    }else{
                        count--;
                    } 
                }
                // 설치
                else{
                    if(canPillar(x, y)){
                        pillar[x][y] = true;
                        count++;
                    }
                    
                }
            }
            // 보인 경우
            else{
                // 삭제
                if(build == 0){
                    bo[x][y] = false;
                    if(!canDelete(n)){
                        bo[x][y] = true;
                    }else{
                        count--;
                    }
                }
                // 설치
                else{
                    if(canBo(x, y)){
                        bo[x][y] = true;
                        count++;
                    }
                }
                
            }
        }
        
        int[][] result = new int[count][3];
        int idx = 0;
        for(int x = 0; x <= n; x++){
            for(int y = 0; y <= n; y++){
                if(pillar[x][y]) {
                	result[idx][0] = x;
                	result[idx][1] = y;
                	result[idx++][2] = 0;
                }
                if(bo[x][y]) {
                	result[idx][0] = x;
                	result[idx][1] = y;
                	result[idx++][2] = 1;
                }
            }
        }
    
        for(int[] r: result) {
        	System.out.println(Arrays.toString(r));
        }

	}
	public static boolean canDelete(int n){
	    for(int x = 0; x <= n; x++){
	        for(int y = 0; y <= n; y++){
	            if(pillar[x][y] && !canPillar(x, y)){
	                return false;
	            }else if(bo[x][y] && !canBo(x, y)){
	                return false;
	            }
	        }
	    }
	    return true;
	    }
	        
	    public static boolean canPillar(int x, int y){
	        // 바닥에 설치하는 경우
	        if(y == 0){
	            return true;
	        }
	        // 기둥 위에 설치하는 경우
	        else if(y > 0 && pillar[x][y-1]){
	            return true;
	        }
	        // 보 위에 설치하는 경우
	        else if(x > 0 && (bo[x][y] || bo[x-1][y])){
	            return true;
	        }
	        return false;
	    }

	    public static boolean canBo(int x, int y){
	        // 한쪽 끝에 기둥이 있는 경우
	        if(y > 0 && (pillar[x][y-1] || pillar[x+1][y-1])){
	            return true;
	        }
	        // 양 끝에 보가 있는 경우
	        else if(x > 0 && (bo[x-1][y] && bo[x+1][y])){
	            return true;
	        }
	        return false;
	    }

}
