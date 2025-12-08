import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        bw.write(compare(a, b));
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    public static String compare(int a, int b) {
        if(a > b)
            return ">";
        else if (a < b)
            return "<";
        else return "==";
    }
}