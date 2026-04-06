import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            boolean[] composite = new boolean[2*n+1]; // false인 경우만 소수

            for(long i=2; i<=(long)2*n; i++) {
                for(long j=i*i; j<=(long)2*n; j+=i) { // i의 배수들 제거
                    composite[(int)j] = true;
                }
            }
            int count = 0;
            for(int i=n+1; i<=2*n; i++) {
                if(i>=2 && !composite[i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}