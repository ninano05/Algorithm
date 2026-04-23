import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1]; // 각 위치에 최소 도달 저장, 인덱스 맞추기

        //Bottom-up (1->N)
        // N->1에 도달하는 것이나, 1->N으로 오는 것이나 같은 문제이다.
        // 1->N으로 오는 부분 횟수를 최소로 유지하여 최단 횟수를 찾는다.
        dp[1] = 0; //초기값 설정

        // 1은 이미 초기값으로 설정했으니까, 2부터 최단 횟수를 구한다.
        for(int i=2; i<=N; i++) {

            // 1을 빼는 경우
            // 이게 초기값 설정이다.
            // 1칸 이동은 어디든지 가능하다. 따라서 못 가는 곳이 없다.
            // 2,3 나누기 이동으로 못가는 칸은 이 방법이 최소가 되는 거다.
            // 만약 여기서 초기화를 안 하면 모든 칸은 Math.min 비교하면 0이 될것이다.(기본 배열 생성시 0으로 넣기 때문)
            dp[i] = dp[i-1]+1;

            // 2로 나누는 경우
            if(i%2 == 0) {
                // i%2가 0이면 i/2인 수가 있다는 뜻이다.
                // (i/2)인 수에 *2 했을 때가 다음 이동 횟수인 것으로
                // dp[i/2] + 1 해주면 된다.
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }

            // 3으로 나누는 경우
            if(i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] +1);
            }

        }
        sb.append(dp[N]);
        System.out.print(sb);
        br.close();
    }

}