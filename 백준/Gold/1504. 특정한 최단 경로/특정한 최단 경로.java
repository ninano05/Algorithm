import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] graph;
    static int[] dist;
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

        int min = Integer.MAX_VALUE;
        // 다익스트라 하기
        // 둘 중에 어떤 경우가 짧은지 알아야 한다.
        // 어떤 경로에서든 -1이 나오면 못 가는 길인 거다.
        // 1) (1 - v1) - (v2 - N)
        int d1 = dijkstra(1, v1);
        int d2 = dijkstra(v2, N);
        if(d1 != -1 && d2 != -1) {
            min = d1 + d2;
        }
        // 2) (1 - v2) - (v1 - N)
        d1 = dijkstra(1, v2);
        d2 = dijkstra(v1, N);
        if(d1 != -1 && d2 != -1) {
            min = Math.min(d1+d2, min);
        }

        // 공통인 v1-v2 더하기
        int d3 = dijkstra(v1, v2);
        if(min != Integer.MAX_VALUE && d3 != -1) {
            min += d3;
            sb.append(min);
        } else {
            sb.append("-1");
        }

        System.out.print(sb);
        br.close();
    }

    public static int dijkstra(int start, int end) {
        // 다익스트라 호출 할때마다 거리가 바뀌기 때문에 초기화를 여기서 해야 함
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            // 처음 확정되는게 가장 최단거리이기 때문
            if(cur.n == end) return dist[end];

            if(dist[cur.n] < cur.cost) continue; // 오래된 정보는 건뛰

            for(Node next : graph[cur.n]) {
                if(dist[next.n] > dist[cur.n] + next.cost) { // 새로운 길이 더 짧으면
                    dist[next.n] = dist[cur.n] + next.cost;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
        return -1; // 만약 길을 못 찾으면
    }
}