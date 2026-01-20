import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder(br.readLine());
        int sum = 0;
        
        for(int i=0; i<sb.length(); i++) {
            sum += getTime(sb.charAt(i));
        }
        
        bw.write(sum+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static int getTime(char ch) {
        int num = ch - 'A';
        if(num<3)
            return 3;
        else if (num>2 && num<6)
            return 4;
        else if (num>5 && num<9)
            return 5;
        else if (num>8 && num<12)
            return 6;
        else if (num>11 && num<15)
            return 7;
        else if (num>14 && num<19)
            return 8;
        else if (num>18 && num<22)
            return 9;
        else if (num>21 && num<26)
            return 10;
        else return 2;
    }
}