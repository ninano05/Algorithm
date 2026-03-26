import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        for(int i=0;i<N.length();i++) {
            char c = N.charAt(i);
            if(c>= '0' && c<= '9') {
                answer = answer * B + (c-'0');
            } else {
                answer = answer * B + (c-'A'+10);
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

}