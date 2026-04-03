import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Set<String> set = new HashSet<>(); // 서로 다른 문자열 보관

        // 문자열 조합 완전 탐색
        for(int l=1; l<=s.length(); l++) { // l: 만들 문자열의 길이
            for(int i=0; i<=s.length()-l; i++) { // i: 시작 위치
                set.add(s.substring(i, i+l)); // 범위만큼 자르기 (end는 미포함)
            }
        }

        sb.append(set.size());
        System.out.print(sb);
        br.close();
    }
}