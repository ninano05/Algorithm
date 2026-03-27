import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int line = 1; // 대각선 시작 번호(몇번째 대각선인가)
        int maxNum = 1; // 대각선 줄에 해당하는 최대 번호

        // 대각선으로 진행 됨
        // 대각 선의 요소는 1, 2, 3, 4 ... i번째 줄일 때 i개의 요소를 가지고 있음
        // i번째 대각선의 분모: i로 시작, 1씩 감소, 1로 종료
        // 대각선 내에서 분자: 1로 시작, 1씩 증가, i로 종료

        while(X > maxNum) {// 대각선에 속하는 줄 찾기 (대각선 번호가 최대 대각선 번호 보다 작아지면 종료)
            line ++; // 다음 줄로 넘어가기
            maxNum += line; // 최대 번호 증가
        }
        int child;
        int parent;
        if(line%2==0) { // 줄이 짝수인 경우 (앞에서 시작)
            // 분자 구하기 (maxNum - X)한 간격을 line에서 뺀다.
            child = line - (maxNum-X);
            // 분모 구하기 (maxNum - X) 한 간격 만큼 1에서 더한다.
            parent = 1+(maxNum -X);
        } else { // 줄이 홀수인 경우 (뒤에서 시작)
            // 분자 구하기 (maxNum - X)한 간격을 line에서 뺀다.
            parent = line - (maxNum-X);
            // 분모 구하기 (maxNum - X) 한 간격 만큼 1에서 더한다.
            child = 1+(maxNum -X);
        }

        bw.write(child+"/"+parent);
        bw.flush();
        bw.close();
        br.close();
    }
}