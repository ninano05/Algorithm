import java.util.*;
import java.io.*;

public class Main {
    static int[][] miro;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[][] dist; // 이번 칸까지의 최단 거리

    // 이동 방향 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r; //행
        int c; //열

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 최단거리 bfs
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열

        visited = new boolean[N][M];
        miro = new int[N][M];
        dist = new int[N][M];
        // 미로 채우기
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                miro[i][j] = s.charAt(j) - '0';
            }
        }
        // 최소 칸 수 -> bfs 최단 거리 원하는 지점에 도달했을 때가 최단 거리다
        bfs(0,0); // 모든 방문 가능한 노드들의 최단거리 구하기

        sb.append(dist[N-1][M-1]);

        System.out.print(sb);
        br.close();
    }

    public static void bfs(int row, int col) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(row, col)); // 큐에 추가
        visited[row][col] = true; // 방문 처리
        dist[row][col] = 1; // 처음 방문 칸은 1

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            for(int i=0; i<4; i++) {
                int nextRow = cur.r + dr[i];
                int nextCol = cur.c + dc[i];

                if(nextRow >=0 && nextRow < N && nextCol >=0 && nextCol < M) { // 미로 범위 안
                    if(!visited[nextRow][nextCol] && miro[nextRow][nextCol] == 1) { // 방문 안하고 길인 경우
                        queue.offer(new Node(nextRow, nextCol));
                        visited[nextRow][nextCol] = true;
                        dist[nextRow][nextCol] =  dist[cur.r][cur.c] + 1; // 다음 노드의 거리는 부모 노드까지 걸린 최단 거리에 +1
                    }
                }

            }
        }
    }
}