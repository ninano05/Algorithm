import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st;
        int x = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if(command == 1 || command == 2) x = Integer.parseInt(st.nextToken());

            switch(command) {
                case 1:
                    deque.offerFirst(x); // offerFirst가 앞으로 넣는 것 
                    break;
                case 2:
                    deque.offer(x); // offer, offerLast는 모두 뒤로 넣는 거다.
                    break;
                case 3:
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.poll()).append("\n");
                    break;
                case 4:
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if(deque.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case 7:
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peek()).append("\n");
                    break;
                case 8:
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }
}