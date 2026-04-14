import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;
    static ArrayList<Integer>[] graph;
    static StringBuilder visitOrder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int start = Integer.parseInt(st.nextToken()); // 시작 좌표

        // 변수 생성 및 초기화
        visitedDfs = new boolean[N+1];
        visitedBfs = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 그리기 (간선 연결)
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 그래프 양방향
            graph[a].add(b);
            graph[b].add(a);
        }
        // 정점 번호가 작은 것부터 방문 -> 연결 노드 순서를 오름차순으로 정렬해두기
        for(int i=1; i<=N; i++) {
            graph[i].sort((a,b) -> a - b);
        }

        // 방문 순서 기록할 sb
        visitOrder = new StringBuilder();
        // dfs , bfs 각각 돌리기
        dfs(start);
        visitOrder.append("\n");
        bfs(start);

        System.out.print(visitOrder);
        br.close();
    }

    public static void dfs(int start) {
        visitedDfs[start] = true; // 방문 처리
        visitOrder.append(start).append(" "); // 방문 순서 기록하기

        for(int next: graph[start]) {
            if(!visitedDfs[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start); // 큐에 넣기
        visitedBfs[start] = true; // 방문 처리
        visitOrder.append(start).append(" "); // 방문 순서 기록

        while(!queue.isEmpty()) {
            int cur = queue.poll(); // 현재 이어서 탐색할 노드 빼기

            for(int next: graph[cur]) {
                if(!visitedBfs[next]) { // 방문 안 했으면
                    queue.offer(next); // 큐에 넣기
                    visitedBfs[next] = true; // 방문 처리
                    visitOrder.append(next).append(" "); // 방문 순서 기록
                }
            }
        }
    }
}