import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());        
        
        // 테스트 케이스 n번 입력 받기
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder(st.nextToken());
            StringBuilder p = new StringBuilder();
            
            // 새로운 문자열 만들기
            for(int j=0; j<sb.length();j++) {
                // r번 반복
                for(int k=0; k<r; k++)
                    p.append(sb.charAt(j));
            }
            bw.write(p+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}