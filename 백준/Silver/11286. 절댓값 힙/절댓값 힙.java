import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 절댓값으로 우선 순위 계산 (int의 음수 최소값과 최대값이 1차이 난다는 사실을 명심하고 입력 범위 꼭 확인하기)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)) return a - b;
            return Math.abs(a) - Math.abs(b);
        });

        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(n);
            }
        }

        System.out.print(sb);
        br.close();
    }

}