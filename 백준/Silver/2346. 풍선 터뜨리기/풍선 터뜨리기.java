import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> deq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 풍선 번호 순서대로 큐에 담아주기
        for(int i=1; i<=N; i++) {
            deq.offer(new int[]{i, Integer.parseInt(st.nextToken())}); //i는 풍선 번호, 뒤는 종이번호
        }

        // 풍선 터뜨리기
        while(!deq.isEmpty()) {
            int[] cur = deq.pollFirst();
            int index = cur[0]; // 풍선 번호
            int move = cur[1]; // 이동해야 하는 거리

            sb.append(index).append(" ");

            if(deq.isEmpty()) break;
            if(move > 0) {
                for(int i=0; i<move-1; i++) {
                    deq.offerLast(deq.pollFirst());
                }
            } else {
                for(int i=0; i<-move; i++) { // 음수인 경우는 내가 뽑아야하는 것까지 맨 앞으로 땡겨온다.
                    deq.offerFirst(deq.pollLast());
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}