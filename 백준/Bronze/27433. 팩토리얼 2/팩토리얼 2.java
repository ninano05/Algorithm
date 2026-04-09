import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long res = factorial(N);
        sb.append(res);
        System.out.print(sb);
        br.close();
    }

    public static long factorial(int n) {
        if(n>1) return n * factorial(n-1);
        else return 1;
    }
}