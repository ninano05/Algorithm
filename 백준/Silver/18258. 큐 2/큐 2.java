import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int x = 0;
            if(command.equals("push")) x = Integer.parseInt(st.nextToken());

            switch(command) {
                case "push":
                    queue.offer(x);
                    break;
                case "pop":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }

}