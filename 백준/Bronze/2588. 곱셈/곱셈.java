import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int x = b/100;
        int y = (b%100)/10;
        int z = (b%10);
        
        bw.write((a*z)+"\n");
        bw.write((a*y)+"\n");
        bw.write((a*x)+"\n");
        bw.write((a*b)+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}