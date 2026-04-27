import java.util.*;
import java.io.*;

public class Main {
    static int NUM = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 계단 수 이전과 1차이가 나야 한다.
        // 이전이 2이면 1,3가 가능하다
        // 두번 째 자리부터 9인 경우 제외 모두 2개의 숫자가 다음에 올 수 있다.

        int N = Integer.parseInt(br.readLine());
        // dp[i][j]: i번째 자리에 j숫자가 올때 가능 한 계단 수
        // i: 몇번째 자리 인지
        // j: i번 째 자리에 오는 숫자
        int[][] dp = new int[N+1][10]; // i:인덱스 맞추기 ,j: 0~9
        // 초기값 채우기
        for(int j=1; j<=9; j++) {
            dp[1][j] = 1;
        }
        // 가능한 수 구하기
        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                // 이번에 0이면 이전 수는 1 밖에 안 됨
                if(j == 0) {
                    dp[i][j] = dp[i-1][j+1]%NUM;
                }
                // 이번에 9이면 이전 수는 8밖에 안 됨
                else if(j==9) {
                    dp[i][j] = dp[i-1][j-1]%NUM;
                }
                // 이번에 1~8이면 이전 수는 앞 뒤 두개씩 가능
                else {
                    dp[i][j] = (dp[i-1][j-1]%NUM + dp[i-1][j+1]%NUM)%NUM;
                }
            }
        }

        // n의 자리일 때 모든 계단 수
        int res = 0;
        for(int i=0; i<=9; i++) {
            res = (res+dp[N][i])%NUM;
        }
        sb.append(res);
        System.out.print(sb);
        br.close();
    }
}