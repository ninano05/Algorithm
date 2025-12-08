import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int year = Integer.parseInt(br.readLine());
        
        bw.write(checkYear(year));
        bw.flush();
        
        br.close();
        bw.close();
    }
    
    public static String checkYear(int year) {
        if((year%400)==0)
            return "1";
        else if ((year%100)==0)
            return "0";
        else if ((year%4)==0)
            return "1";
        else return "0";
    }
}