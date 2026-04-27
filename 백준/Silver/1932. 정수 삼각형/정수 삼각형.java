import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 현재 선택 기준 이전에 선택할 수 있는 최대 경우를 선택한다.
        int n = Integer.parseInt(br.readLine());

        // dp[i][j]
        // i는 층 수 맨위가 0층
        // j는 입력 값 인덱스
        // dp의 값은 층수에서 j의 값에 대한 최대 합
        int[][] dp = new int[n][n];

        // 초기값 넣어주기
        dp[0][0] = Integer.parseInt(br.readLine());
        // 나머지 삼각형 경로 구하기
        for(int i=1; i<n; i++) { // 층수
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) { // 입력 숫자 인덱스
                int num = Integer.parseInt(st.nextToken()); // 이번 숫자

                // j가 0번 인덱스 (맨 앞)
                // 부모가 어차피 한명 뿐
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + num;
                }
                // j가 i번 인덱스 (맨 뒤)
                // 부모가 어차피 한명 뿐
                else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + num;
                }
                // j가 가운데 인덱스 (중간) -> 비교 필요
                // 두명의 부모 중 더 큰 값 선택
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + num;
                }
            }
        }
        // 최대 값 가져오기
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, dp[n-1][i]);
        }
        sb.append(max);
        System.out.print(sb);
        br.close();
    }
}