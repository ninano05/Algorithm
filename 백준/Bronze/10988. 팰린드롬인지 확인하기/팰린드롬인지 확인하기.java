import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        bw.write(solution(s)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solution(String s) {
        int answer = 1;

        int l = s.length()/2;
        for(int i=0; i<l; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) {
                answer = 0;
                break;
            }
        }

        return answer;
    }
}