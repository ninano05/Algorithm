import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 처음에 초기 금액으로 결제하고 차타고 가기
        // 지금보다 최소 금액이 나오면 주유소 바꾸기

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N-1]; // cost[0]까지 가는데 거리가 0이기에, d[0]=0으로 잡는다.
        int[] cost = new int[N];

        // 거리와 가격 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N-1; i++) { // i=0 일때 d[0]=0
            d[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long res = 0; // 최종 비용
        int min = cost[0]; // 최소 가격 (초기가격: 처음 주유소 가격)

        // 거리에 대해서 현재 최소 가격으로 계속 결제하면서 간다.
        for(int i=0; i<N-1; i++) {
            if(cost[i] < min) { // 최소 가격 갱신
                min = cost[i];
            }
            res += (long) min * d[i]; // 인덱스 차이가 있어, 최소 가격 갱신이 먼저이어야 함
        }

        sb.append(res);
        System.out.print(sb);
        br.close();
    }

}