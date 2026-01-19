import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char ch = br.readLine().charAt(0);
        int ascii = (int)ch;
        
        bw.write(ascii+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}