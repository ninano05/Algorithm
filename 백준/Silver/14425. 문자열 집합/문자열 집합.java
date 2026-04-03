import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        // 집합 s 입력
        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }
        int count = 0;
        // M개의 문자열 집합 s 포함 검사
        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(set.contains(s)) count++;
        }
        sb.append(count);
        System.out.println(sb);
        br.close();
    }
}