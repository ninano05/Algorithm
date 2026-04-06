import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i=M; i<=N; i++) {
            boolean res = isPrime(i);
            if(res) sb.append(i).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static boolean isPrime(int n) {
        if(n <2) return false;
        if(n == 2) return true;
        if(n%2 == 0) return false;

        for(int i=3; i*i<=n; i+=2) {
            if(n%i == 0) return false;
        }
        return true;
    }
}