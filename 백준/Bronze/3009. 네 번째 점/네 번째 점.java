import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] X = new int[3];
        int[] Y = new int[3];

        StringTokenizer st;
        for(int i=0; i<3;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        int x;
        int y;

        if(X[0] == X[1]) {
            x = X[2];
        } else {
            if(X[0] == X[2]) x = X[1];
            else x = X[0];
        }
        if(Y[0] == Y[1]) {
            y = Y[2];
        } else {
            if(Y[0] == Y[2]) y = Y[1];
            else y = Y[0];
        }

        bw.write(x+" "+y);

        bw.flush();
        bw.close();
        br.close();
    }
}
