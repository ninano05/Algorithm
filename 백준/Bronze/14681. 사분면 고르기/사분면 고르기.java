import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        
        bw.write(getQuad(x, y));
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    public static String getQuad(int x, int y) {
        if(x>0&&y>0)
            return "1";
        else if(x<0&&y>0)
            return "2";
        else if(x<0&&y<0)
            return "3";
        else return "4";
    }
}