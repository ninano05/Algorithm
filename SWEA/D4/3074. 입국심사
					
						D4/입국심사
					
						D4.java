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
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 입국 심사 시간 받기
			long[] time = new long[N+1];
			long max = 0; // 제일 오래 걸리는 시간
			for(int i=1; i<=N; i++) {
				time[i] = Long.parseLong(br.readLine());
				max = Math.max(max, time[i]);
			}
			
			long left = 1;
			long right = M * max; // 제일 오래 걸리는 심사대에서만 입국 심사
			long answer = right; // 정답 시간 찾기
			
			// 최적의 시간 찾기
			while(left <= right) {
				long mid = left +(right -left)/2;
				
				long count = 0; //mid일 때 가능한 사람 수
				
				for(int i=1; i<=N; i++) {
					count += mid/time[i]; // 현재 시간에서 심사대당 시간으로 나누면 얼마나 사람을 보는지 나옴
					
					if(count >= M) break; //M명 달성하면 더 볼 필요 없음
				}
				
				if(count >= M) {
					answer = mid;
					right = mid-1;
				} else {
					left = mid+1;
				}
			}
			sb.append("#").append(t).append(" ")
			.append(answer).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}