import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals(".")) break;
            boolean res = getMatch(s);
            
            if(res) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb);
        br.close();
    }
    
    public static boolean getMatch(String s) {
        Stack<Character> stack = new Stack<>();
        boolean res = true;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' ||  c == '[') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    res = false;
                    break;
                }
                stack.pop();
            } else if(c ==']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    res = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) res = false;
        return res;
    }
}