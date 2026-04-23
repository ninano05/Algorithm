import java.util.*;
import java.io.*;

public class Main {
    static int[] f;
    static int code1;
    static int code2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        f = new int[N+1]; // 인덱스 맞추려고

        // 각각 실행횟수를 보기 위함
        code1 = 0;
        code2 = 0;
        // 실행시키기
        fib(N);
        fibonacci(N);

        sb.append(code1).append(" ").append(code2);

        System.out.print(sb);
        br.close();
    }

    public static int fib(int n) {
        if(n == 1 || n==2) {
            code1++;
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 2;
        for(int i=3; i<=n; i++) {
            f[i] = f[i-1] +f[i-2];
            code2++;
        }
        return f[n];
    }
}