import java.util.*;
import java.io.*;

class Solution
{
	static int[][] board; //1은 흑돌, 2는 백돌
    static int N;
    static Queue<Node> que;

    // 상하좌우, 대각선
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static class Node{
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 보드 너비
            int M = Integer.parseInt(st.nextToken()); // 돌을 놓는 횟수

            // 보드판
            board = new int[N+1][N+1];

            // 기본 돌 배치하기
            board[N/2][N/2] = 2; //백돌
            board[N/2+1][N/2+1] = 2;
            board[N/2+1][N/2] = 1; //흑돌
            board[N/2][N/2+1] = 1;

            for(int i=0; i<M; i++) { // M번 마다 입력 받기
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken()); // x좌표는 열
                int r = Integer.parseInt(st.nextToken()); // y좌표는 행
                int stone = Integer.parseInt(st.nextToken());

                // 돌 놓기
                board[r][c] = stone;

                // 돌 따먹기 시작
                changeStone(r, c);
            }

            // 개수 세기
            int black = 0; // 흑돌 개수
            int white = 0; // 백돌 개수
            for(int i=1; i<=N; i++) {
                for (int j = 1; j <=N; j++) {
                    if (board[i][j] == 1) {
                        black++;
                    } else if (board[i][j] == 2) {
                        white++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(black)
                    .append(" ").append(white).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    // 8방향 바로 옆에 다른돌, 그 건너에 같은돌이 있는 경우, 바꾸기
    // 바꾼 다음에는 그 바뀐돌의 주변을 또 바꿔야 함
    public static void changeStone(int r, int c) {
        que = new ArrayDeque<>();
        que.offer(new Node(r, c));


        // 주변 돌 탐색 하기
        while(!que.isEmpty()){
            Node cur = que.poll();
            int stone = board[cur.r][cur.c]; // 현재 위치의 돌 색깔

            // 주변 탐색
            for(int i=0; i<8; i++) {
                // 옆칸
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr>=0 && nr<=N && nc>=0 && nc<=N) { // 범위 안에서
                    if(board[nr][nc] != stone) { // 옆이 다른 색임
                        // 바꿀 수 있는 지 탐색해서 색 바꾸기
                        dfs(nr, nc, stone, board[nr][nc], i);
                    }
                }
            }
        }
    }

    public static int dfs(int r, int c, int pStone, int nStone, int i) {

        // 탐색 종료 조건
        if(board[r][c] == pStone) { // 부모랑 같은 경우
            return pStone; // 색깔 바꿔주기
        } else if(board[r][c] == 0) { // 빈 공간이 나오면
            return nStone; //현행유지
        }

        // 다음 순서
        int nr = r+dr[i];
        int nc = c+dc[i];

        if(nr>0 && nr<=N && nc>0 && nc<=N) { // 범위 확인
            // 다음돌 확인하기
            int color = dfs(nr, nc, pStone, nStone, i);

            board[r][c] = color; //이게 색 교체 작업임

            // 돌아왔는데 반환된게 있다면
//            if(color == pStone) { // 색이 교체 된다면
//                board[r][c] = color; //이게 색 교체 작업임
//                que.offer(new Node(r, c)); // 또 탐색 순서에 넣어주어야 함
//            }

            return color;
        } else { // 범위에서 벗어났다
            return nStone; // 자기 자신 색깔 반환, 색 변화 못했다는 뜻
        }
    }
}