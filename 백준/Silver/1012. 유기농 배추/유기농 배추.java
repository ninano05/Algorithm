import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int n, m;

    // 상하좌우 좌표 이동(0, 1), (0, -1), (-1,0), (0,1)
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        //테스트 케이스 만큼 반복
        for(int i=0;i<t;i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken()); //가로 길이(y)
            n = Integer.parseInt(st.nextToken()); //세로 길이(x)
            int k = Integer.parseInt(st.nextToken());

            // 변수들 채우기
            map = new int[n][m];
            visited = new boolean[n][m];

            // 배추 위치 입력
            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                // 항상 2차원 배열은 행(세로)을 먼저 그 다음 열(가로)
                int y = Integer.parseInt(st.nextToken()); // 가로에 몇번째인지(열)
                int x = Integer.parseInt(st.nextToken()); // 세로의 몇번째인지(행)
                map[x][y] = 1; // 해당 위치에 배추가 들어 있음을 알리기
            }

            int count = 0;

            //배추 연결 요소 개수 찾기(모든 위치 반복)
            for(int p=0;p<n;p++) { // 행
                for(int l=0; l<m; l++) { // 열
                    if(map[p][l]==1 && !visited[p][l]) {// 배추가 있는데, 방문 안했으면
                        bfs(p,l); //dfs로 인접 요소 모두 방문
                        count ++; //인접 요소 모두 방문 완료 했으면 +1
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        // 큐가 비게 될 때까지 반복 => 인접 요소 모두 방문
        while (!queue.isEmpty()) {
            Node curNode =  queue.poll(); //현재 볼 노드 꺼냄

            // 상하좌우 이동한 점들 찾아보기
            for(int i=0; i<4; i++) {
                int nx = curNode.x +dx[i];
                int ny = curNode.y +dy[i];

                // 좌표가 주어진 map 에서 벗어나지 않았는지 확인
                if(nx>=0 && nx <n && ny >= 0 && ny < m) {
                    if(map[nx][ny]==1 && !visited[nx][ny]) { // 방문하지 않은 인접한 곳이면서 배추가 있으면
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}