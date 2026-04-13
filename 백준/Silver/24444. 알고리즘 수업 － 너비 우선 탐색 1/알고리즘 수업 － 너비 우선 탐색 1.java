import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int visitOrder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int start = Integer.parseInt(st.nextToken()); // 시작점
        // 변수 선언
        visited = new int[N+1]; // 인덱스와 노드 맞추기, 0번은 없는 존재
        graph = new ArrayList[N+1]; // 인덱스와 노드 맞추기, 0번은 없는 존재
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>(); // 객체 생성
        }
        // 그래프 그리기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 무방향 간선이라 양쪽으로 넣어주기
            graph[a].add(b);
            graph[b].add(a);
        }
        // 노드 순서 오름차순으로 정렬
        for(int i=1; i<=N; i++) {
            graph[i].sort((a,b)-> a-b);
        }
        visitOrder = 0;
        // bfs 호출 - 노드 방문하기
        bfs(start);
        // 방문 순서 출력
        for(int i=1; i<=N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void bfs(int startNode) { // 시작 노드
        Queue<Integer> que = new ArrayDeque<>(); // 탐방 순서를 위한 큐
        visitOrder++;
        que.offer(startNode); // 탐방할 노드 큐에 넣기
        visited[startNode] = visitOrder;

        while(!que.isEmpty()) {
            int currentNode = que.poll();

            for(int nextNode : graph[currentNode]) {
                if(visited[nextNode] == 0){ // 다음 후보지를 방문 안 했으면?
                    visitOrder++; // 방문 순서 더하기
                    visited[nextNode] = visitOrder; // 방문 순서 저장
                    que.offer(nextNode); // 다음 탐방할 큐에 넣어두기
                }
            }
        }

    }
}