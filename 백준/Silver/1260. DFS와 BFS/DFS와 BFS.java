import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visitedDFS; //dfs 방문
    static boolean[] visitedBFS; //bfs 방문
    static ArrayList<Integer> recordDFS = new ArrayList<>(); //dfs 방문 기록
    static ArrayList<Integer> recordBFS = new ArrayList<>(); //bfs 방문 기록
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 변수 입력 받기
        int n = Integer.parseInt(st.nextToken()); //노드 개수
        int m = Integer.parseInt(st.nextToken()); //간선 개수
        int v = Integer.parseInt(st.nextToken()); //시작점
        
        //graph,visited 초기화
        graph = new ArrayList[n+1];
        visitedDFS = new boolean[n+1];
        visitedBFS = new boolean[n+1];
        for(int i=1;i<n+1;i++) {
            graph[i] = new ArrayList<>();
        }
        
        //간선 입력 받기
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // 그래프 순서 정렬(작은 노드부터 방문하도록)
        for(int i=1; i<n+1; i++) {
            Collections.sort(graph[i]);
        }
        
        // dfs, bfs 실행
        dfs(v);
        bfs(v);
        
        // 결과 출력
        for(int k : recordDFS) {
            bw.write(k+" ");
        }
        bw.write("\n");
        for(int j : recordBFS) {
            bw.write(j+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int start) {
        visitedDFS[start] = true;
        recordDFS.add(start); //방문 기록
        
        for(int next : graph[start]) {
            if(!visitedDFS[next]) {
                dfs(next); //dfs로 돌아다니기
            }
        }
    }
    
    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visitedBFS[start] = true;
        recordBFS.add(start); //방문 기록
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int next : graph[current]) {
                if(!visitedBFS[next]) {
                    visitedBFS[next] = true;
                    recordBFS.add(next);
                    queue.offer(next);
                }
            }
        }
    }
    
}