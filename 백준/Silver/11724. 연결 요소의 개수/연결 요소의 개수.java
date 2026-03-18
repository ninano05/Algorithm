import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 노드 개수
        int n = Integer.parseInt(st.nextToken());
        // 간선 개수
        int m = Integer.parseInt(st.nextToken());
        // 그래프 연결하기(0은 사용 안 함)
        graph = new ArrayList[n+1];
        for(int i=1;i<n+1;i++) {
            // 배열 안에 빈 객체 생성(추후 간선 정보 담기 위해)
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 간선 연결 정보 담기
            graph[a].add(b);
            graph[b].add(a);
        }
        count = 0;
        solution(n);
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void solution(int n) {
        // 시작 노드들 바꾸면서 dfs를 하는데
        // 한 요소의 방문을 모두 끝낼 때마다 방문 여부 확인해서 count 더하기
        // 어차피 방문한 노드면 다음 재귀 안해서 반복문 돌려도 ㄱㅊ
        for(int i=1;i<n+1;i++) {
            // 방문한적이 없다면 방문해서 연결요소 싹 돌고 count 증가 시켜라
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
    }
  
    public static void dfs(int node) { // 시작할 노드 넣어주기
        // 방문한 노드 표시 
        visited[node] = true;
        
        // 다음 행선지 정하기
        for(int next : graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
            // 방문 했다면 아무것도 안하고 skip
        }
    }
    
}