import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 손님 수
			int M = Integer.parseInt(st.nextToken()); // 만드는 시간
			int K = Integer.parseInt(st.nextToken()); // 만드는 개수
			
			int[] time = new int[N]; // 각 손님의 도착 시간
			st = new StringTokenizer(br.readLine());
			// 손님의 도착 시간 입력 받기
			for(int i=0; i<N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			// 손님 도착 시간으로 오름차순 정렬
			Arrays.sort(time);
			
			boolean canBuy = true; // 지체 없이 살 수 있는가
			int curTime = 0;
			int curFish = 0;
			
			// 처음 들어오는 손님은 M초 이후여야 함
			if(time[0] < M) canBuy = false;
			else { // M초마다 손님 명수 K명 이하여야 함
				for(int i=0; i<N; i++) {
					curFish = (time[i]/M)*K;
					// 시간 업데이트
//					if(curTime != time[i]) {
//						// 븡어빵 개수 업데이트
//						curFish = (time[i]/M)*K;
//						curTime = time[i];
//					}
					// 붕어빵 전달 (
					curFish -= (i+1);
					// 븡어빵 개수 점검
					if(curFish < 0) {
						canBuy = false;
						break;
					}
				}
			}
			
			sb.append("#").append(t).append(" ");
			if(canBuy) sb.append("Possible").append("\n");
			else sb.append("Impossible").append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}