import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1 2 3 4 5 6 7 -> 3제거
        // 4 5 6 7 1 2 -> 6제거
        // 7 1 2 4 5 -> 2제거
        // 제거하기 전 지나간 숫자들은 다시 뒤로 넣어준다.
        // 그 다음 회차는 제거한 다음 숫자부터 번호를 센다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 원에 앉히기
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            queue.offer(i);
        }
        sb.append("<");
        // 한명씩 제거 - 요세푸스 순열 만들기
        while(queue.size() > 1) {
            for(int i=0; i<K-1; i++){ // k전 까지 순서 건너뛰기
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">"); // 마지막 남은 수는 ', '를 안 넣기 위해서 따로 출력
        System.out.print(sb);
        br.close();
    }
}