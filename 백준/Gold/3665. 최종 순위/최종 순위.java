import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] graph;
    static int[] indegree;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine()); // 참가한 팀 수

            graph = new boolean[N+1][N+1]; // 인덱스 맞추기
            indegree = new int[N+1];

            // 선후 관계 true,false로 모두 표현
            st = new StringTokenizer(br.readLine());
            int[] last = new int[N+1]; // 인덱스 맞추기
            // 작년 순위 저장
            for(int i=1;i<=N; i++) {
                last[i] = Integer.parseInt(st.nextToken());
            }
            // 그래프 연결 (모든 선수 순위 저장)
            for(int i=1; i<N; i++) {
                for(int j=i+1; j<=N; j++) {
                    int front = last[i];
                    int back = last[j];
                    graph[front][back] = true;
                    graph[back][front] = false;
                    indegree[back]++;
                }
            }

            // 자리 바꾸기
            int M = Integer.parseInt(br.readLine()); // 바뀐 쌍 수
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 올해 누가 앞으로 간건지 찾아서 자리 바꾸기
                if(graph[a][b]) { // 작년 a가 앞, 올해 b가 앞
                    graph[b][a] = true;
                    indegree[a]++;
                    graph[a][b] = false;
                    indegree[b]--;

                } else { // 작년 b가 앞, 올해 a가 앞
                    graph[a][b] = true;
                    indegree[b]++;
                    graph[b][a] = false;
                    indegree[a]--;
                }
            }
            // 위상 정렬로 순위 확정 가능한지 점검
            sb.append(topologySort()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static String topologySort() {
        Queue<Integer> que = new ArrayDeque<>();
        StringBuilder rank = new StringBuilder();

        for(int i=1; i<=N; i++) { // 진입차수 0인 것들 모두 큐에 넣기
            if(indegree[i] == 0) {
                que.offer(i);
            }
        }

        // N개를 순서에 맞게 놓는다는 이야기는 N번 큐에서 꺼낸다는 의미이다.
        for(int i=0; i<N; i++) {
            // N번 다 못돌렸는데 큐가 비었다 -> 싸이클 발생했다는 뜻
            if(que.isEmpty()) return "IMPOSSIBLE";
            // 순위를 못 정한다 -> 진입 차수가 0인게 동시에 여러개 발생
            if(que.size() > 1) return "?";

            int cur = que.poll(); // 순위 확정
            rank.append(cur).append(" "); // 순위 기록

            for(int n=1; n<=N; n++) {
                // 다음 순위가 true인 경우에 대해 선수 처리 하기
                if(graph[cur][n]) {
                    indegree[n]--;
                    if (indegree[n] == 0) {
                        que.offer(n);
                    }
                }
            }
        }
        return rank.toString();
    }
}