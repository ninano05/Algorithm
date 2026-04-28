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
        
        int max = 1; // 최소 길이1
        for(int i=0; i<N; i++) { // 이번에 확인할 숫자 위치
            // 자기 자신만 선택하는 경우
            dp[i] = 1;
            
            for(int j=0; j<i; j++) { // 자기 자신 빼고 이전들과 비교
                if(A[i] > A[j]) { // 이번이 더 커지는 경우
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // 최장 길이 업데이트
            max = Math.max(max, dp[i]);
        }
        sb.append(max);
        System.out.print(sb);
        br.close();
    }
}