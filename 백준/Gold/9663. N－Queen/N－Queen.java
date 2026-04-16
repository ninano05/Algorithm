import java.util.*;
import java.io.*;

public class Main {
    static int res; // 퀸을 두는 모든 경우의 수
    static boolean[][] queen; // 퀸을 둔 자리와 해당 퀸이 이동 가능한 자리
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 퀸은 상,하,좌,우, 대각선 4방향 까지 모두 이동 가능
        // 처음 퀸을 두었을 때 다음 퀸 위치를 고를 때 퀸이 접근 가능한 방향에 두지 않는다.
        // 퀸을 둔 다음 해당 퀸이 접근 가능한 칸을 모두 true로 바꾼다.
        N = Integer.parseInt(br.readLine());

        queen = new boolean[N][N];

        dfs(0);

        sb.append(res);

        System.out.print(sb);
        br.close();
    }
    // dfs
    public static void dfs(int depth) { // 여기서 depth는 퀸을 두는 것
        if(depth == N) { // N개의 퀸을 모두 뒀으면 경우의 수 증가
            res ++;
            return;
        }

        // 퀸 자리 선택
        // 한 행에는 어차피 한명만 들어감
        // 첫번째 퀸은 무조건 0번 행에 들어감.
        // 두번째 퀸은 무조건 1번행
        // 열만 반복 돌려주면 됨
        for(int i=0; i<N; i++) {
            if(queen[depth][i]) continue;

            // 퀸 자리 차지하기
            if(isPossible(depth, i)) { // 자리 차지할 수 있다면
                queen[depth][i] = true;
                dfs(depth+1); //다음 순서 진행

                // 차지한 자리 취소 -> 이게 문제다 이전 기록도 같이 건드림
                queen[depth][i] = false;
            }

        }
    }
    // 이전 퀸들의 선상에 있는지 없는지 검사
    public static boolean isPossible(int row, int col) { //현재 퀸의 위치, 자리 점유할지 말지
        // 같은 열에 있는지 (내 이전 행만 보면 됨)
        for(int i=0; i<row; i++) {
            if(queen[i][col]) return false;
        }
        // 이전 행들에 대해서 대각선 검사하기 (아래 행에는 체스를 두지 않았음)
        // 왼쪽 위 대각선
        int LeftR = row;
        int LeftC = col;
        while(LeftR >= 0 && LeftC >= 0) {
            if(queen[LeftR][LeftC]) return false;
            LeftR--;
            LeftC--;
        }
        // 오른쪽 위 대각선
        int rightR = row;
        int rightC = col;
        while(rightR >= 0 && rightC < N) {
            if(queen[rightR][rightC]) return false;
            rightR--;
            rightC++;
        }
        return true;
    }
}