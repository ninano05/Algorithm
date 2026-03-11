import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 상근이 카드 입력
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        // M개의 카드 입력
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        // m개의 카드 검사하기
        for(int i=0;i<m;i++) {
            if(set.contains(Integer.parseInt(st.nextToken()))) {
                bw.write(1+" ");
            } else {
                bw.write(0+ " ");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}