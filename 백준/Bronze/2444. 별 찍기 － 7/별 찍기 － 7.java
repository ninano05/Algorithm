import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        // 위에 별
        for(int i=1; i<n+1; i++) {
            for(int j=0; j<n-i; j++){
                bw.write(" ");
            }
            for(int k=0; k<2*i-1; k++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        // 아래 별
        
        for(int i=n-1; i>0; i--) {
            for(int j=0; j<n-i; j++){
                bw.write(" ");
            }
            for(int k=0; k<2*i-1; k++) {
                bw.write("*");
            }
            bw.write("\n");
        } 
        bw.flush();
        br.close();
        bw.close();
    }
}