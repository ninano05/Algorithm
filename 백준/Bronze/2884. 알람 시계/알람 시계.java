import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        bw.write(getTime(h, m));
        bw.flush();
        
        br.close();
        bw.close();
    }
    
    public static String getTime(int h, int m) {
        if(m>=45)
            return h+" "+(m-45);
        else {
            if(h==0)
                return 23+" "+(15+m);
            else return (h-1)+" "+(15+m);
        }
    }
}