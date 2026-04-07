import java.util.*;
import java.io.*;

public class Main {
    static Queue<Integer> line;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        line = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            line.offer(Integer.parseInt(st.nextToken()));
        }
        if(getSnack(N)) sb.append("Nice");
        else sb.append("Sad");

        System.out.print(sb);
        br.close();
    }

    public static boolean getSnack(int N) {
        int snack = 1; // 간식 받을 사람 번호
        Stack<Integer> stack = new Stack<>();
        boolean res = true;

        while(true) {
            // 대기열 점검
            if(!stack.isEmpty() && stack.peek() == snack) {
                stack.pop();
                snack++;
                continue;
            }
            // 줄 점검
            if(!line.isEmpty() && line.peek() == snack) {
                line.poll();
                snack++;
                continue;
            } else {
                if(!line.isEmpty() && !stack.isEmpty() && line.peek() > stack.peek()) {
                    res = false;
                    break;
                }
                if(!line.isEmpty()) stack.push(line.poll());
            }
            // 끝 도달
            if(snack > N) break;
        }

        return res;
    }

}