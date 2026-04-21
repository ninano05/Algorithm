import java.util.*;
import java.io.*;

class Solution
{
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N+1];
			
			//dist = new int[N+1];
			for(int i=1; i<N+1; i++) { // 노드랑 맞추기
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			max = 0; // 최장 거리
			// 시작점에 따라 최장 경로 달라질 수 있음
			for(int i=1; i<=N; i++) {
				visited = new boolean[N+1]; // 방문 처리 초기화 필수
				dfs(i, 0);
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void dfs(int start , int cur) { // 시작점, 현재 거리
		visited[start] = true;
		cur++; // 현재 거리 +1;
		// 다 탐방하고 왔으면, 거리 최대 거리인지 확인
		max = Math.max(cur, max);
		
		for(int next : graph[start]) {
			if(visited[next] == false) {
				dfs(next, cur); // 이전까지 거리 같이 넘겨주기
                // 다녀온 다음 방문처리 취소
				visited[next] = false;
			}
		}
	}
}