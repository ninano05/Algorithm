import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 계단 개수 입력
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n]; // 계단 점수 저장 배열
        // 계단 점수 입력
        for(int i=0; i<n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        // dp[i] => i번째 계단을 밟거나 안 밟은 경우의 최대 점수
        // i는 몇번째 계단인지
        // 0: 이번에 계단을 안 밟은 경우
        // 1: 연속 처음 계단을 밟은 경우
        // 2: 연달아서 계단을 밟은 경우
        int[][] dp = new int[n][3];

        // 초기 값 넣어주기
        dp[0][0] = 0;
        dp[0][1] = stair[0];
        dp[0][2] = 0; // 존재하지 않는 경우임

        // 점수 계산하기
        for(int i=1; i<n; i++) {

            // 이번에 계단 안 밟음 (이전 계단의 1,2 중 최대 택하기)
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);

            // 이번에 처음 계단 밟음(이전 0 택하기)
            dp[i][1] = dp[i-1][0] + stair[i];

            // 이번에 연속으로 계단 밟음(이전 계단의 1 택하기)
            dp[i][2] = dp[i-1][1] + stair[i];
        }
        int max = 0;
        for(int i=1; i<3; i++) {
            max = Math.max(dp[n-1][i], max);
        }

        sb.append(max);
        System.out.print(sb);
        br.close();
    }
}