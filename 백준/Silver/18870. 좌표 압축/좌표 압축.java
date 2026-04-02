import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 압축한 뒤 값은 => 입력된 값 중 나보다 작은 녀석들의 개수(똑같은 경우 제외)
        int N = Integer.parseInt(br.readLine());
        int[][] X = new int[N][3]; // [0]: 입력 idx, [1]: 입력한 값, [2]: 나보다 작은 녀석 개수(압축좌표)

        // 좌표 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            X[i][0] = i; // 입력 순서
            X[i][1] = Integer.parseInt(st.nextToken()); // 입력 값
        }

        // 값 기준 좌표 정렬
        Arrays.sort(X, (a,b) -> a[1] - b[1]);

        // 초기값 넣어주기
        int count = 0; // 압축 좌표
        X[0][2] = count;

        // 압축 좌표 채우기
        for(int i=1; i<N; i++) {
            if(X[i][1] != X[i-1][1]) {
                count++; // 다른 값이 되면 압축 좌표 +1
            }
            X[i][2] = count; // 중복된 숫자는 동일한 압축 좌표 가짐
        }

        // 다시 입력 순서로 오름차순 정렬
        Arrays.sort(X, (a,b) -> a[0]-b[0]);

        for(int[] arr : X) {
            bw.write(arr[2]+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}