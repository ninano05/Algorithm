import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 다리는 N개 만큼 만들 수 있음.
        // 겹쳐서 지을 수 없음. (!!!)
        // 겹쳐서 지을 수 없다는 말은 다리에 순서가 없다는 말이다.
        // 즉 겹쳐서 지은 경우도 순서를 바꿔주면 겹쳐 지은 것이 아니다.
        // 다리 강변을 기준으로 각 스팟들은 동일한 애들이고, 그저 짝을 지을 수 있도록 조합만 짜면 된다.
        // mCn을 하면 된다는 뜻이다.
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] dp = new int[M+1][M+1];
            // 다리 건설 (dp)
            for(int i=0; i<M+1; i++) {
                dp[i][0] = 1; // 맨 앞 1 넣기
                dp[i][i] = 1; // 맨 뒤 1넣기
                for(int j=1; j<i; j++) {
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
            }
            sb.append(dp[M][N]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}