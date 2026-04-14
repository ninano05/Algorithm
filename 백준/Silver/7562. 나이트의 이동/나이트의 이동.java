import java.util.*;
import java.io.*;

public class Main {
    static int[][] dist; // 체스판 해당 칸 방문한 최단 시간
    static boolean[][] visited; // 체스판 방문 처리(최소 거리이기에, 방문한 곳 또 방문하지 않는다.)
    static int l; //전체 길이

    // 이동 가짓 수 8가지
    static int[] dr ={1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dc ={-2, -1, 1, 2, 2, 1, -1, -2};

    static public class Node {
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

        // 나이트 이동 최단 거리
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            l = Integer.parseInt(br.readLine());
            // 출발점 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            // 목적지 입력
            st = new StringTokenizer(br.readLine());
            Node target = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            // 변수 초기화
            dist = new int[l][l];
            visited = new boolean[l][l];

            // bfs 최단 거리 방문하기
            bfs(start, target);
            sb.append(dist[target.r][target.c]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void bfs(Node start, Node target) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.r][start.c] = true; // 방문 처리
        dist[start.r][start.c] = 0; // 현재 위치

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            for(int i=0; i<8; i++) { // 이동할 수 있는 가짓수 8가지
                int nextR = cur.r+dr[i];
                int nextC = cur.c+dc[i];

                if(nextR >=0 && nextR <l && nextC >=0 && nextC <l) { //체스판 범위 내
                    if(!visited[nextR][nextC]) { // 방문하지 않은 칸이면
                        queue.offer(new Node(nextR, nextC)); // 큐에 넣기
                        visited[nextR][nextC] = true; // 방문처리
                        dist[nextR][nextC] = dist[cur.r][cur.c] + 1; // 부모의 최단 거리 +1
                    }
                }
            }
            if(visited[target.r][target.c]) return; // 타겟에 도달하면 나오기
        }
    }
}