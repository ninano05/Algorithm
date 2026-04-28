import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 수열 A
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] i번째 자리에서 최대의 길이
        // i: 몇번째인지 idx
        int[] dp = new int[N];

        // 초기값 설정
        // 최장 길이는 모두 자기 자신을 길이로 포함하기 때문에,
        // 1을 기본으로 가져야 한다.
        // 그래야지 이전에 나랑 다음의 나랑 비교했을 때 커지는 경우가 한번도 없을 때 1을 가진다.
        Arrays.fill(dp, 1);

        for(int i=0; i<N; i++) { // 이번에 확인할 숫자 위치
            for(int j=0; j<i; j++) { // 자기 자신 빼고 이전들과 비교
                if(A[i] > A[j]) { // 이번이 더 커지는 경우
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        // 최대 길이 찾기
        int max = dp[0];
        for(int i=1; i<N; i++) {
            max = Math.max(max, dp[i]);
        }

        sb.append(max);
        System.out.print(sb);
        br.close();
    }
}