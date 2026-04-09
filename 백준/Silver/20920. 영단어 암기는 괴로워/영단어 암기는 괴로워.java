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
        ArrayList<String> list = new ArrayList<>();
        for(String s: map.keySet()) {
            list.add(s);
        }
        Collections.sort(list, (a, b) ->{
            if(map.get(a) == map.get(b)) {
                if(a.length() == b.length()) return a.compareTo(b);
                return b.length() - a.length();
            }
            return map.get(b) - map.get(a);
        });
        // 순서대로 출력
        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}