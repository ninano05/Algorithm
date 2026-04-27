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
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			int[] num = new int[N+1];
			
			// 수열 배열 담아두기
			for(int i=1; i<=N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			// dp 정의
			// dp[i] = i번째 숫자를 마지막으로 하는 최장 증가 부분 수열 길이
			int[] dp = new int[N+1]; // 이전까지 담긴 길이 개수
		
			
			for(int i=1; i<=N; i++) {
				dp[i] = 1; // 자기 자신만 꺼내도 길이는 1
				
				for(int j=1; j<i; j++) { // 자신 이전 수들에 대해
					if(num[j] < num[i]) { // 이전이 현재 자기 숫자보다 작은 경우
						dp[i] = Math.max(dp[i], dp[j] +1); // 자신만 꺼낸 경우와 이전 수들에서 길이 +1된거 비교해서 채택
					}
				}
			}
			
			int max = 0;
			// 최장 길이 꺼내기
			for(int i=1; i<=N; i++) {
				max = Math.max(max,  dp[i]);
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}