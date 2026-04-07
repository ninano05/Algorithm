import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            String s = br.readLine();
            boolean res = isVPS(s);
            if(res) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
        br.close();
    }
    public static boolean isVPS(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}