import java.util.*;
import java.io.*;

public class Main {
    static boolean[] use; // 해당 인덱스의 숫자 사용 여부
    static int[] num; // 중복 없이 고른 M개의 수열
    static int N;
    static int M;

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 변수 초기화
        use = new boolean[N+1]; // 인덱스와 숫자 맞춰주기 위해
        num = new int[M];

        dfs(0);

        System.out.print(sb);
        br.close();
    }

    public static void dfs(int depth) {
        if(depth == M) { // 숫자 다 골랐으면 출력하고 종료
            for(int n: num) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 시작 범위 설정(오름차순)
        int start = 0;
        if(depth == 0) { // 초기에는 상관 없음
            start = 1;
        } else { // 이전 숫자가 있다면 -> 이전보다 큰수로만 탐색
            start = num[depth-1]+1;
        }
        // 이번 숫자 고르기
        for(int i=start; i<=N; i++) {
            if(use[i]) continue; // 사용한 숫자면 건너뛰기

            // 사용 안 한거면 선택하기
            num[depth] = i;
            use[i] = true;
            dfs(depth+1); // 다음 차례

            // 되돌아 왔으면 이번에 고른 거 취소하고 다음 순서로
            use[i] = false;
        }
    }
}