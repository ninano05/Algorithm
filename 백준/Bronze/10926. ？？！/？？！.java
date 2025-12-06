import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String id = br.readLine();
        
        bw.write(id+"??!");
        bw.flush();
        
        br.close();
        bw.close();
    }
}