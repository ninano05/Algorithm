
import java.io.*;
import java.util.*;

public class Main {

    static int N, r, c, d;
    static int[][] map;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    // 상(1), 하(2), 좌(3), 우(4)
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};

    // 현재 방향에 따른 인접 탐색 순서
    static int[][] priority = {
        {},
        {1, 3, 4, 2},
        {2, 4, 3, 1},
        {3, 2, 1, 4},
        {4, 1, 2, 3}
    };

    // 최단 경로 이동 우선순위
    static int[] order = {3, 2, 4, 1};

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 위치 방문
        visited[r][c] = true;
        sb.append(r).append(" ").append(c).append("\n");

        while (true) {

            // 인접한 미방문 바다가 있으면 한 칸 이동
            if (moveNear()) {
                continue;
            }

            // 없으면 BFS로 가장 가까운 목적지 탐색
            Node target = findTarget();

            // 갈 수 있는 미방문 바다가 없으면 종료
            if (target == null) {
                break;
            }

            // 목적지까지 최단 경로로 이동
            moveToTarget(target);
        }

        System.out.print(sb);
    }

    // 격자 범위 확인
    static boolean inRange(int nr, int nc) {
        return nr >= 1 && nr <= N
            && nc >= 1 && nc <= N;
    }

    // 고래 이동 및 방문 처리
    static void move(int nr, int nc, int nd) {

        r = nr;
        c = nc;
        d = nd;

        if (!visited[r][c]) {
            visited[r][c] = true;

            sb.append(r).append(" ")
              .append(c).append("\n");
        }
    }

    // 1. 인접한 미방문 바다 탐색
    static boolean moveNear() {

        for (int nd : priority[d]) {

            int nr = r + dr[nd];
            int nc = c + dc[nd];

            if (!inRange(nr, nc)) continue;
            if (map[nr][nc] == 1) continue;
            if (visited[nr][nc]) continue;

            move(nr, nc, nd);
            return true;
        }

        return false;
    }

    // 2. BFS로 가장 가까운 미방문 바다 탐색
    static Node findTarget() {

        int[][] dist = new int[N + 1][N + 1];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(r, c));
        dist[r][c] = 0;

        Node target = null;
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            Node cur = q.poll();
            int distance = dist[cur.r][cur.c];

            if (distance > minDist) break;

            // 미방문 바다 발견
            if (!visited[cur.r][cur.c]) {

                if (distance < minDist ||
                   (distance == minDist &&
                    (target == null ||
                     cur.r < target.r ||
                     (cur.r == target.r && cur.c < target.c)))) {

                    target = cur;
                    minDist = distance;
                }

                continue;
            }

            for (int nd = 1; nd <= 4; nd++) {

                int nr = cur.r + dr[nd];
                int nc = cur.c + dc[nd];

                if (!inRange(nr, nc)) continue;
                if (map[nr][nc] == 1) continue;
                if (dist[nr][nc] != -1) continue;

                dist[nr][nc] = distance + 1;
                q.offer(new Node(nr, nc));
            }
        }

        return target;
    }

    // 3. 목적지까지 최단 경로 이동
    static void moveToTarget(Node target) {

        int[][] dist = new int[N + 1][N + 1];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        // 목적지에서 역방향 BFS
        Queue<Node> q = new ArrayDeque<>();

        q.offer(target);
        dist[target.r][target.c] = 0;

        while (!q.isEmpty()) {

            Node cur = q.poll();

            for (int nd = 1; nd <= 4; nd++) {

                int nr = cur.r + dr[nd];
                int nc = cur.c + dc[nd];

                if (!inRange(nr, nc)) continue;
                if (map[nr][nc] == 1) continue;
                if (dist[nr][nc] != -1) continue;

                dist[nr][nc] = dist[cur.r][cur.c] + 1;
                q.offer(new Node(nr, nc));
            }
        }

        // 최단 거리 감소 방향으로 한 칸씩 이동
        while (r != target.r || c != target.c) {

            for (int nd : order) {

                int nr = r + dr[nd];
                int nc = c + dc[nd];

                if (!inRange(nr, nc)) continue;
                if (dist[nr][nc] != dist[r][c] - 1) continue;

                move(nr, nc, nd);
                break;
            }
        }
    }
}
