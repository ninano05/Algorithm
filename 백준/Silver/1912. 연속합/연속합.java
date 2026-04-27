import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 이차원 배열로?
        int n = Integer.parseInt(br.readLine());

        // i는 입력 인덱스
        // i번 째를 포함하는 최대합
        int[] dp = new int[n];

        // 입력 받아오기
        st = new StringTokenizer(br.readLine());

        // 초기값 설정
        dp[0] = Integer.parseInt(st.nextToken());

        // 최대
        int max = dp[0];

        for(int i=1; i<n; i++) { // 종료 인덱스
            // i번째를 포함하는 것 중 최대합을 저장한다.
            int cur = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1] + cur, cur); // 이어 가는게 나은지, 아니면 나부터 다시 시작하는게 나은지 구한다
            max = Math.max(max, dp[i]); // 최대 연속 합 업데이트
        }

        sb.append(max);
        System.out.print(sb);
        br.close();
    }
}