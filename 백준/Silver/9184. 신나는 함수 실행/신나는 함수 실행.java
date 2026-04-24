import java.util.*;
import java.io.*;

public class Main {
    static int MAX = 51;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 값을 저장해둘 배열
        dp = new int[MAX][MAX][MAX];

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 반복문 종료
            if(a == -1 && b == -1 && c == -1) break;

            int res = w(a, b, c);

            sb.append("w(").append(a).append(", ").append(b).append(", ")
                    .append(c).append(") = ").append(res).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int w(int a, int b, int c) {

        // 음수에 대한 처리 (배열에 음수 들어오지 않도록 제일 먼저)
        if(a<0 || b<0 || c<0) return 1;

        // 이전에 값을 구해뒀다면 바로 반환
        if(dp[a][b][c] != 0) return dp[a][b][c];

        // 0에 대한 처리 (초기값 설정)
        if(a==0 || b==0 || c==0) return dp[a][b][c] = 1;

        // 20 초과에 대한 처리
        if(a>20 || b>20 || c>20){
            return w(20, 20, 20);
        }

        // a<b<c에 대한 처리
        if(a<b && b<c) {
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return dp[a][b][c];
        }

        // 그 외 나머지에 대한 처리
        dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return dp[a][b][c];
    }

}