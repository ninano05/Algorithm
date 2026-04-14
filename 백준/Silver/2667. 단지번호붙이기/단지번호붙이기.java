import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited; // 방문 여부
    static int[][] house; // 1:집, 0: 집 아님
    static int curApartment; // 현재 단지 내 집 개수
    static int N; // 지도 한 변

    // 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0}; // 행 이동
    static int[] dc = {0, 0, -1, 1}; // 열 이동

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        house = new int[N][N];

        // 집 정보 받아오기
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                house[i][j] = s.charAt(j) - '0'; // 숫자로 집인지 아닌지 표시
            }
        }
        int apartment = 0; // 총 단지 수
        List<Integer> apartNum = new ArrayList<>(); // 아파트 개수 기록
        
        // dfs로 돌기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && house[i][j] == 1) { //아직 방문 안했고, 집이라면
                    curApartment = 0; // 단지 돌기 전에 개수 초기화
                    dfs(i,j); // 주변 단지 싹 다 방문하기
                    apartment ++; // 단지 수 증가
                    apartNum.add(curApartment); // 단지 내 아파트 개수 기록
                }
            }
        }
        // 아파트 단지 내 아파트 개수 오름차순 정렬
        apartNum.sort((a,b) -> a-b);
        // 출력하기
        sb.append(apartment).append("\n");
        for(int n : apartNum) {
            sb.append(n).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }

    public static void dfs(int row, int col) { // 시작 지점
        visited[row][col] = true; // 방문 표시
        curApartment ++; // 아파트 개수 추가

        for(int i=0; i<4; i++) { // 연결된 집은 최대 상,하,좌,우 4개이기 때문
            int nextRow = row+dr[i];
            int nextCol = col+dc[i];

            if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol <N) { // 지도 범위 벗어나면 안 됨
                if(!visited[nextRow][nextCol] && house[nextRow][nextCol] == 1) { // 방문 안했고, 집이라면
                    dfs(nextRow, nextCol); // 다음 방문
                }
            }
        }
    }
}