import java.util.*;
import java.io.*;

public class Main {
    static int[][][] tomato; // 토마토 정보 저장 (층, 행, 열)
    static int[][][] day; // 해당 칸의 토마토가 익는데 걸리는 시간
    static Queue<Node> queue;

    // 3차원 이동 가능 상, 하, 앞, 뒤 좌, 우 => 6가지
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {0 ,0, 0, 0, -1, 1};

    // 층, 행, 열을 가지는 점
    static public class Node{
        int h;
        int r;
        int c;

        Node(int height, int row, int col) {
            this.h = height;
            this.r = row;
            this.c = col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken()); // 열
        int N = Integer.parseInt(st.nextToken()); // 행
        int H = Integer.parseInt(st.nextToken()); // 높이

        // 변수 생성
        tomato = new int[H][N][M];
        day = new int[H][N][M];
        queue = new ArrayDeque<>();

        // 토마토 정보 입력
        for(int h=0; h<H; h++) { //층
            for(int i=0; i<N; i++) { //행
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<M; j++) { //열
                    tomato[h][i][j] = Integer.parseInt(st.nextToken());
                    if(tomato[h][i][j] == 1) {
                        // 토마토 시작점도 같이 큐에 넣어주기
                        queue.offer(new Node(h, i, j));
                        day[h][i][j] = 0;
                    }
                }
            }
        }

        // 모두 익어 있음
        if(finish(H, N, M) == 0){
            sb.append("0");
        } else {
            //bfs 돌리기
            bfs(H, N, M);
            // 다 익을 수 있는 지 검사
            if(finish(H, N, M) == 0) { // 다 익은 경우
                int max = 0; // 익는데 가장 오래 걸린 토마토
                for(int h=0; h<H; h++) { //층
                    for(int i=0; i<N; i++) { //행
                        for(int j=0; j<M; j++) { //열
                            max = Math.max(max, day[h][i][j]);
                        }
                    }
                }
                sb.append(max);
            } else { // 다 못 익는 경우
                sb.append("-1");
            }
        }
        System.out.print(sb);
        br.close();
    }

    // 토마토 익었는지 여부
    public static int finish(int H, int N, int M) {
        for(int h=0; h<H; h++) { //층
            for(int i=0; i<N; i++) { //행
                for(int j=0; j<M; j++) { //열
                    if(tomato[h][i][j] == 0) return -1; // 안 익은 토마토
                }
            }
        }
        return 0; // 모두 익음
    }

    public static void bfs(int H, int N, int M) {
        // 출발점은 이미 큐에 담겨 있음
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            // 다음 익을 후보지들
            for(int i=0; i<6; i++) { // 6가지 이동 가능
                int nextH = cur.h + dh[i];
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextH>=0 && nextH<H && nextR>=0 && nextR <N && nextC>=0 && nextC<M) { // 상자 범위 안
                    if(tomato[nextH][nextR][nextC] == 0) {
                        queue.offer(new Node(nextH, nextR, nextC));
                        tomato[nextH][nextR][nextC] = 1;
                        day[nextH][nextR][nextC] = day[cur.h][cur.r][cur.c] +1; // 부모가 걸린 시간보다 하루 더 걸림
                    }
                }
            }
        }
    }
}