import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 영단어 입력
        String word = br.readLine();
        
        // 영단어 길이 출력
        bw.write(word.length()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}