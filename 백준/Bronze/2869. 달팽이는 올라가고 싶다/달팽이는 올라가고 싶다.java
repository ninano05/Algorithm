import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int len = A-B; // 하루 이동 거리
        int day; // 최종 걸린 날

        // 마지막 날에는 자지 않더라도 A 만큼 이동할 수 있음
        V-=A;
        // 즉 V에서 A를 뺀 값에서 하루 이동거리에 대한 몫을 구하면 됨 (나머지가 없고 몫이 0인 경우 제외)

        // 마지막 날인 A 이동값 1 더해줘야 함
        if(V%len==0) { // 나머지가 없는 경우
            day = V/len + 1;
        } else { // 나머지가 있는 경우
            day = (V+len-1)/len + 1; // 날짜 올림 필요
        }

        bw.write(day+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
