import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // testCase
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0;i<testCase;i++) {
            // 의상 개수
            int n = Integer.parseInt(br.readLine());
            bw.write(getEnableDay(n, br)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    // 의상 개수와 종류에 따라 옷 입을 수 있는 날짜
    public static Integer getEnableDay(int n, BufferedReader br) throws Exception {
        // 의상의 종류별 개수 파악
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            String type = st.nextToken();
            map.put(type, map.getOrDefault(type, 0)+1);
        }   
        int answer = 1;
        for(String c : map.keySet()) {
            // 종류별로 하나씩 택해서 입는 경우 & 아예 안 입는 경우(+1)
            answer = answer * (map.get(c)+1);
        }
        // 모든 걸 안 입는 경우 제외
        answer = answer -1;
        return answer;
    }
    
}