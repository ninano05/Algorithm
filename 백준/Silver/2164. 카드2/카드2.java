import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        // 카드 순서대로 쌓기
        for(int i=1; i<=N; i++) {
            queue.offer(i);
        }
        
        while(queue.size() > 1) {
            queue.poll(); // 맨 위 카드 버림
            queue.offer(queue.poll()); // 꺼낸 카드 다시 맨 뒤로 넣어주기
        }
        sb.append(queue.peek());
        System.out.print(sb);
        br.close();
    }
}