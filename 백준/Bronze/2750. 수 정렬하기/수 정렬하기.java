import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 배열 입력
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 삽입 정렬 (선택한 값이 들어갈 자리 찾기)
        for(int i=1; i<N; i++) {
            int key = arr[i];
            int j = i-1;

            while(j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j --;
            }
            arr[j+1] = key;
        }

        for(int i=0; i<N; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}