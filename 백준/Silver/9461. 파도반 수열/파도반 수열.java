import java.util.*;
import java.io.*;

public class Main {
    static int MAX = 101;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[MAX]; // 인덱스 맞추기
        // 초기값 세팅
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            // 변 채우기
            if(dp[N] == 0) {
                for(int i=4; i<=N; i++) {
                    dp[i] = dp[i - 2] + dp[i - 3];
                }
            }

            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}