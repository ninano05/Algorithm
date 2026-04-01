import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 영화 시리즈
        int count = 1;
        int title = 666;

        while(count < n) {
            title += 1;
            String sTitle = String.valueOf(title);
            if(sTitle.contains("666")) {
                count++;
            }
        }

        bw.write(title+"");
        bw.flush();
        bw.close();
        br.close();
    }
}