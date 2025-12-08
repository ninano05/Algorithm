import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(br.readLine());
        
        for(int i=0;i<num;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
            bw.write(sum+"\n");
        }
        bw.flush();
        
        br.close();
        bw.close();
    }
}