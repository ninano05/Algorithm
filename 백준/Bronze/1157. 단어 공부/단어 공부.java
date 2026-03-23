import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        bw.write(solution(s)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static Character solution(String s) {
        //string을 모두 대문자 or 소문자로 변경
        String su = s.toUpperCase();
        // 해시 사용하기
        HashMap<Character, Integer> map = new HashMap<>();
        // 해시로 가장 문자별 개수 구하기
        for(int i=0; i<su.length(); i++) {
            map.put(su.charAt(i), map.getOrDefault(su.charAt(i), 0)+1);
        }
        int max = 0;
        Character c = '?';
        for(Character n : map.keySet()) {
            if(map.get(n) > max) {
                max = map.get(n);
                c = n;
            } else if (map.get(n) == max){
                c = '?';
            }
        }
        return c;
    }
}