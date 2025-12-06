import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        double div = Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken());
        
        bw.write(div+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}