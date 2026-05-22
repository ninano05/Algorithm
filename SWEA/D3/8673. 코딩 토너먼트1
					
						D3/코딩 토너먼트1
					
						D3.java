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
			int K = Integer.parseInt(br.readLine());
			
			int P = (int)Math.pow(2, K); // 경기 참가자 수
			
			Queue<Integer> que = new ArrayDeque<>(); // 대진 순서 큐
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<P; i++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}
			
			int nojam = 0; // 지루한 정도
			
			while(que.size() != 1) { // 우승자 한 명 남으면 종료
				// 이번 경기자
				int a = que.poll();
				int b = que.poll();
				
				// 지루도 계산
				nojam += Math.abs(a-b);
				
				// 우승자 다시 큐에 넣기
				int winner = Math.max(a, b); // 우승자
				que.offer(winner);
			}
			
			sb.append("#").append(t).append(" ")
			.append(nojam).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}