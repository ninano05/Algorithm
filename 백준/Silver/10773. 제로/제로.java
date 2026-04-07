import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) stack.pop();
            else stack.add(num);
        }
        long sum = 0;
        for( int n : stack ) {
            sum += n;
        }
        sb.append(sum);
        System.out.print(sb);
        br.close();
    }
}