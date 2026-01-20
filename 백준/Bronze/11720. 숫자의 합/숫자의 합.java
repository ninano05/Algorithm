import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(br.readLine());
        int sum = 0;
        
        for(int i=0; i<n; i++) {
            sum += sb.charAt(i) - '0';
        }
        
        bw.write(sum+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}