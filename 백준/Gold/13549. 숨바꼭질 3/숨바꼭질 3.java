import java.util.*;
import java.io.*;

public class Main {
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

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            // 현재가 더 최소 시간이면 건너뛰기
            if(time[cur.n] < cur.cost) continue;

            // time이 최소인 k일 때 다음으로 이동하기에 여기서 break
            if(cur.n == K) break;

            // 순간이동 *2
            if(cur.n*2 >= 0 && cur.n*2 < MAX && time[cur.n*2] > time[cur.n]) {
                time[cur.n*2] = cur.cost; // 현행 유지
                pq.offer(new Node(cur.n*2, cur.cost));
            }
            // +1 이동
            if(cur.n+1 >=0 && cur.n+1 <MAX && time[cur.n+1] > time[cur.n]+1) {
                time[cur.n+1] = cur.cost +1;
                pq.offer(new Node(cur.n+1, cur.cost +1));
            }
            // -1 이동
            if(cur.n-1 >=0 && cur.n-1 <MAX && time[cur.n-1] > time[cur.n]+1) {
                time[cur.n-1] = cur.cost +1;
                pq.offer(new Node(cur.n-1, cur.cost +1));
            }
        }
    }
}