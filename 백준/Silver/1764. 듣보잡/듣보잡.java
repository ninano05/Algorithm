import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //듣
        int M = Integer.parseInt(st.nextToken()); //보
        Set<String> set = new HashSet<>(); // 듣도 못한 사람
        for(int i=0; i<N; i++) { //듣도 못한 사람 입력
            set.add(br.readLine());
        }
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        // 보도 못한 사람 입력 & 비교하여 중복 출력
        for(int i=0; i<M; i++) {
            String name = br.readLine();
            if(set.contains(name)) {
                count++;
                list.add(name);
            }
        }
        // 정렬
        Collections.sort(list);
        sb.append(count).append("\n");
        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}