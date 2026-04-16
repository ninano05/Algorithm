import java.util.*;
import java.io.*;

public class Main {
    static boolean[] col; // 퀸이 들어간 열 표시
    static boolean[] diag1; // 퀸의 들어간 /대각선 표시 (/ 방향 대각선)
                            // => row+col 이 같음 ex) (0,2) (1,1) (2,0)
                           // diag1[row+col] = true 면 사용 중인 것
    static boolean[] diag2; // 퀸이 들어간 \대각선 표시 (\ 방향대각선)
                            // => row-col 이 같음 ex) (0,0) (1,1) (2,2) ...
                            // 근데 만약 (0,3) 일 경우? 0-3 = -3인데 인덱스는 음수가 불가능
                            // 그래서 (row-col) + (N-1) 해서 0 이상으로 자리를 옮겨준다.
                            // diag1[(row-col)+(N-1)] = true 면 사용 중인 것
    static int N;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        col = new boolean[N]; // 퀸이 들어간 열
        // 범위가 2*N-1인  이유
        // diag1에서의 최대 합 => (n-1) + (n-1) = 2n-2 => idx는 2n-2까지 있어야 함 => 배열의 크기는 idx+1
        // diag2에서의 최대 차 => (n-1) - 0인데, 최소 음수(0-(n-1)) 때문에, (n-1)칸 씩 양의 방향으로 밀어주었다.
        // => idx는 2n-2까지 필요 => 배열의 크기는 idx+1
        // 따라서 두개 모두 2*n+1 만큼의 공간이 필요하다.
        diag1 = new boolean[2*N -1];
        diag2 = new boolean[2*N -1];

        dfs(0);

        sb.append(res);
        System.out.print(sb);
        br.close();
    }
    // dfs
    public static void dfs(int row) { // 여기서 퀸은 모든 행에 하나 두어야 하기에, 그냥 위에서부터 채운다.
        if(row == N) { // N개의 퀸을 모두 뒀으면 경우의 수 증가
            res ++;
            return;
        }

        // 퀸 자리 선택
        // 열만 반복 돌려주면 됨
        for(int c=0; c<N; c++) {

            // 열이나 양쪽 대각선 중 어디에도 놓지 못하면 건너뛴다.
            if(col[c] || diag1[row+c] || diag2[row-c+(N-1)]) continue;

            // 퀸 자리 놓은 좌표 저장
            col[c] = true; // 열 넣기
            diag1[row+c] = true; // 대각선 넣기
            diag2[row-c+(N-1)] = true; // 다른 대각선 넣기

            dfs(row +1); // 다음 순서 진행

            // 백트래킹으로 다음 다 돌고 이번 거 취소
            col[c] = false;
            diag1[row+c] = false;
            diag2[row-c+(N-1)] = false;
        }
    }
}