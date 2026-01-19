import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int[] tempArr = new int[b-a+1];
            for(int j=0; j<b-a+1; j++) {
                tempArr[j] = arr[b-j-1];
            }
            for(int j=0; j<b-a+1; j++) {
                arr[a-1+j] = tempArr[j];
            }
        }
        
        for(int i=0; i<n; i++) 
            bw.write(arr[i]+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}