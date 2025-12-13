import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0;i<n;i++) {
            for(int j=(n-1)-i;j>0;j--)
                bw.write(" ");
            for(int k=0;k<i+1;k++)
                bw.write("*");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}