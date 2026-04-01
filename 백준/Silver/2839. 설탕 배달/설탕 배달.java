import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = -1;

        for(int five = n/5; five>=0; five--) {
            int remain = n - (five*5);

            if(remain % 3 == 0) {
                int three = remain/3;
                answer = five + three;
                break;
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}