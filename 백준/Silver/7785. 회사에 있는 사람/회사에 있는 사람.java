import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // treeSet은 넣을 때 자동 정렬 (기본 오름차순 / 내림차순 옵션 지정 가능)
        Set<String> set = new TreeSet<>(Collections.reverseOrder());
        // 출근한 사람 리스트만 저장
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String state = st.nextToken();
            if(state.equals("enter")) set.add(name); // 출근하면 이름 저장
            else if(state.equals("leave")) { // 퇴근하면 이름 빼버리기
                set.remove(name);
            }
        }
        // 출력
        for(String s: set) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}