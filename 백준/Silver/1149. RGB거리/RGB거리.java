import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 이웃하는 집과 색이 같으면 안 됨

        // 칠해야 하는 집의 수
        int N = Integer.parseInt(br.readLine());

        // i번째 집을 칠할 때 최소의 비용
        // 초기집을 정해 놓고 이후에 더할 때는 최소 비용만 저장하도록
        int[][] dp = new int[N][3]; // 0:R, 1:G, 2:B

        // 초기값 넣어주기
        st = new StringTokenizer(br.readLine());
        // 집을 칠하는데 드는 가격
        dp[0][0] = Integer.parseInt(st.nextToken()); // R 칠하기
        dp[0][1] = Integer.parseInt(st.nextToken()); // G 칠하기
        dp[0][2] = Integer.parseInt(st.nextToken()); // B 칠하기

        // 집 칠하기
        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            // 집을 칠하는데 드는 가격
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 이번에 R 칠하기
            // 이전 G,B 중 작은 값을 골라서 이번 r과 더하기
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;

            // 이번에 G 칠하기
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;

            // 이번에 B 칠하기
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
        }

        // 최소로 칠한 값 저장
        int max = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);

        sb.append(max);
        System.out.print(sb);
        br.close();
    }
}