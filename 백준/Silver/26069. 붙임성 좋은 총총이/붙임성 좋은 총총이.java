import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 해시 셋으로 만난 사람들 이름 적기
        // 해시 셋에 둘 중 하나의 이름이 있다면, 다른 한 사람도 추가
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>(); // 무지개 댄스 명단
        set.add("ChongChong"); // 총총이 추가하기

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();

            if(set.contains(a) || set.contains(b)) { // 둘 중 하나라도 명단에 있다면
                set.add(a);
                set.add(b); // 중복은 알아서 처리 됨
            }
        }
        sb.append(set.size());
        System.out.print(sb);
        br.close();
    }
}