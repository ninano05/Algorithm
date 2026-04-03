import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        // A 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<A; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        // B입력 (중복은 제거, 다른 숫자는 추가)
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<B; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        sb.append(set.size());
        System.out.println(sb);
        br.close();
    }
}