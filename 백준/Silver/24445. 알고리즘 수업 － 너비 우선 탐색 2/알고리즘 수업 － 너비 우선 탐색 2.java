import java.util.*;
import java.io.*;

public class Main {
    static int[] visited;
    static ArrayList<Integer>[] graph;
    static int visitOrder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        // 변수 초기화
        visited = new int[N+1]; // 0번 인덱스 무시, 노드 인덱스 동기화
        graph = new ArrayList[N+1]; // 0번 인덱스 무시, 노드 인덱스 동기화
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>(); // 객체 생성
        }
        // 그래프 그리기(무방향)
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 무방향 그래프 -> 양쪽 다 연결
            graph[a].add(b);
            graph[b].add(a);
        }
        // 노드 순서 정렬 (내림차순)
        for(int i=1; i<=N; i++) {
            graph[i].sort((a,b) -> b-a);
        }
        visitOrder = 0;
        // bfs 탐색 시작
        bfs(start);
        // 탐방 순서 출력
        for(int i=1; i<=N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void bfs(int startNode) {
        // 초기 설정
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visitOrder++;
        visited[startNode] = visitOrder;

        while(!queue.isEmpty()) {
            int cur = queue.poll(); // 현재 노드 빼기

            for(int nextNode: graph[cur]) { // 다음 노드 후보지 탐색
                if(visited[nextNode] == 0) { // 방문 안 했다면
                    queue.offer(nextNode);
                    visitOrder++;
                    visited[nextNode] = visitOrder;
                }
            }
        }
    }
}