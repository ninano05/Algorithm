import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder a = new StringBuilder(st.nextToken());
        StringBuilder b = new StringBuilder(st.nextToken());
        
        int conA = Integer.parseInt(a.reverse().toString());
        int conB = Integer.parseInt(b.reverse().toString());
        
        bw.write(Math.max(conA, conB)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}