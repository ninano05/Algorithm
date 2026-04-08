import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 진짜로 돌리는 게 아니다.
        // 기존 행렬에서 어디서부터 읽어올지 결정하는 거다.

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            // 행렬 입력
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(t).append("\n");
            for(int i=0; i<N; i++) {
                StringBuilder sb90 = new StringBuilder();
                StringBuilder sb180 = new StringBuilder();
                StringBuilder sb270 = new StringBuilder();
                // 90도
                for(int j=0; j<N; j++) {
                    sb90.append(matrix[N-1-j][i]);
                    sb180.append(matrix[N-1-i][N-1-j]);
                    sb270.append(matrix[j][N-1-i]);
                }
                sb.append(sb90).append(" ").append(sb180).append(" ").append(sb270).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}