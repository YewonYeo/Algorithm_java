package BOJ.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2212_센서 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, answer;
	static int[] sensor, diff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// del
		br = new BufferedReader(new StringReader(src));
		
		// K개의 집중국은 센서의 사이를 K-1번 뛰어넘을 수 있다.
		// 각 센서의 차이를 구한 뒤 그 중 큰 차이를 뛰어넘는다
		
		N = Integer.parseInt(br.readLine()); // 센서의 개수
		K = Integer.parseInt(br.readLine()); // 집중국의 개수
		sensor = new int[N];
		diff = new int[N-1];
		
		// 집중국이 센서와 같거나 많은 경우 모든 집중국의 거리는 0
		if(K >= N) {
			System.out.println(0);
			System.exit(0);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		
		// 센서를 오름차순 정렬 후 각 센서의 길이 차이를 구한다
		Arrays.sort(sensor);
		for(int i = 1; i < N; i++) {
			diff[i-1] = sensor[i]-sensor[i-1];
		}
		
		// 센서의 차이 중 K-1개를 제외한 후의 길이를 더해준다
		Arrays.sort(diff);
		for(int i = 0; i < diff.length-(K-1); i++) {
			answer += diff[i];
		}
		
		System.out.println(answer);
		

	}
	private static String src = "10\n" + 
			"5\n" + 
			"20 3 14 6 7 8 18 10 12 15";

}
