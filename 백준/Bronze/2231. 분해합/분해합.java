import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = 0; // 생성자가 없는 경우 -> 있다면 생성자로 바꾸기

        for(int i=1; i<N; i++) {
            int sum = i;
            int temp = i;
            while(temp > 0) {
                sum = sum + temp % 10;
                temp = temp / 10;
            }
            if(sum == N){
                M = i; // M을 1부터 가정하고 커지기 때문에, 찾는 순간 종료하면 가장 작은 값이다.
                break;
            }
        }

        bw.write(M+"");
        bw.flush();
        bw.close();
        br.close();
    }
}