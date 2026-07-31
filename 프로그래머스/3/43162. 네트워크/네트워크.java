import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited; // 노드 방문 관리
    static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] computers) {
        
        //변수 초기화
        visited = new boolean[n];
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 그리기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 네트워크 연결
                if(computers[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }
        
        // 네트워크 덩어리 탐색하기
        int network = 0;
        for(int i=0; i<n; i++) {
            // 방문 안 했다면
            if(!visited[i]) {
                bfs(i);
                network ++;
            }
        }
        return network;
    }
    
    public static void bfs(int startNode) {
        Queue<Integer> que = new ArrayDeque<>();
        visited[startNode] = true;
        que.offer(startNode);
        
        // 연결된 다음 노드로 이동
        while(!que.isEmpty()) {
            int cur = que.poll();
            
            for(int next : graph[cur]) {
                if(!visited[next]) {
                    que.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}