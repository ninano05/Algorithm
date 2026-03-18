import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //컴퓨터(노드) 개수
        int c = Integer.parseInt(br.readLine());
        //연결된 간선 개수
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[c+1]; // 리스트 담을 공간만 생성(리스트 객체 생성x)
        // 그래프 배열에 리스트 빈 객체 생성해두기
        for(int i=1; i<c+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        //그래프 연결 
        for(int i=0; i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
            graph[second].add(first);
        }
        bw.write(solution(c)+"");
        bw.flush();
        br.close();
        bw.close();
        
    }
    
    public static int solution(int c) {
        visited = new boolean[c+1];
        int answer = 0; //바이러스에 감염된 node 개수
        // 깊이 우선 탐색 1부터 시작
        dfs(1);
        // 방문한 노드들 확인
        for(int i=1; i<c+1;i++) {
            if(visited[i]) {
                answer++;
            }
        }
        // 자기 자신 제외
        return answer-1;
    }
    
    // 깊이 우선 탐색
    public static void dfs(int node) {
        // 방문한 노드는 표시
        visited[node] = true;
        
        // 현재 노드와 연결된 노드 확인
        for(int nextN : graph[node]) {
            if(!visited[nextN]) { // 연결된 노드가 방문 안했었다면
                dfs(nextN); //방문하기
            } // 방문했다면 skip(아무런 행동하지 않음)
        }
    }
}