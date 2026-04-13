import java.util.*;
import java.io.*;

public class Main {
    static int[] visited; // 방문 순서 저장
    static ArrayList<Integer>[] graph;
    static int visitOrder; // 노드 방문 순서

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int start = Integer.parseInt(st.nextToken()); // 시작 정점

        // 그래프 초기화
        visited = new int[N+1]; // 노드가 1부터 시작, 0번은 버리기
        graph = new ArrayList[N+1]; // 배열 크기 선언, 노드가 1부터 시작, 0번은 버리기
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>(); // 리스트 객체 생성
        }
        // 그래프 그리기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 무방향 간선이라 양쪽 모두 넣어주기
            graph[a].add(b);
            graph[b].add(a);
        }
        // 그래프 연결 내림차순으로 정렬
        for(int i=1; i<=N; i++) {
            graph[i].sort((a, b) -> b - a);
        }
        visitOrder = 0; // 방문 순서 초기화
        // dfs 탐색
        dfs(start);
        // 방문 순서 출력
        for(int i=1; i<=N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    public static void dfs(int startNode) {
        visitOrder ++; // 방문 순서 더하기
        visited[startNode] = visitOrder; //방문 순서 저장

        for(int nextNode : graph[startNode]) {
            if(visited[nextNode] == 0) { // 방문 안 했다면
                dfs(nextNode); // nextNode 방문해라
            }
        }
    }

}