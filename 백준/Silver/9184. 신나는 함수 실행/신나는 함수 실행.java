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

        // 바텀 업으로 배열 채우기
        // 현재 문제 조건을 보면 a,b,c가 0이하 이거나, 20 초과에 대해서는 고정된 값을 출력한다.
        // 즉 우리가 채워야 하는 건 그 사이의 값들 이라는 뜻이다.
        // 0<= a,b,c <20 인 abc에 대해서 반복문으로 값을 채워주면 된다.
        // 작은 것부터 값을 채우기 위해서 a=0, b=0, c=0인 조건을 포함시켜서 초기값 1을 넣어준다.
        for(int a=0; a<=20; a++) {
            for(int b=0; b<=20; b++) {
                for(int c=0; c<=20; c++) {
                    if(a==0 || b==0 || c==0) {
                        dp[a][b][c] = 1; // 가장 작은값 설정(초기값이라고 봐도 무방)
                    }
                    // 여기서부터 모든 연산은 dp[a][b][c]에 대한 값을 구하기 위해서는 a, b, c보다 작은 dp[]에서 값을 가져온다.
                    // 작은 것부터 값을 채웠기 때문에 당연히 계산할 수 있다.
                    // 만약 a+1 인 조건이 있었다면, 이렇게 쓰지 못했을 것이다.
                    else if(a<b && b<c){
                        dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
                    } else{
                        dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
                    }
                }
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 반복문 종료
            if(a == -1 && b == -1 && c == -1) break;

            int res = 0;
            // 인덱스 중 하나라도 음수거나 0이라면
            if(a<=0 || b<=0 || c<=0) {
                res = 1;
            } // 인덱스 하나라도 20 초과면
            else if(a>20 || b>20 || c>20) {
                res =  dp[20][20][20];
            } else {
                res = dp[a][b][c];
            }

            sb.append("w(").append(a).append(", ").append(b).append(", ")
                    .append(c).append(") = ").append(res).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

}