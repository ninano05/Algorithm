import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); //행
        int N = Integer.parseInt(st.nextToken()); //열
        board = new char[M][N]; // 보드판
        int answer = Integer.MAX_VALUE;

        // 보드판 원래 색깔 입력
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            for(int j=0; j<N; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        // 시작 위치를 반복문으로 조절해가며 8*8 영역 탐색하기
        for(int r=0; r<=M-8; r++) {
            for(int c=0; c<=N-8; c++) { // 시작 위치는 설정 완료
                answer = Math.min(answer, paint(r,c)); // 최소 칠하는 경우 반영
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
    // 칠하는 경우의 수 계산 함수
    public static int paint(int r, int c) {
        int answer = 0;
        char[] color = {'B', 'W'}; // 색은 2개뿐
        int colorChoice = 0;

        // 반복문으로 이전과 다음색을 비교해서 칠하는 경우를 구한다.
        // 시작 위치가 검정인 경우
        for(int i=r; i<r+8; i++) {
            for(int j=c; j<c+8; j++) {
                if(board[i][j] != color[colorChoice]){
                    answer++;
                }
                colorChoice = (colorChoice+1) % 2; // 다음 색깔로 업데이트
            }
            colorChoice = (colorChoice+1)%2; // 행이 바뀌면 색 한번 더 업데이트
        }
        
        // 생각하기)) 현재 체스판은 8*8 64칸으로 고정되어 있음.
        // 검정색으로 시작하는 경우 a 만큼 수정해야 한다면,
        // 하얀색으로 시작하는 경우에는 64-a 칸 만큼 수정하면 됨. (모두 반대이기 때문)
        // 이렇게 하면 하얀색으로 칠하는 경우는 계산 안 해도 됨.
        answer = Math.min(answer, 64-answer);
        return answer;
    }
}