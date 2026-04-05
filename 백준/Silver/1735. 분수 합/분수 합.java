import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 합 구하기 임 => 기약 분수 보장x
        int den = (b*d) / gcd(b,d);
        int mol = a*(den/b) + c*(den/d);
        // 다시 분자와 분모의 최대공약수를 구해서 나누어주어야 함.
        int g = gcd(den, mol);
        den = den/g;
        mol = mol/g;

        sb.append(mol).append(" ").append(den);
        System.out.print(sb);
        br.close();
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }


}