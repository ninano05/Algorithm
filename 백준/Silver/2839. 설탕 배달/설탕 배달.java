import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int small= 0;
        int big = 0;
        int min = 0;

        loop:
        for(int s=0; s<(n/3+1); s++) {
            for(int b=0; b<(n/5+1); b++){
                int weight = 3*s+5*b;
                if(weight == n) {
                    small = s;
                    big = b;
                    break loop;
                }
            }
        }
        if(small == 0 && big == 0) {
            bw.write("-1");
        } else {
            bw.write(small + big+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}