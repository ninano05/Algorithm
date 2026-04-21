import java.util.*;
import java.io.*;

class Solution
{
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int cur; 
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
			max = 0;
			
			for(int i=1; i<=N; i++) {
				visited = new boolean[N+1];
				cur = 0;
				dfs(i);
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		cur++;
		max = Math.max(cur, max); // 계속 최장거리 업데이트
		
		for(int next : graph[start]) {
			if(visited[next] == false) {
				dfs(next);
				// 다시 거리 빼주기
				cur --;
				visited[next] = false;
			}
		}
	}
}