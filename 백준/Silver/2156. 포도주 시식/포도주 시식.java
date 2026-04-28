import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 포도주 잔의 개수
        int n = Integer.parseInt(br.readLine());

        // 포도 주 잔
        int[] wine = new int[n+1];
        // 포도주 채우기
        for(int i=1; i<=n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // dp[i] i번째까지 누적 포도주 최대의 양
        // i: 몇번째 포도주인지 idx
        int[] dp = new int[n+1];

        // 초기값 설정
        dp[1] = wine[1];
        if(n>=2) { // n이 2보다 클 때만 초기값 설정
            dp[2] = wine[1] + wine[2];
        }
        
        // i번 포도주에서 고민 (마실까 안 마실까)
        for(int i=3; i<=n; i++) {
            // i번 포도주 마심, 이전 포도주 안 마심
            int a = dp[i - 2] + wine[i];
            // i번 포도주 마심, 이전 포도주 마심, 이전이전 포도주 안 마심
            // 이전이전이전 포도주를 마셨다고 가정하는 이유는 최대한 많이 마셔야 최대이기 때문
            int b = dp[i - 3] + wine[i - 1] + wine[i];
            // i번 포도주 안 마심
            int c = dp[i-1];
            // 최대 결정
            dp[i] = Math.max(Math.max(a,b),c);
        }
        sb.append(dp[n]);
        System.out.print(sb);
        br.close();
    }
}