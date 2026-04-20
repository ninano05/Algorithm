import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // +와 -를 사용해서 값을 최소로 만들기 위해서는
        // - 뒤로 나오는 애들을 모두 더해 놓아야함
        // ex) 5-1+50-10+50-5+80
        // 이렇게 나오는 경우 - 빼고 연산을 모두 먼저 실행
        // ex) 5-(1+50)-(10+50)-(5+80)

        String s = br.readLine();

        StringBuilder part = new StringBuilder();
        boolean minus = false; // -가 나왔는지 여부
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '-') {
                if (minus) { // 이전에 - 부호가 나왔을 경우
                    res -= plus(String.valueOf(part));
                    part.setLength(0); // part 초기화
                } else { // 이전에 - 부호가 안 나왔을 경우
                    res += plus(String.valueOf(part));
                    part.setLength(0); // part 초기화
                    minus = true;
                }
            } else {
                part.append(c);
            }
        }
        // 마지막꺼 빼주기 전체 +인 경우 처리
        if(minus) { // -가 나왔던 경우
            res -= plus(String.valueOf(part));
        } else { // - 가 안 나왔던 경우
            res += plus(String.valueOf(part));
        }

        sb.append(res);
        System.out.print(sb);
        br.close();
    }

    public static int plus(String s) {
        StringBuilder curNum = new StringBuilder();
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+') {
                res += Integer.parseInt(String.valueOf(curNum));
                curNum.setLength(0);
            } else {
                curNum.append(c);
            }
        }
        // 마지막 숫자 더하기
        res += Integer.parseInt(String.valueOf(curNum));
        return res;
    }
}