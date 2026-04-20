import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 처음에 초기 금액으로 결제하고 차타고 가기
        // 지금보다 최소 금액이 나오면 주유소 바꾸기

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N]; // cost[0]까지 가는데 거리가 0이기에, d[0]=0으로 잡는다.
        int[] cost = new int[N];

        // 거리와 가격 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<N; i++) { // i=0 일때 d[0]=0
            d[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long curDist = 0; // 지금까지 온 거리
        long res = 0; // 최종 비용
        int min = cost[0]; // 현재 최소 가격 (초기값: 처음 주유소 가격)

        // 최소 가격이 나올때마다 앞으로 가는 거리 주유소 바꿔서 결제
        for(int i=1; i<N; i++) {
            curDist += d[i]; // 지금까지 온 거리
            if(cost[i] < min) { // 이전에 최소 가격이 비해 기름이 싸짐(최소가 갱신)
                res += min * curDist; // 지금까지 온 거리 기름값 결제
                min = cost[i];
                curDist = 0; // 온 거리 초기화
            }
        }
        // 거리가 남아 있으면 남은 금액 계산 (주유소 비용 갱신 안 되었다는 뜻, 현재 최소 주유소 비용으로 계산)
        res += curDist * min;

        sb.append(res);
        System.out.print(sb);
        br.close();
    }

}