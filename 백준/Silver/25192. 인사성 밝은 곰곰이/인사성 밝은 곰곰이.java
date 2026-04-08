import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // HashSet으로 중복으로 입력된 경우는 하나로 친다.
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>(); // 곰곰 채팅 명단 관리
        int gomgom = 0; // 곰곰이 등장한 횟수

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(s.equals("ENTER")) {
                gomgom += set.size();
                set.clear(); // 이전 채팅 인사 기록 초기화
            } else {
                set.add(s);
            }
        }
        // 마지막 기록도 더하기
        gomgom += set.size();
        sb.append(gomgom);
        System.out.print(sb);
        br.close();
    }
}