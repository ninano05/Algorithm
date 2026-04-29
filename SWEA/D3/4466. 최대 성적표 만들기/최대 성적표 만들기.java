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
			int N = Integer.parseInt(st.nextToken()); // 총 과목 개수
			int K = Integer.parseInt(st.nextToken()); // 선택 가능한 과목 수
			
			// 우선 순위 큐 - 점수가 높은 순서로 정렬 
			PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
			
			st = new StringTokenizer(br.readLine());
			// 우선 순위 큐에 점수 입력 받기
			for(int i=0; i<N; i++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			
			int sum = 0; // 점수의 최대 총합 저장
			for(int i=0; i<K; i++) {
				sum += pq.poll();
			}
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}