import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int year = Integer.parseInt(br.readLine());
        int gap = 2541 - 1998;
        
        bw.write((year-gap)+"\n");
        bw.flush();
        
        br.close();
        bw.close();        
    }
}