import java.util.*;
import java.io.*;

public class Main {
    static int[][] tomato; // 토마토 익었는지 판단하기(방문처리와 비슷)
    static int[][] day; // 해당 칸의 토마토가 익는데 걸린 일 수
    static int N; // 토마토판 행
    static int M; // 토마토판 열
    static Queue<Node> queue;

    // 토마토는 상, 하, 좌, 우로만 익는 거 가능
    static int[] dr = {1, -1, 0, 0}; // 토마토 행 이동
    static int[] dc = {0, 0, -1, 1}; // 토마토 열 이동

    static public class  Node{
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 주위에 있는 토마토가 가까운 순서부터 같이 익는다 -> bfs() 사용
        // 모두 다 익었는지 아닌지에 대한 검사도 필요
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        // 변수 생성
        tomato = new int[N][M];
        day = new int[N][M];
        queue = new ArrayDeque<>(); // 큐 생성
        // 토마토 상태 입력 받기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1) {
                    queue.offer(new Node(i, j)); // 시작점 모두 넣어주기
                    day[i][j] = 0; // 이미 익어 있어서 0일
                }
            }
        }
        // 애초에 모든 토마토가 익어있는 경우
        if(finish() == 0) {
            sb.append("0");
        } else {
            // 토마토 숙성 시작 bfs()
            bfs();
            // 숙성 끝난 뒤 검사
            if(finish() == -1) sb.append("-1");
            else { // 다 익었으면 최대 일수 출력
                int max = 0;
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        max = Math.max(max, day[i][j]);
                    }
                }
                sb.append(max);
            }
        }
        System.out.print(sb);
        br.close();
    }

    // 토마토 모두 익었는지 검사하기
    public static int finish() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tomato[i][j] == 0) return -1; // 안익은 거 있음
            }
        }
        return 0; // 모두 익음
    }

    // 토마토 익히기
    // 근데 토마토는 여러군데에서 동시에 익어가는데...
    public static void bfs() {
        // 이미 모든 시작점은 큐에 들어가 있다
        // 먼저 만나는 쪽이 더 빠른 거라 최소 일도 보장 된다.
        while(!queue.isEmpty()) { // 큐가 안 비어 있다면
            Node cur = queue.poll();

            for(int i=0; i<4; i++) { // 토마토는 주위 4칸을 익게만든다.
                int nextR = cur.row + dr[i];
                int nextC = cur.col + dc[i];

                if(nextR >=0 && nextR <N && nextC >= 0 && nextC <M) { // 토마토 판 범위 내
                    if(tomato[nextR][nextC] == 0) { // 안 익은 토마토라면
                        queue.offer(new Node(nextR, nextC)); // 토마토 큐에 넣기(익히기)
                        tomato[nextR][nextC] = 2; // 익은 거 표시 (2인 이유는 초기에 익어있는 토마토와 구분하기 위해)
                        day[nextR][nextC] = day[cur.row][cur.col] + 1; // 숙성에 걸린 최소 일 수 부모 +1
                    }
                }
            }
        }
    }
}