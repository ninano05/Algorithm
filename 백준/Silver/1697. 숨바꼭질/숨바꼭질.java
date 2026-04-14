import java.util.*;
import java.io.*;

public class Main {
    static int[] dist; // 수빈이가 각 좌표로 이동하는 길의 최단 시간
    static boolean[] visited; // 수빈이가 방문한 길 기록

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken()); // 도달하기 위한 목표

        // 길 초기화
        dist = new int[100001]; // 해당 좌표까지 가는데 걸리는 최단 시간
        visited = new boolean[100001]; // 이전에 방문했던 곳 또 방문할 필요 없음(그렇게 되면 최단 시간이 아니기 때문)

        // 수빈이가 방문하는 길 bfs 돌리기
        bfs(N, target);
        sb.append(dist[target]);

        System.out.print(sb);
        br.close();
    }

    public static void bfs(int start, int target) { // 시작 지점
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true; // 방문 표시 완료
        dist[start] = 0; //현재 위치라 이동 시간 x

        
        while(!queue.isEmpty()) { //타겟을 방문했으면 종료
            int cur = queue.poll(); //현재 위치 꺼내기

            int[] nextMove = {cur -1, cur +1, cur*2};

            for(int i=0; i<3; i++) {
                int next = nextMove[i]; // 현재 위치에서 이동할 수 있는 3가지 경우

                if (next >= 0 && next <= 100000) { // 문제에서 주어진 범위
                    if (!visited[next]) { // 방문 안했으면
                        queue.offer(next); // 방문
                        visited[next] = true; // 방문 처리
                        dist[next] = dist[cur] + 1; // 최단 시간: 부모에서 이동 시간 +1
                    }
                }
            }
            if(visited[target]) return; // 타겟에 도달했으면 탈출
        }
    }
}