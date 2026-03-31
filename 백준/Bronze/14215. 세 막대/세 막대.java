import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int max = Math.max(Math.max(a, b),c);
        int sum = a+b+c;
        int twoSum = sum-max; // 작은 두 변의 길이 합
        int answer;

        if(twoSum > max) { // 작은 두 변의 합이 최대 길이 변 보다 큰 경우
            answer = sum;
        } else {
            answer = twoSum*2 -1;
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
