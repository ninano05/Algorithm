import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long lcm = (a*b) / gcd(a, b);

        sb.append(lcm);
        System.out.print(sb);
        br.close();
    }

    public static long gcd(long a, long b) {
        while( b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}