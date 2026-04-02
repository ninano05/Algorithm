import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num = -1;

        loop:
        // 어차피 나누고 남은 나머지면, -1을 return 하기에, 최대 개수에 나머지 고려하지 않는다. n/3 가능
        for(int s=0; s<=N/3; s++) { // small bag
            for(int b=0; b<=N/5; b++){ // big bag
                int weight = 3*s+5*b;
                if(weight == N) {
                    num = s+b; // 5Kg 짜리가 많을 때가, 가장 적은 가방 개수 => 바로 종료하기
                    break loop;
                }
            }
        }

        bw.write(num+"");
        bw.flush();
        bw.close();
        br.close();
    }
}