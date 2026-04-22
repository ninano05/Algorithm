import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] graph;
    static int N;

    public static class Node {
        int n; // 노드 번호
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
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        // 변수 초기화
        graph = new ArrayList[N+1]; // 0번 인덱스 무시
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 연결하기
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 양방향 그래프
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        // 방문해야 하는 점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 다익스트라 하기
        // 1) 1 - v1 - v2 - N
        // 2) 1 - v2 - v1 - N
        // 동일한 시작점에 대해서는 모든 도착지의 최단거리를 구할 수 있다 이걸 이용한다.
        // 다익스트라를 돌고 모든 도착지에 대한 최단거리 배열을 반환한다.
        // 출발지가 1인 경우 (필요한 도착지 v1, v2)
        // 출발지가 v1인 경우 (필요한 도착지 v2, N)
        // 출발지가 v2인 경우 (필요한 도착지 v1, N)

        int[] dist1 = dijkstra(1); // 여기서 v1, v2만 쓸 예정
        int[] distv1 = dijkstra(v1); // 여기서 v2, N만 쓸 예정
        int[] distv2 = dijkstra(v2); // 여기서 v1, N만 쓸 예정

        // 총 최단 거리 저장할 공간
        int min = Integer.MAX_VALUE;
        int MAX = Integer.MAX_VALUE;

        // 1) 1 - v1 - v2 - N
        if(dist1[v1] != MAX && distv1[v2] != MAX && distv2[N] != MAX) {
            min = dist1[v1] + distv1[v2] + distv2[N];
        }
        // 2) 1 - v2 - v1 - N
        if(dist1[v2] != MAX && distv2[v1] != MAX && distv1[N] != MAX) {
            min = Math.min(min, dist1[v2] + distv2[v1] + distv1[N]);
        }

        // 결과 출력
        if(min == MAX) {
            sb.append("-1");
        } else {
            sb.append(min);
        }
        System.out.print(sb);
        br.close();
    }

    public static int[] dijkstra(int start) {
        // 이번 시작점에 대한 다익스트라 최단거리 배열
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 우선 순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.n] < cur.cost) continue; // 오래된 정보는 건뛰

            for(Node next : graph[cur.n]) {
                if(dist[next.n] > dist[cur.n] + next.cost) { // 새로운 길이 더 짧으면
                    dist[next.n] = dist[cur.n] + next.cost;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
        return dist;
    }
}