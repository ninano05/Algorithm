import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // ex) 5-1+50-10+50-5+80
        // 이렇게 나오는 경우 - 빼고 연산을 모두 먼저 실행
        // ex) 5-(1+50)-(10+50)-(5+80)

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int res = 0;
        // 처음 값은 더하기 연산
        res += plus(st.nextToken());
        // 빼기 연산 시작
        while(st.hasMoreTokens()) {
            res -= plus(st.nextToken());
        }
        sb.append(res);
        System.out.print(sb);
        br.close();
    }

    // 더하기만 하는 함수
    public static int plus(String s) {
        StringTokenizer st = new StringTokenizer(s, "+");
        int res = 0;
        while(st.hasMoreTokens()) {
            res += Integer.parseInt(st.nextToken());
        }
        return res;
    }
}