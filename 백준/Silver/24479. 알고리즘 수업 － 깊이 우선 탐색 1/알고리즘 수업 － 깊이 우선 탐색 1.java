import java.util.*;
import java.io.*;

public class Main {
    static int[] visited; //노드 별 방문 순서 저장
    static ArrayList<Integer>[] graph;
    static StringBuilder sb;
    static int visitOrder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int start = Integer.parseInt(st.nextToken()); // 시작 노드

        visited = new int[N+1];
        graph = new ArrayList[N+1]; // 리스트 배열 크기 선언
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>(); // 배열에 list 객체 생성
        }

        // 그래프 그리기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향으로 모두에게 넣어주어야 함
            graph[a].add(b);
            graph[b].add(a);
        }
        // 오름차순으로 정렬하기
        for(int i=1; i<=N; i++) {
            Collections.sort(graph[i]); // 각 그래프의 리스트 정렬
        }
        visitOrder = 0; // 방문 순서 초기값
        // dfs 탐색 시작
        dfs(start);

        // 방문 순서 별 출력
        for(int i=1; i<=N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void dfs(int startNode) {// 시작 노드 전달 받기
        visitOrder ++; // 방문 순서 증가
        visited[startNode] = visitOrder; // 방문 처리

        for(int nextNode : graph[startNode]) { // 연결된 노드 하나씩 꺼내서 다음 후보지 방문 결정
            if(visited[nextNode] == 0) { // 다음 노드를 방문 안 한 상태면?
                dfs(nextNode); // 깊게 더 들어가기
            }
        }
    }
}