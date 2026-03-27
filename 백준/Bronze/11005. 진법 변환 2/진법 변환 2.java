import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder answer = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // B로 나눈 나머지가 각 자리 숫자
        // 일의자리 수 부터 구하게 됨
        // stringBuilder 사용시 append()는 뒤로, insert()는 위치를 지정해서 넣어준다.
        while(!(N == 0)) {
            int num = N%B;
            if(num>=0 && num<=9) { // 숫자인 경우
                answer.append(num);
            } else { // 문자인 경우
                answer.append((char)(num-10+'A'));
            }
            N = N / B; // 다음 자리 수 계산을 위해 현재 계산한 자리 버림
        }
        bw.write(answer.reverse().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}