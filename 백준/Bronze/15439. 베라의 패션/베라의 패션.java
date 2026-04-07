import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 상의 하의 전체 조합에서 색깔 같은 경우만 뺀다.
        int N = Integer.parseInt(br.readLine());
        int clothes = N*N-N;
        sb.append(clothes);
        System.out.print(sb);
        br.close();
    }
}