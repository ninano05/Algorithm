import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 과자 봉지 개수
			int M = Integer.parseInt(st.nextToken()); // 무게합 제한
			
			int[] snack = new int[N];
			// 과자 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1; // 최대 과자 무게
			// 2개를 선택해야 함
			for(int i=0; i<N; i++) { // 첫번 째 과자 고르기
				for(int j=i+1; j<N; j++) { // 두 번째 과자 고르기 (순서 상관 없어서, i가 골랐던 거 안고르기)
					int cur = snack[i] + snack[j];
					if(cur <= M) { // 무게 초과 안 하면
						max = Math.max(cur, max); // 큰 값으로 업데이트
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}