import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int left = N;

        for(int i=2; i*i<=N;i++) {
            while(left%i == 0) { // i로 더이상 안 나누어질 때까지
                bw.write(i+"\n");
                left = left/i;
            }
        }
        if(left > 1) bw.write(left+"\n"); // 마지막에 나누고 더이상 안 나누어지는 소수
        bw.flush();
        bw.close();
        br.close();
    }
}
