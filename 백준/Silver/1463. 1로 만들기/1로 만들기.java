import java.util.*;
import java.io.*;

public class Main {
    static int[] time; // 각 수직선에 가장 최소로 도달한 순간

    public static class Node{
        int n, cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        time = new int[N+1]; // 인덱스 맞추기
        Arrays.fill(time, Integer.MAX_VALUE);

        dijkstra(N);

        sb.append(time[1]);
        System.out.print(sb);
        br.close();
    }

    public static void dijkstra(int n) {
        // 시간(cost)이 최소가 되도록 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.cost-b.cost);
        pq.offer(new Node(n, 0)); // 시작점 설정
        time[n] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이전에 기록한 시간이 더 짧으면 패스
            if(time[cur.n] < cur.cost) continue;

            // 1을 꺼내면 -> 최소 시간 보장
            if(cur.n == 1) return;

            // 첫번째 경우
            int next = cur.n/3;
            if(cur.n%3 == 0 && time[next] > cur.cost+1) {
                time[next] = cur.cost+1;
                pq.offer(new Node(next, time[next]));
            }
            // 두번째 경우
            next = cur.n/2;
            if(cur.n%2 == 0 && time[next] > cur.cost+1) {
                time[next] = cur.cost+1;
                pq.offer(new Node(next, time[next]));
            }
            // 세번째 경우
            next = cur.n-1;
            if(time[next] > cur.cost+1) {
                time[next] = cur.cost+1;
                pq.offer(new Node(next, time[next]));
            }
        }
    }
}