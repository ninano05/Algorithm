import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] graph; // list에 {연결노드, 가중치} 이렇게 적을 예정
    static int[] dist; // 각 정점까지의 최단거리

    public static class Node {
        int n; // 노드
        int cost; // 가중치

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        int start = Integer.parseInt(br.readLine()); // 시작 위치

        // 변수 생성 및 초기화
        graph = new ArrayList[V+1]; // 0번 무시
        dist = new int[V+1]; // 0번 무시
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 연결하기
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); // 가중치
            graph[u].add(new Node(v, w));
        }

        // 다익스트라로 최단거리
        dijkstra(start);

        for(int i=1; i<=V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    public static void dijkstra(int start) {
        // cost는 시작부터 현재 노드까지 온 거리, 가중치 합을 의미한다.
        // 이게 짧은 순서로 처리해야 시작점부터 노드까지의 거리가 가장 짧게 확정된다.
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.offer(new Node(start, 0));
        dist[start] = 0; // 오는데 거리 0

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(Node next : graph[cur.n]) {
                // 현재 갈 수 있는 것 중 짧은 것부터 처리
                // 짧은 것부터 확정 지으면 이후에 방문하는 경로도 최소로 확정

                // 이번에 방문하는게 이전에 방문하는 것보다 작으면 업데이트 하라는 뜻이다.
                // 초기값으로 Integer.max_value를 넣어놨기 때문에 가장 짧은 거리를 확정하게 됨
                if(dist[next.n] > dist[cur.n] + next.cost) {
                    dist[next.n] = dist[cur.n] + next.cost; // 거리 저장
                    pq.offer(new Node(next.n, dist[next.n])); // 다음 노드 보기 위해 큐에 넣기
                }
            }
        }
    }
}