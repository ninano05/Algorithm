import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph; // 그래프
    static int[] indegree; // 진입차수
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수

        // 변수 초기화
        graph = new ArrayList[N+1]; // 학생이 1번부터 시작 인덱스 맞추기
        indegree = new int[N+1]; // 인덱스 맞추기 0무시
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 그리기 & 진입차수 표시
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b); // 그래프 관계 표시
            indegree[b]++; // 진입차수 추가(선수 작업 개수 추가)
        }

        // 위상 정렬
        topologySort();

        System.out.print(sb);
        br.close();
    }

    public static void topologySort() {
        Queue<Integer> que = new ArrayDeque<>(); // 진입 가능한 애들 담아 놓는 큐

        // 진입차수가 0인거 큐에 다 넣어주기(진입 가능한 애들이기에)
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()) {
            int cur = que.poll(); // 꺼내면 진입했다는 뜻
            sb.append(cur).append(" "); // 꺼냈으면 출력하기(이 부분을 배열에 저장해도 됨)

            for(int n : graph[cur]){ // 현재 연결된 다음 노드들 진입 가능한지 확인
                // cur이 선수였는데, 해결된 것이기 때문에 진입차수를 하나 줄인다.
                indegree[n] --;
                // 이제 진입 가능한지 확인한다
                if(indegree[n] == 0) {
                    que.offer(n); // 진입 가능하면 큐에 넣는다.(진입)
                }
            }
        }

    }


}