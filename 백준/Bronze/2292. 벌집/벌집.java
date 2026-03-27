import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int pass = 1; // 지나가는 방 개수
        int room = 1; // 최대 방 번호 초기 값
        boolean visit = true;

        // 6, 12, 18 => 1을 기준으로 했을 때, 줄별로 방이 6의 배수 개수로 늘어남
        // 6*0+6*1+6*2+6*3 => 6(0+1+2+3)...
        while(visit) {
            if(N<=room) { // 가고자 하는 방 N이 최대 방 번호 보다 작을 경우
                visit = false; // 반복 종료
            } else{
                room += (6*pass); // 최대 방 번호 업데이트
                pass ++; // 방 줄 증가
            }
        }

        bw.write((pass)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}