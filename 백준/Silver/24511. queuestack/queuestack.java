import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 스택은 입력 순서 그대로 나온다.
        // 큐는 뒤에 있는 큐에서부터 차례 대로 나가고 그 다음 입력 순서 대로 나간다.
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] queNum = new int[N];
        Deque<Integer> deq = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) queNum[i] = 0;
            else queNum[i] = 1;
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(queNum[i] == 0) deq.offerFirst(num); // 뒤에 들어오는 큐의 초기값이 먼저 나가야하기 때문
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            deq.offer(Integer.parseInt(st.nextToken())); // 입력 순서대로 넣기
        }
        // M번 만큼 빼기
        for(int i=0; i<M; i++) {
            sb.append(deq.poll()).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}