import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] card = new int[N];
        // 상근이 카드 입력
        for(int i=0; i<N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new LinkedHashMap<>();
        // 비교군 카드 입력
        for(int i=0; i<M; i++) {
            map.put(Integer.parseInt(st.nextToken()), 0);
        }
        // 카드 비교하기
        for(int i=0; i<N; i++) {
            if(map.containsKey(card[i])) { // 키가 있는지 검사
                map.put(card[i], 1); // 있으면 값을 1로 덮어씌움
            }
        }
        // 출력
        for(int n : map.keySet()) {
            sb.append(map.get(n)).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

}