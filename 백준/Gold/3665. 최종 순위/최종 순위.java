import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine()); // 참가한 팀 수

            graph = new ArrayList[N+1]; // 인덱스 맞추기
            indegree = new int[N+1];
            for(int i=1; i<=N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 선후 관계 연결(바로 다음 노드 결과만 연결 ex) 5-4 4-3 3-2 2-1
            // 다 담아야 하나?
            st = new StringTokenizer(br.readLine());
            int[] last = new int[N+1]; // 인덱스 맞추기
            // 작년 순위 저장
            for(int i=1;i<=N; i++) {
                last[i] = Integer.parseInt(st.nextToken());
            }
            // 그래프 연결 (모든 선수 순위 저장)
            for(int i=1; i<N; i++) {
                for(int j=i+1; j<=N; j++) {
                    graph[last[i]].add(last[j]);
                    indegree[last[j]]++;
                }
            }

            // 자리 바꾸기
            int M = Integer.parseInt(br.readLine()); // 바뀐 쌍 수
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 얘가 이번에 높아진 거
                int b = Integer.parseInt(st.nextToken()); // 얘가 이번에 낮아진 거

                // 올해 누가 앞으로 간건지 찾아보기
                boolean front = false;
                for(int n: graph[a]) {
                    if( n == b) { // 작년에 a 가 앞에 있었다면
                        front = true;
                    }
                }

                if(front) { // 올해 b가 앞으로 감
                    // 자리 역전 진입차수 값 조정 및 그래프 다시 연결
                    graph[a].remove(Integer.valueOf(b)); // 객체를 넣으면 a값을 찾아서 a값을 리스트에서 지운다. int를 넣으면 a인덱스르 지우는 것
                    indegree[b]--; // 진입차수 하나 줄이기
                    graph[b].add(a);
                    indegree[a]++; // 진입차수 추가
                } else { // 올해 a가 앞으로 감
                    // 자리 역전 진입차수 값 조정 및 그래프 다시 연결
                    graph[b].remove(Integer.valueOf(a)); // 객체를 넣으면 a값을 찾아서 a값을 리스트에서 지운다. int를 넣으면 a인덱스르 지우는 것
                    indegree[a]--; // 진입차수 하나 줄이기
                    graph[a].add(b);
                    indegree[b]++; // 진입차수 추가
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
        int num = 0;

        for(int i=1; i<=N; i++) { // 진입차수 0인 것들 모두 큐에 넣기
            if(indegree[i] == 0) {
                que.offer(i);
            }
        }

        while(!que.isEmpty()) {
            // 순위를 못 정한다 -> 진입 차수가 0인게 동시에 여러개 발생
            if(que.size() > 1) return "?";

            int cur = que.poll(); // 순위 확정
            rank.append(cur).append(" "); // 순위 기록
            num ++; // 순위 기록한 개수

            for(int n: graph[cur]) {
                indegree[n]--;
                if(indegree[n] == 0) {
                    que.offer(n);
                }
            }
        }
        // 순환이 발생해서 순위 기록 모두 못했는데, 종료된 경우
        if(num != N) return "IMPOSSIBLE";
        return rank.toString();
    }
}