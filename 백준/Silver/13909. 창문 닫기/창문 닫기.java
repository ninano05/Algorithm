import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 약수의 개수가 홀수인 창문만 열려있음
        // 약수의 개수가 홀수라는 뜻은 어떤 수의 제곱수라는 뜻이다.
        int N = Integer.parseInt(br.readLine());
        // N 이하의 제곱수는 N루트 개수만큼 나오기 때문
        sb.append((int)Math.sqrt(N));
        System.out.print(sb);
        br.close();
    }
}