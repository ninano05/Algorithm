import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t ++) {
            int N = Integer.parseInt(br.readLine());

            // N 보다 작은 소수 고르기
            boolean[] composite = new boolean[N+1];

            for(int i=2; i*i<=N; i++) {
                for(int j=i*i; j<=N; j+=i) {
                    if(!composite[j]) composite[j] = true; // 배수들은 소수 아님
                }
            }
            int count = 0;
            // 두 소수의 합이 N이라는 뜻은 n-소수 = 소수 이어야한다는 뜻이다.
            // 즉 절반에 대해서 (n-소수)가 소수인지 확인하면 된다.
            for(int i=2; i<=N/2; i++) {
                if(!composite[i]) {
                    if(!composite[N-i]) count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}