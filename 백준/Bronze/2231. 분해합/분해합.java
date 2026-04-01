import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++) {
            int sum = i;
            int m = i;
            while(m != 0) {
                sum += m%10;
                m = m/10;
            }
            if(sum == N) {
                if(i < min) {
                    min = i;
                }
            }
        }
        // 생성자가 없었을 경우
        if(min == Integer.MAX_VALUE) bw.write("0");
        else bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }
}