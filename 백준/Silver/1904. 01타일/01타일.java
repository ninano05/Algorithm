import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        //dp[N]은 00과 1로 만들 수 있는 조합 수를 의미
        long[] dp = new long[N+1]; // 인덱스 맞추기

        // N번째 수를 만든다고 생각해보자
        // 마지막이 1로 끝난다면 앞에서 N-1개로 만들 수 있는 숫자 조합의 수는 dp[N-1]이다.
        // 마지막이 00으로 끝난다면 앞에서 N-2개로 만들 수 있는 숫자 조합의 수는 dp[N-2]이다.
        // 따라서 dp[N] = dp[N-1] + dp[N-2]라는 결론이 도출된다.

        dp[1] = 1;
        if(N >= 2) dp[2] = 2;

        for(int i=3; i<=N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%15746;
        }

        sb.append(dp[N]);
        System.out.print(sb);
        br.close();
    }
}