import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited; // 바이러스 방문 여부
    static ArrayList<Integer>[] graph; // 컴퓨터 연결 그래프

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
        int M = Integer.parseInt(br.readLine()); // 연결 선 개수

        // 객체 크기 지정 및 초기화
        visited = new boolean[N+1]; // 컴퓨터 번호와 인덱스 맞추기
        graph = new ArrayList[N+1]; // 컴퓨터 번호와 인덱스 맞추기
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>(); // 객체 생성
        }
        // 선 연결하기
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 그래프 양방향 연결
            graph[a].add(b);
            graph[b].add(a);
        }
        // dfs로 방문하기
        dfs(1); // 1번 컴퓨터로 시작
        int infect = 0; // 감염 개수
        // 바이러스 걸린 컴퓨터 수 => true 개수 세기 (1제외 해야 함)
        // 혹은 방문처리 하면서 개수 세도 됨.
        for(boolean n : visited) {
            if(n) infect++;
        }
        sb.append(infect-1); // 1번 컴퓨터 빼기
        System.out.print(sb);
        br.close();
    }

    public static void dfs(int start) { // 시작 지점
        visited[start] = true; // 방문처리

        for(int next : graph[start]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

}