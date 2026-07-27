import java.util.*;

class Solution {
    static int[][] dist;
    static boolean[][] visited;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static class Node {
        int r;
        int c;
        
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        // 가로 세로 설정(목표 구역임)
        int tr = maps.length;
        int tc = maps[0].length;
        
        // 변수 초기화 (0,0) 쓸거임
        dist = new int[tr][tc];
        visited = new boolean[tr][tc];
        
        dist[tr-1][tc-1] = -1; // 방문 못했을 경우 기본값
        
        // 짧은 거리 탐색 시작
        bfs(maps, tr, tc);
        
        answer = dist[tr-1][tc-1];
        
        return answer;
    }
    
    public static void bfs(int[][] maps, int tr, int tc) {
        Queue<Node> que = new ArrayDeque<>();
        // 시작점 넣어주기
        que.offer(new Node(0,0));
        visited[0][0] = true;
        dist[0][0] = 1; // 자기 자신 위치 설정
        
        // 큐가 빌 때까지 동작
        while(!que.isEmpty()) {
            Node cur = que.poll(); // 현재 꺼 빼기
            
            // 4방향 탐색 시작
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                // 범위 안에 있다면 
                if(nr>=0 && nr<tr && nc>=0 && nc<tc) {
                    if(!visited[nr][nc] && maps[nr][nc] == 1) { // 방문 안했으면, 1이어야 함 
                        visited[nr][nc] = true;
                        que.offer(new Node(nr, nc)); // 큐에 넣기
                        dist[nr][nc] = dist[cur.r][cur.c] +1; // 부모에서 1더하기
                    }
                }
            }
        }
        
    }
}