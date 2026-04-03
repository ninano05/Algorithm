import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>(); // 번호로 찾기
        Map<String, Integer> revMap = new HashMap<>(); // 이름으로 찾기
        // 포켓몬 도감 입력 받기
        for(int i=1; i<=N; i++) {
            String name = br.readLine();
            map.put(i, name);
            revMap.put(name, i);
        }

        // 문제 입력 받기
        for(int i=0; i<M; i++) {
            String quiz = br.readLine();
            int c = quiz.charAt(0) - '9';
            if(c <= 0) { // 숫자 입력
                sb.append(map.get(Integer.parseInt(quiz))).append("\n");
            } else  { // 문자 입력
                sb.append(revMap.get(quiz)).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}