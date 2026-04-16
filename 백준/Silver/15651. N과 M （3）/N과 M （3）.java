import java.util.*;
import java.io.*;

public class Main {
    static int[] num; // 선택한 숫자 배열
    static int N;
    static int M;

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M];

        dfs(0);

        System.out.print(sb);
        br.close();
    }

    public static void dfs (int depth) { // 현재 고르는 숫자의 idx 번째
        if(depth == M) { // 다 골랐으면 출력하고 이번 dfs 종료
            for(int n: num) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 이번 숫자 선택하기 (중복 가능)
        for(int i=1; i<=N; i++) {
            // 숫자 고르고 다음 숫자 고르러 가기
            num[depth] = i;
            dfs(depth+1);
        }
    }
}