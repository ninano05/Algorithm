import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = 0;
        int y = 0;

        StringTokenizer st;
        for(int i=0; i<3;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x ^= Integer.parseInt(st.nextToken());
            y ^= Integer.parseInt(st.nextToken());
        }

        bw.write(x+" "+y);

        bw.flush();
        bw.close();
        br.close();
    }
}
