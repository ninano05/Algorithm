import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int snack = 1; // 현재 간식 받을 사람
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            
            if(cur == snack) {
                snack++;
            } else {
                stack.push(cur);
            }
            
            while(!stack.isEmpty() && stack.peek() == snack) { // 대기열 학생인 순서인 경우 모두 빼기
                stack.pop();
                snack++;
            }
        }
        if(stack.isEmpty()) sb.append("Nice");
        else sb.append("Sad");

        System.out.print(sb);
        br.close();
    }

}