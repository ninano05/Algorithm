import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //상근이 카드 개수
        int n = Integer.parseInt(br.readLine());
        //상근이 카드 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            String num = st.nextToken();
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        //비교군 카드 개수
        int m = Integer.parseInt(br.readLine());
        // 비교군 카드 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<m;i++) {
            String card = st.nextToken();
            // 예외 케이스:상근이 카드가 없을 경우            
            if(map.get(card) == null) {
                bw.write("0 ");
            } else {
                bw.write(map.get(card)+" ");
            } 
        }
        bw.flush();
        bw.close();
        br.close();
    }
}