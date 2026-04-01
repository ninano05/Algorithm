import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken()); // 행
        int n = Integer.parseInt(st.nextToken()); // 열
        int min = Integer.MAX_VALUE;

        board = new char[m][n]; // 보드 판
        // 보드판 채우기
        for(int i=0; i< m; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for(int row=0; row<=m-8; row++) { // 사작 row
            for(int col=0; col<=n-8; col++) { // 시작 col
                min = Math.min(min, paintChess(row, col));
            }
        }

        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int paintChess(int row, int col) {
        int count = 0;
        char[] color = {'B', 'W'};
        int colorSelect = 0;

        // 검정색으로 시작하는 경우
        for(int i=row; i<row+8; i++) {
            for(int j=col; j<col+8; j++) {
                if(board[i][j] != color[colorSelect]) {
                    count ++;
                }
                colorSelect = (colorSelect + 1) % 2; // 다음 순서 컬러로 변경
            }
            colorSelect = (colorSelect + 1) % 2; // 줄바꿈시에는 다시 컬러 한 번 더 변경
        }

        // 흰색으로 시작하는 경우 (검정색과 반대) 64 - count
        count = Math.min(count, 64-count);

        return count;
    }
}