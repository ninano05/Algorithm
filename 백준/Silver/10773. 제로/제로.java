import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] s = new int[n];
        
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            s[i] = num;
        }
        
        bw.write(solution(n, s)+"");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int solution(int n, int[] s) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int i=0;i<n;i++) {
            if(s[i] == 0) {
                stack.pop();
            } else {
                stack.push(s[i]);
            }
        }
        
        for(int k : stack) {
            answer += k;
        }
        
        return answer;
    }
}