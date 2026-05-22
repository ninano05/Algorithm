import java.util.*;
import java.io.*;

class Solution
{
    static int[] flavor;
	static int[] kcal;
	static int N;
	static int L;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			// idx에 해당하는 맛과 칼로리
			flavor = new int[N];
			kcal = new int[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				flavor[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			
			// 칼로리에서 가능한 최대 점수
			int[] dp = new int[L+1];
			
			for(int i=0; i<N; i++) { // i번 재료에 대해서 
				for(int j=L; j>=kcal[i]; j--) { // i번 재료를 추가했을 때 가능한 모든 칼로리 j
					dp[j] = Math.max(dp[j], dp[j-kcal[i]]+flavor[i]);
					max = Math.max(max, dp[j]);
				}
			}
			
			sb.append("#").append(t).append(" ")
			.append(max).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}