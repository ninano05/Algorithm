import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 약수의 개수가 홀수인 창문만 열려있음
        // 약수의 개수가 홀수라는 뜻은 어떤 수의 제곱수라는 뜻이다.

        int N = Integer.parseInt(br.readLine());

        int open = 1; // 1은 자기 자신 뿐이라 무조건 열려 있음 -> 포함해주기
        // 제곱 수는 창문이 열려있다. 제곱수들만 구하면 된다.
        for(int i=2; i*i<=N; i++) {
            open++;
        }
        sb.append(open);
        System.out.print(sb);
        br.close();
    }
}