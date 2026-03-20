import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> list;
    static int apart; // 아파트 단지 수
    static int n; // 지도 가로 세로 크기

    // 상하좌우 이동 로직
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 지도의 크기 입력
        n = Integer.parseInt(br.readLine());
        // 변수 초기화
        map = new int[n][n];
        visited = new boolean[n][n];
        //집 주소 반영
        for(int i=0; i<n; i++) { // i는 y좌표
            String s = br.readLine();
            for(int k=0;k<n;k++) { // k는 x좌표
                map[k][i] = Integer.parseInt(s.charAt(k) + "");
            }
        }

        list = new ArrayList<>(); // 단지 별 집의 수 저장
        int count = 0; // 총 단지 수

        for(int j=0;j<n;j++) {
            for(int l=0;l<n;l++) {
                apart = 0; // 개수 구한 아파트 초기화
                if(map[j][l]==1&&!visited[j][l]) {
                    dfs(j, l); // dfs로 단지 돌기
                    list.add(apart); // 돌아다닌 단지 수 저장
                    count ++; // 총 단지 수 업데이트
                }
            }
        }
        //오름차순
        Collections.sort(list); // 오름차순으로 정렬 (내림차순은 Collections.reverseOrder()옵션 주기

        bw.write(count+"\n");
        for(int a: list) {
            bw.write(a+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        apart ++;

        // 상하좌우 돌기
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n) {
                if(map[nx][ny]==1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }

    }
}