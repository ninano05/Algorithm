import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[10];
        int count = 0;
        int[] target = new int[10];
        Arrays.fill(target, -1);
        
        for(int i=0; i<10; i++) {
            arr[i] = (Integer.parseInt(br.readLine())%42);
        }
        
        for(int i=0; i<10; i++) {
            int sum = 0;
            for(int a : target) {
                if(a == arr[i])
                    sum ++;
                else continue;
            }
            if(sum == 0) {
                count++;
                target[i] = arr[i];
            } else continue;
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}