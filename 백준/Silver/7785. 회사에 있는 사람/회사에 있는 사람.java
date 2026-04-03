import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashSet<String> set = new HashSet<>();
        // 출근한 사람 리스트만 저장
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String state = st.nextToken();
            if(state.equals("enter")) set.add(name);
            else if(state.equals("leave")) {
                set.remove(name);
            }
        }
        // 사전 순 역순 정렬
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        // 출력
        for(String s: list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}