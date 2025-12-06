import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int mul = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        
        bw.write(mul+"\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
}