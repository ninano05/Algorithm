import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int factorial = 1;
        for(int i=1; i<=N; i++) {
            factorial *= i;
        }
        sb.append(factorial);
        System.out.print(sb);
        br.close();
    }
}