import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N]; // 사용 가능한 동전 단위 배열
        // 동전 입력
        for(int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // 최소 동전 구하기
        int res = 0;
        // 동전을 큰 단위 -> 작은 단위 모두 돌아다니며 개수 구하기
        // 동전이 서로 배수 관계이기 때문에, 큰 단위부터 해도 상관 없음
        for(int i=N-1; i>=0; i--) { // coin이 오름 차순이기에 거꾸로 반복하기
            res += (K/coin[i]); // 큰 단위 동전 사용 개수
            K = K%coin[i]; // N에 남은 잔액 저장하기
            if(K == 0) break; // 남은 돈이 없으면 종료
        }
        
        sb.append(res);
        System.out.print(sb);
        br.close();
    }

}