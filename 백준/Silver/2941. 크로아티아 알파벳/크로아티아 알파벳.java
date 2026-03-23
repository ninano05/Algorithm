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

    public static int solution(String s) {
        int answer = 0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'c') {
                if((i+1)<s.length() && s.charAt(i + 1) == '=' || (i+1)<s.length() && s.charAt(i+1) == '-') { // 배열 초과 고려하기
                    i++; // 두번 스킵
                }
            } else if(s.charAt(i) == 'd') {
                if((i+1)<s.length() && s.charAt(i+1) == '-') { // 배열 초과 고려하기
                    i++; // 두번 스킵
                } else if( (i+2)<s.length() && s.charAt(i+1) == 'z' && s.charAt(i+2) == '=') { // 배열 초과 고려하기
                    i += 2;
                }
            } else if(s.charAt(i) == 'l') {
                if((i+1)<s.length() && s.charAt(i+1) == 'j') {
                    i++; // 두번 스킵
                }
            } else if(s.charAt(i) == 'n') {
                if((i+1)<s.length() && s.charAt(i+1) == 'j') {
                    i++; // 두번 스킵
                }
            } else if(s.charAt(i) == 's' || s.charAt(i) == 'z') {
                if((i+1)<s.length() && s.charAt(i+1) == '=') {
                    i++; // 두번 스킵
                }
            }
            answer ++; // 몇번 건너뛰냐의 차이지 단어는 언제나 더해짐.
        }

        return answer;
    }
}