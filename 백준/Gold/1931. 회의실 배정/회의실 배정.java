import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] meeting = new int[N][2]; // 0: 시작시간, 1: 끝나는 시간

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 다중 정렬 (시작시간으로 정렬 -> 끝나는 시간으로 정렬)
        // 끝나는 시간이 짧은 것 중에 시작 시간이 빠른 걸 골라야함
        // 그래야 최대한 많은 회의를 우겨넣기 가능
        // 시작 시간이 빠른 걸 우선하면 끝나는 시간을 보장 못해서 회의 하나만 할 수도...
        Arrays.sort(meeting, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // 회의 선택하기 (완탐)
        int cur = meeting[0][1]; // 처음 회의 초기값(끝나는 시간)
        int res = 1; // 회의 개수
        for(int i=1; i<N; i++) { // 회의 정렬해 놨기 때문에, 그냥 앞에서부터 접근
            if(meeting[i][0] >= cur) { // 끝나는 시간과 다음 회의 시작 시간이 같거나 빠른 경우
                cur = meeting[i][1]; // 회의 끝나는 시간 업데이트
                res ++; // 회의 개수 추가
            }
            // 현재 미팅의 끝나는 시간보다 시작 시간이 빠르면  다음 순서로 넘어가기
        }
        sb.append(res);
        System.out.print(sb);
        br.close();
    }
}