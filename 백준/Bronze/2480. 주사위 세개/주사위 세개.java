import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        bw.write(getPrice(a,b,c)+"\n");
        bw.flush();
        
        br.close();
        bw.close();
        
    }
    public static int getPrice(int a, int b, int c) {
        if(a==b&&b==c)
            return 10000+a*1000;
        else if(a==b&&b!=c)
            return 1000+a*100;
        else if(b==c&&c!=a)
            return 1000+b*100;
        else if(a==c&&a!=b)
            return 1000+c*100;
        else return Math.max(Math.max(a,b),c)*100;
    }
}