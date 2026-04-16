import java.util.*;
import java.io.*;

public class Main {
    static int[] num; // 현재 고른 수열
    static boolean[] select; // 현재 선택한 숫자
    static int N; // 몇번째 수까지 선택 가능한지
    static int M; // 선택 횟수

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 생성
        select = new boolean[N+1]; // 1~N까지라서, 0은 무시
        num = new int[M]; // 지금까지 선택한 숫자 순서대로 담아두기

        // 숫자 선택
        dfs(0);

        System.out.print(sb);
        br.close();
    }

    public static void dfs(int cur) { // 지금 몇번째 선택인지
        if(cur == M) { // 마지막에 도달하면 수열 출력
            for(int n: num) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return; // 이전 dfs로 돌아가기
        }

        for(int i=1; i<=N; i++) {
            // 이미 사용한 숫자는 건너뛰기
            if(select[i]) continue;

            // 사용 안했으면 선택하기
            num[cur] = i; // 현재 자리에 i 선택
            select[i] = true; // i 사용했음 표시

            dfs(cur+1); // 다음 자리 선택하러가기

            //다음 자리 모두 다 고르고 돌아왔으면?
            select[i] = false; // 다시 사용 안 한 상태로 되돌리기
        }
    }
}