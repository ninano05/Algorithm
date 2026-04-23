import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 문제 수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수

        // 변수 초기화
        indegree = new int[N+1]; // 문제번호와 인덱스 맞추기
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 문제 푸는 순서 그래프로 입력
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        topology(N);

        System.out.print(sb);
        br.close();
    }

    public static void topology(int N) {
        // 문제 번호가 작은 걸 먼저 풀어야하기 때문에 우선순위 큐로 생성했다.
        // 기본이 최소힙이라, 들어간 요소들은 문제번호가 작은 것부터 앞으로 정렬된다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 진입차수 0인 처음 풀 문제 찾아서 큐에 넣기
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) {
                pq.offer(i);
            }
        }

        // 선수 문제부터 풀기
        while(!pq.isEmpty()) { // 항상 모든 문제 풀 수 있다고 해서 while 사용함
            // 큐에서 꺼냈다 = 문제를 풀었다
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for(int n : graph[cur]) {
                indegree[n]--;
                if(indegree[n] == 0){
                    pq.offer(n);
                }
            }
        }
    }
}