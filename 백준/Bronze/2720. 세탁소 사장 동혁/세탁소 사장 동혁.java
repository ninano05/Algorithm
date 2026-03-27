import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 가장 큰 단위로 나눈다.
        // 나눈 나머지에 대해서 다음 단위로 나눈다.
        // 위 과정을 반복해서 거스름돈 개수를 출력한다.
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int m = Integer.parseInt(br.readLine());
            int q = m/25;
            int d = (m%25)/10;
            int n = ((m%25)%10)/5;
            int p = (((m%25)%10)%5);
            bw.write(q+ " "+d+" " +n+" "+p+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}