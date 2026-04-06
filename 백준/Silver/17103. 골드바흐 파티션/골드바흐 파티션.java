import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int max = 1000000;
        boolean[] composite = new boolean[max+1];
        composite[0] = true;
        composite[1] = true;

        for(int i=2; i*i<=max; i++) {
            if(!composite[i]) { // 소수일 때만 그 배수들을 채로 제외하기 위함
                for(int j=i*i; j<=max; j+=i) {
                    composite[j] = true;
                }
            }
        }

        for(int t=0; t<T; t ++) {
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            // 두 소수의 합이 N이라는 뜻은 n-소수 = 소수 이어야한다는 뜻이다.
            // 즉 절반에 대해서 (n-소수)가 소수인지 확인하면 된다.
            for(int i=2; i<=N/2; i++) {
                if(!composite[i] && !composite[N-i]) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}