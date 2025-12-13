import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = arr[0];
        int max = arr[0];
        
        for(int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        bw.write(min+" "+max);
        bw.flush();
        bw.close();
        br.close();
    }
}