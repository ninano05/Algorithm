import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 계단 개수 입력
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n+1]; // 계단 점수 저장 배열
        // 계단 점수 입력
        for(int i=1; i<=n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        // dp[i] => i번째 계단을 밟은 경우의 최대 점수
        // i는 몇번째 계단인지
        int[] dp = new int[n+1];

        // 초기 값 넣어주기
        dp[1] = stair[1];

        if(n>=2) {
            dp[2] = stair[1]+ stair[2];
        }

        // 점수 계산하기
        for(int i=3; i<=n; i++) {
            // 둘 중에서 큰 값으로 저장한다.
            dp[i] = Math.max(
                    // 이번에 처음 계단 밟음
                    // 전전 계단의 최대합에 이번 계단 점수 더하기
                    dp[i-2] + stair[i],
                    // 이번에 연속으로 계단 밟음(이전 계단의 1 택하기)
                    // 전전 계단을 안 밟아야 함
                    // 전전전 계단의 최대 합에 전계단과 이번 계단 점수 더하기
                    dp[i-3] + stair[i-1] + stair[i]
            );
        }
        sb.append(dp[n]);
        System.out.print(sb);
        br.close();
    }
}