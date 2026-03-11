import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int answer = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // s 해시 셋으로 입력 받기
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(br.readLine());
        }
        
        //M개의 문자열 입력
            //해시셋에서 contains으로 검사, 있으면 answer+1
        for(int i=0; i<m; i++) {
            String mstr = br.readLine();
            if(set.contains(mstr)){
                    answer ++;
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}