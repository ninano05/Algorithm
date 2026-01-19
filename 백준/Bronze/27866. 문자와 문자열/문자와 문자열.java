import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String word = br.readLine();
        int i = Integer.parseInt(br.readLine());
        
        bw.write(word.charAt(i-1)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}