import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            int len = (int)Math.pow(3, N);

            String res = repeat(len);
            sb.append(res).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    // 재귀 돌리는 함수
    public static String repeat(int len) { // 전체 길이 넣어주기
        if (len == 1) return "-"; // N=0일때, 3의 0제곱 처리
        else { // 3보다 큰 경우
            // 다음 문자 처리 단위
            int next = len/3;
            // 공백 만들기
            StringBuilder blank = new StringBuilder();
            for(int i=0; i<next; i++) {
                blank.append(" ");
            }
            return repeat(next)+blank+repeat(next);
        }
    }
}