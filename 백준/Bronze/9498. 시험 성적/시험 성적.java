import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int score = Integer.parseInt(br.readLine());
        
        bw.write(getGrade(score));
        bw.flush();
        
        br.close();
        bw.close();
    }
    
    public static String getGrade(int score) {
        if(score>=90)
            return "A";
        else if (score>=80&&score<90)
            return "B";
        else if (score>=70&&score<80)
            return "C";
        else if (score>=60&&score<70)
            return "D";
        else return "F";
    }
}