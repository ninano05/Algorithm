import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 최소의 기름값이 나오면 미래에 갈 거리를 모두 결제해 놔야 한다.
        // 즉 거꾸로 보면 미래의 거리를 알고 최소 가격으로 결제할 수 있게 된다.
        // 거꾸로 돌아오면서 가격이 상승하기 전의 가격으로 지금까지 돌아온 거리를 모두 결제한다.

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N]; // 맨 앞 0번은 0임 -> cost[0]인덱스까지 가는데, 거리가 0이기때문
        int[] cost = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 거꾸로 생각하기 뒤에서부터 담기
        for(int i=N-1; i>=1; i--) {
            d[i] = Integer.parseInt(st.nextToken());
        }
        // 거꾸로 생각하기 위해서 뒤에서부터 담기
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=N-1; i>=0; i--) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int curDist = 0; // 지금까지 온 거리
        int res = 0; // 최종 비용
        // 다음 가격이 지금보다 비싸지면 지금까지 온 거리의 기름 모두 결제하면 된다.
        for(int i=0; i<N-1; i++) {
            curDist += d[i]; // 지금까지 온 거리
            if(cost[i] < cost[i+1]) {
                res += cost[i] * curDist; // 지금까지 온 거리 기름값 결제
                curDist = 0; // 온 거리 초기화
            }
        }
        // 마지막 남은 금액 계산 (마지막까지 계산이 안되었다면, cost[N-1]이 최소값이라는 이야기)
        res += cost[N-1] * (curDist + d[N-1]); // d[N-1]이 반복문에 포함 안되어 있음

        sb.append(res);
        System.out.print(sb);
        br.close();
    }

}