import java.util.*;
import java.io.*;

public class Main {
    static int[] num; // M개 선택한 숫자 배열
    static int N;
    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M];

        dfs(0, 1);

        System.out.print(sb);
        br.close();
    }

    public static void dfs(int depth, int start) {
        if(depth == M) { // 다 골랐으면 출력하고 이번 dfs 종료
            for(int n: num) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 숫자 선택하기
        // 비내림차순을 위해 이전과 같거나 큰 숫자들만 선택이 가능하다.
        for(int i=start; i<=N; i++) {
            num[depth] = i;
            dfs(depth+1, i); // 다음 차례, 이번에 선택한 수와 동일하거나 큰 값으로 제한
        }
    }
}