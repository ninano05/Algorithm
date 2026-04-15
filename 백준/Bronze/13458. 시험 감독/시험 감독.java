import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 시험장 개수
        int[] A = new int[N]; // 각 시험장의 응시자 수 배열
        // 각 시험장 응시자 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int B = Integer.parseInt(st.nextToken()); // 총 감독
        int C = Integer.parseInt(st.nextToken()); // 부 감독

        long viewer = 0; // 총 감독관 수

        for(int i=0; i<N; i++) {
            // 총감독은 무조건 1명만 포함해야 함
            if(A[i] <= B) { // 총감독으로 충분한 경우
                viewer += 1;
            } else { // 부감독이 필요한 경우
                viewer += (1 + (int) Math.ceil(((double)A[i]-B)/C));
            }
        }
        sb.append(viewer);
        System.out.print(sb);
        br.close();
    }
}