import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            long n = Long.parseLong(br.readLine()); // n의 범위가 40억까지임
            if( n == 0 || n ==1) {
                n = 2; // 0과 1은 2로 처리하기
            } else if(n%2 == 0 && n !=2) { //2 제외, 짝수인 경우 처리
                n += 1;
            }
            // n 보다 큰 홀수로 완탐 돌리기
            while(true) {
                boolean result = isPrime(n);
                if(result) break;
                n = n+2; // 짝수인 경우 고려할 필요 없기에
            }
            sb.append(n).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    public static boolean isPrime(long n) {
        if(n < 2) {
            return false;
        }
        long limit = (long)Math.sqrt(n);
        for(int i=2; i<=limit; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}