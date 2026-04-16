import java.util.*;
import java.io.*;

public class Main {
    static int res; // 퀸을 두는 모든 경우의 수
    static int[] queen; // 퀸의 좌표만 저장
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        queen = new int[N]; // idx: 행, 요소: 열

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
        // 첫번째 퀸은 무조건 0번 행에 들어감. 두번째 퀸은 무조건 1번 행
        // 열만 반복 돌려주면 됨
        for(int i=0; i<N; i++) {
            if(!check(depth, i)) continue; // 놓을 수 없다면 건뛰

            // 퀸 자리 놓은 좌표 저장
            queen[depth] = i; // 열 넣기

            dfs(depth +1); // 다음 순서 진행

            // 차지한 자리 취소할 필요 없음, 검사할 때 내 행 위로만 보면 됨
            // 그리고 다시 넣는 퀸의 자리로 덮어 씌어짐
        }
    }
    // 퀸을 놓을 수 있는지 없는지 검사
    public static boolean check(int row, int col) { //현재 퀸의 위치, 자리 점유할지 말지
        for(int r=row-1; r>=0; r--) { // 이전 행들에 대해서 검사
            int rDiff = row - r; // 두 점 간 행의 차 (r은 무조건 달라서 0이 될수 없다)
            int cDiff = col - queen[r]; // 두 점간 열의 차
            if(cDiff == 0) return false; // 같은 열에 있다는 뜻

            double slope = rDiff / (double)cDiff;
            if(slope == 1.0 || slope == -1.0) return false;
        }
        return true;
    }
}