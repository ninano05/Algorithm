import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // N번째 수를 가져와야 하기 때문에, 최대 N개까지만 유지하면 된다.
        // N번째로 큰 수니까, N개로 요소를 유지하면 처음 꺼내는 수가 최소로 N번째 수이다
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(pq.size() == N) { // pq 요소가 N개 도달하면
                    if(n > pq.peek()) { // 최소값보다 n이 더 크면
                        pq.poll(); // 최소값 빼고
                        pq.offer(n); // n을 넣는다
                    }
                } else {
                    pq.offer(n);
                }
            }
        }
        sb.append(pq.poll());
        System.out.print(sb);
        br.close();
    }

}