import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int row = 0; // 초기 상태

        // 한줄에 생기는 점의 개수를 계산한다.
        for(int i=0; i<N; i++) {
            row = (1 << N)+1;
        }
        bw.write((int)Math.pow(row,2)+""); // Math.pow()는 double 타입으로 반환 된다. 
        bw.flush();
        bw.close();
        br.close();
    }
}