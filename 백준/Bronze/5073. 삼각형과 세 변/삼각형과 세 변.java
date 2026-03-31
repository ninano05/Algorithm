import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if((a+b+c) == 0) break; // 빠져나가는 조건

            int max = Math.max(Math.max(a, b), c);
            int sum = a+b+c - max;

            if(max >= sum) {
                bw.write("Invalid\n");
            } else if (a==b && b==c) {
                bw.write("Equilateral\n");
            } else if (a==b || b==c || a==c) {
                bw.write("Isosceles\n");
            } else {
                bw.write("Scalene\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
