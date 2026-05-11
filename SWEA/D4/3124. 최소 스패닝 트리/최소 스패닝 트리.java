import java.util.*;
import java.io.*;

class Solution
{
    static int[] parent;
	
	public static class Edge{
		int from;
		int to;
		int cost;
		
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점 
			int E = Integer.parseInt(st.nextToken()); // 간선
			
			// 프림 쓸거임
			// 새로운 점을 찾을 때마다 최단 거리를 찾아서
			
			// 그래프 입력 받기 
			// i출발점 j도착점
			ArrayList<Edge> list = new ArrayList<>();
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new Edge(a, b, e));
			}
			
			// 간선 길이 오름차순으로 정렬하기
			Collections.sort(list, (a, b) -> a.cost - b.cost);
			
			// 대표자 초기화
			parent = new int[V+1];
			for(int i=0; i<=V; i++) {
				parent[i] = i;
			}
			
			long res = 0; // 가중치 합
			int count = 0; // 간선 몇개 선택했는지.
			
			//MST 연결하면서 계산하기
			for(int i=0; i<E; i++) {
				Edge cur = list.get(i);
				
				if(union(cur.from, cur.to)) { // 둘의 대표자가  다르다면 연결하기(MST에 연결)
					res += cur.cost;
					
					if(count == V-1) { // 간선 모두 다 선택했으면 종료
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return false;
		
		parent[pb] = pa;
		return true;
	}
	
	public static int find(int a) {
		if(parent[a] == a) return a; // 자기 자신이면 그대로 반환
		
		return parent[a] = find(parent[a]); // 완전 대표자 조상을 찾아서
	}
}