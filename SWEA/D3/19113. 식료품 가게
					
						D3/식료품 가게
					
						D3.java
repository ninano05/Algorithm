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
			
			long[] mix = new long[2*N]; // 할인 된거 섞인 목록
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<2*N; i++) {
				mix[i] = Long.parseLong(st.nextToken());
			}
			
			// 할인 품목
			ArrayList<Long> list = new ArrayList<>();
			
			// 정상가 확정 목록 표시
			boolean[] use = new boolean[2*N];
			
			//할인가인지 확인
			for(int i=0; i<2*N; i++) {
				if(use[i]) continue; //현재가 정상가면 건너뛰기
				
				long cur = mix[i]*4; // 현재의 정상가
				
				// 현재가 할인가라면 여기에 같은 정상가가 존재
				for(int j=i+1; j<2*N; j++) {
					if(use[j]) continue; // 다른 할인가의 정상가로 쓰였으면 건뛰
					if(mix[j]*3 == cur) {
						use[j] = true;
						break;
					}
				}
				list.add(mix[i]);
			}

			sb.append("#").append(t).append(" ");
			for(long n : list) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}