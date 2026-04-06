import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            long n = Long.parseLong(br.readLine()); // n의 범위가 40억까지임
            // n 보다 큰 홀수로 완탐 돌리기
            while(true) {
                boolean result = isPrime(n);
                if(result) break;
                n++;
            }
            sb.append(n).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    public static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2) return true;
        if(n%2 == 0) return false; // 짝수면 소수 아님

        // 홀수만 검사
        for(long i=3; i*i<=n; i+=2) {
            if(n % i == 0) return false;
        }
        return true;
    }
}