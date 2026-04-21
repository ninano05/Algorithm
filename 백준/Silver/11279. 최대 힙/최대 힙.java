import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 최대 힙의 우선 순위 큐 만들기 (내림차순 - 큰게 먼저)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        // 숫자 넣기 빼기
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) { // 큐에서 큰 값 꺼내기
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else { // 큐에 요소 추가하기
                pq.offer(n); // 큐에 들어가면 힙에 의해 알아서 큰 순서대로 정렬되어 자리 잡는다.
            }
        }
        System.out.print(sb);
        br.close();
    }

}