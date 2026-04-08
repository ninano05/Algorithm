import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] factor = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            factor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(factor);
        int res = factor[0] * factor[N-1];
        sb.append(res);
        System.out.print(sb);
        br.close();
    }
}