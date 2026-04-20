import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 빨리 인출하는 사람이 앞으로 가야, 뒤에 대기 시간이 짧아진다.
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int[] time = new int[N];
        for(int i=0; i<N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순으로 정렬하기
        Arrays.sort(time);

        int res = 0; // 모든 사람이 인출하는데 걸리는 시간
        int wait = 0; // 한 사람 당 대기 시간
        // 걸리는 시간의 합
        for(int i=0; i<N; i++) {
            wait += time[i]; // 자기 뽑는데 걸리는 시간 더하기
            res += wait; // 인출 시간에 추가
        }

        sb.append(res);
        System.out.print(sb);
        br.close();
    }
}