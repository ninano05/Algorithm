import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int series = 1; // 몇번 째 시리즈인지 카운트
        int title = 666; // 1번 째 시리즈는 666이다.

        // 무식하게 돌려보기~
        // 영화는 최소 666부터 시작한다 ~
        while(series < N) {
            title ++;
            if(String.valueOf(title).contains("666")) {
                series ++;
            }
        }
        bw.write(title+"");
        bw.flush();
        bw.close();
        br.close();
    }
}