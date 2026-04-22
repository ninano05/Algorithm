import java.util.*;
import java.io.*;

public class Main {
    static int[] line;
    static int[] time;
    static int K;
    static int MAX = 100001;

    public static class Node {
        int n;
        int cost;

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
        int N = Integer.parseInt(st.nextToken()); // 수빈이
        K = Integer.parseInt(st.nextToken()); // 동생

        // 변수 초기화
        line = new int[MAX];
        time = new int[MAX];
        for(int i=0; i<MAX; i++) {
            time[i] = Integer.MAX_VALUE;
        }

        // 최단 시간으로 찾기
        dijkstra(N);

        sb.append(time[K]);

        System.out.print(sb);
        br.close();
    }

    public static void dijkstra(int start) {
        // k까지 시간이 짧은거 먼저 탐색하기
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.offer(new Node(start, 0));
        time[start] = 0;
        int nTime;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            // 현재가 더 최소 시간이면 건너뛰기
            if(time[cur.n] < cur.cost) continue;
            // time이 최소인 k일 때 다음으로 이동하기에 여기서 break
            if(cur.n == K) break;
            // 다음 좌표 후보지
            int[] next = {cur.n-1, cur.n+1, cur.n*2};

            for(int i=0; i<3; i++) {
                if(next[i]>=0 && next[i]<MAX) { // 수직선 범위 안
                    if(i == 2) nTime = time[cur.n]; // 순간이동
                    else nTime = time[cur.n] +1; // 걸어서

                    // 해당 지점이 이전에 도달한 시간보다 짧을 때만 실행
                    if (time[next[i]] > nTime) { // 시간이 단축
                        pq.offer(new Node(next[i], nTime));
                        time[next[i]] = nTime;
                    }
                }
            }
        }
    }
}