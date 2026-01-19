import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 숫자 입력 받기
        int n = Integer.parseInt(br.readLine());
        
        // 문자열 입력 및 출력
        for(int i=0; i<n; i++) {
            String word = br.readLine();
            bw.write(""+word.charAt(0)+word.charAt(word.length()-1)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}