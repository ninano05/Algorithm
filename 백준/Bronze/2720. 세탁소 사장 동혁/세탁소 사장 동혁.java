import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] unit = new int[]{25, 10, 5, 1}; // 돈 단위 배열
        // 가장 큰 단위로 나눈다.
        // 나눈 나머지에 대해서 다음 단위로 나눈다.
        // 위 과정을 반복해서 거스름돈 개수를 출력한다.
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int m = Integer.parseInt(br.readLine());
            for(int j=0;j<unit.length;j++) {
                bw.write(m/unit[j]+ " ");
                m %= unit[j];
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}