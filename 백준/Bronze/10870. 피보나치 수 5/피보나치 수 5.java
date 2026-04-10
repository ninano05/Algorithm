import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        // dp 배열
        int[] dp = new int[N+1];
        
        //초기값
        if(N>=1) dp[1] = 1;
        
        // 점화식
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        sb.append(dp[N]);
        System.out.print(sb);
        br.close();
    }
}