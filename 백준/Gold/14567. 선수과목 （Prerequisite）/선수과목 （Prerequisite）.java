import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] dist; // 각 노드에 대해 출발지로부터 최대로 저장
    static boolean[] indegree; // 선수 과목이 있는지 없는지

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 과목의 수
        int M = Integer.parseInt(st.nextToken()); // 선수 조건

        // 선수 조건으로 그려지는 트리에 따른 dfs
        graph = new ArrayList[N+1]; // 문제번호와 인덱스 맞추기
        dist = new int[N+1];
        indegree = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 선수 조건 그래프로 연결하면서 indegree로 카운팅하기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b] = true; // 시작점이 될 수 없다는 뜻(선수 과목이 있음)
        }
        // 가장 긴 거리 구하기
        bfs(N);

        for(int i=1; i<=N; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }

    public static void bfs(int N) {
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            // 선수과목이 없는 애들을 시작점으로 삼는다.
            if(!indegree[i]){
                que.offer(i);
                dist[i] = 1;
            }
        }

        while(!que.isEmpty()) {
            int cur = que.poll();

            for(int n: graph[cur]) {
                if(dist[n] < dist[cur]+1) {
                    que.offer(n);
                    dist[n] = dist[cur] + 1;
                }
            }
        }
    }
}