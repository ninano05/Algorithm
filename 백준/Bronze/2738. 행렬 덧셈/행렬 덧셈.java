import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[n][m];
        int[][] result = new int[n][m];

        // A 입력
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++) {
                matrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // B 주어짐
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<m;j++) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 덧셈하기
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        // 출력
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                bw.write(result[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}