import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 물건 개수
            int K = Integer.parseInt(st.nextToken()); // 최대 무게

            // 같은 인덱스는 같은 아이템을 의미
            int[] W = new int[N+1]; // 무게
            int[] V = new int[N+1]; // 가치

            // 아이템 정보 입력
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                W[i] = Integer.parseInt(st.nextToken());
                V[i] = Integer.parseInt(st.nextToken());
            }

            // dp[i][j]:i번째 물건을 W 무게로 담을 수 있는 최대의 V를 의미한다
            // i는 몇번째 물건인지
            // j:i번째 물건을 담는다고 했을 때 무게 종류
            int[][] dp = new int[N+1][K+1]; // 인덱스 1번부터 시작하도록 맞추기

            // 모든 물건에 대해서 담을지 말지
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=K; j++) {
                    // 원래 이전 회차 기존의 값과
                    // 이전 회차에서 나의 무게를 제외한 것에서 담아놓은 가치에 나의 가치를 더한 값을 비교
                    if(j >= W[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                    }else{
                        // 이번 회차의 무게보다 작은 경우는 어차피 못넣으니까 이전으로 유지
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(dp[N][K]).append("\n");

        }
        System.out.print(sb);
        br.close();
    }
}