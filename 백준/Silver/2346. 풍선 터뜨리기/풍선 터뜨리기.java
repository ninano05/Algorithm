import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> que = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 풍선 번호 순서대로 큐에 담아주기
        for(int i=1; i<=N; i++) {
            que.offer(new int[]{i, Integer.parseInt(st.nextToken())}); //i는 풍선 번호, 뒤는 종이번호
        }
        int target = 0; // 이동해야 하는 거리(=패스해야하는 풍선의 개수)
        int dir = 0; // 방향 기록(0:오른쪽, 1: 왼쪽)
        // 풍선 터뜨리기
        while(!que.isEmpty()) {
            while(target != 0) {
                if(target > 0) {
                    que.offer(que.poll()); // 순서 넘어가기 양수 방향
                    target--;
                } else {
                    que.offerFirst(que.pollLast()); // 순서 넘어가기 음수 방향
                    target++;
                }
            }
            int[] balloon;
            if(dir == 0) {
                balloon = que.poll();
            } else {
                balloon = que.pollLast();
            }
            // 다음 이동거리 (=지나가야 할 풍선의 개수)
            if(balloon[1]> 0) { // 양수(오른쪽)
                target = balloon[1]-1;
                dir = 0;
            }
            else { // 음수(왼쪽)
                target = balloon[1]+1;
                dir = 1;
            }
            sb.append(balloon[0]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}