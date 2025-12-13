import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] student = new int[30];
        Arrays.fill(student, 0);
        
        for(int i=0; i<28; i++){
            int a = Integer.parseInt(br.readLine());
            student[a-1] = 1;
        }
        
        for(int i=0; i<30; i++) {
            if(student[i]==0)
                bw.write((i+1)+"\n");
            else continue;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}