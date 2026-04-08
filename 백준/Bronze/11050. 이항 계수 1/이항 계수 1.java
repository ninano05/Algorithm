import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        // 이항 계수 -> 조합으로 구하기
        int bc = 1;
        for(int i=1; i<=a-b; i++) {
            bc = bc*(a-i+1)/i;
        }
        sb.append(bc);
        System.out.print(sb);
        br.close();
    }
}