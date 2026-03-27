import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==0 && b==0) break;

            if(b%a==0) {
                bw.write("factor\n");
            } else if(a%b==0) {
                bw.write("multiple\n");
            } else {
                bw.write("neither\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
