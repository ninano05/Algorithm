import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[9];
        
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int max = arr[0];
        int index = 0;
        
        for(int i=0; i<arr.length;i++)
            if(max < arr[i]) {
                max = arr[i];
                index = i;
            }      
            else
                continue;
        
        bw.write(max+"\n"+(index+1));
        bw.flush();
        bw.close();
        br.close();
    }
}