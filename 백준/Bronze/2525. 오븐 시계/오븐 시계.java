import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());
        
        bw.write(getH(h,m,time)+" "+getM(m,time));
        bw.flush();
        
        br.close();
        bw.close();
    }
    
    public static int getH(int h, int m, int time) {
        int hour = h + (m+time)/60;
        if (hour<24)
            return hour;
        else return hour-24;
    }
    
    public static int getM(int m, int time) {
        return (m+time)%60;
    }
}