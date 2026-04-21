import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // 우선 순위 큐에 값 넣어주기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        // N번째 전까지 수 모두 꺼내기
        for(int i=0; i<N-1; i++) {
            pq.poll();
        }
        sb.append(pq.poll()); // N번째 수 꺼내기

        System.out.print(sb);
        br.close();
    }

}