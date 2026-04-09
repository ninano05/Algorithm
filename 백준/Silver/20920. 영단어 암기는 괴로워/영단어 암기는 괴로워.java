import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            String word = br.readLine();
            if(word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) ->{
            int cmp1 = Integer.compare(map.get(b), map.get(a));
            if(cmp1 != 0) return cmp1; // 빈도 같지 않으면 내림차순 반환
            
            int cmp2 = Integer.compare(b.length(), a.length());
            if(cmp2 != 0 ) return cmp2; // 길이 같지 않으면 내림차순 반환
            
            return a.compareTo(b); // 빈도, 길이가 모두 같으면 사전 순 반환
        });
        // 순서대로 출력
        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}