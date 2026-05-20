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
			
			int N = Integer.parseInt(st.nextToken()); // 입국 심사대 개수
			long M = Long.parseLong(st.nextToken()); // 사람 수
			
			long[] time = new long[N]; // 심사대마다 심사에 걸리는 시간
			long max = 0;
			for(int i=0; i<N; i++) {
				time[i] = Long.parseLong(br.readLine());
				max = Math.max(max, time[i]);// 큰 값 업데이트
			}
			
			// 목표하는 시간 찾기 (이분 탐색)
			long left = 1;
			long right = max*M; // 최대로 걸리는 시간은 오래걸리는 한 심사대로 M명 다하기
			long answer = right; // 정답 시간 찾아나가기
			
			while(left<=right) {
				long mid = left + (right-left)/2; // 오버 플로우 방지를 위함
				
				long count = 0;// 현재 mid 시간일 때 가능한 사람 수
 				
				for(int i=0; i<N; i++) {
					count += mid/time[i];
					
					if(count >= M) break; // M명 달성하면 종료
				}
				
				if(count >= M) {
					answer = mid; // 정답 후보가 됐기에
					right = mid -1; //mid는 이미 탐색했으니 하나 줄여서
				} else {
					left = mid +1;
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}