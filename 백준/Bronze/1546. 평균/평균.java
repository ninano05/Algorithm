import java.util.*;
import java.io.*;
import java.lang.*;


public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        int max = 0;
        int sum = 0;
        double avg = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int num : score) {
            if(max < num) max = num;
        }
        
        for(int i=0; i<n; i++) {
            sum += score[i];
        }
        
        avg = ((double)sum/max*100)/(double)n;
        
        bw.write(avg+"\n");
        br.close();
        bw.flush();
        bw.close();
        
    }
}