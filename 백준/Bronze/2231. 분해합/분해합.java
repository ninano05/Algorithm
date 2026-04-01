import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int min = 0; // 조건 만족 안하는 경우 초기값임(만족할 때만 값 업데이트)
        int start = Math.max(0, N-String.valueOf(N).length()*9); // N의 자릿수가 999같이 가장 큰 경우에, 생성자가 작아지기 때문

        for(int i=start; i<=N; i++) {
            int sum = i;
            int temp = i;

            while(temp != 0) {
                sum += temp%10;
                temp = temp/10;
            }
            if(sum == N) { // 조건을 만족하면 저장하고 빠져 나가기
                min = i;
                break;
            }
        }
        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }
}