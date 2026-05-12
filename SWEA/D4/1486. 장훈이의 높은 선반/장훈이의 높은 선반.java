import java.util.*;
import java.io.*;

class Solution
{
	static int[] H; // 키 배열
    static int min; // 현재까지 최소 키
    static int N;
    static int B;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 점원 수
            B = Integer.parseInt(st.nextToken()); // 선반 높이

            H = new int[N];
            st = new StringTokenizer(br.readLine());
            // 키 입력 받기
            for(int i=0; i<N; i++) {
                H[i] = Integer.parseInt(st.nextToken());
            }
            
            min = Integer.MAX_VALUE;
            // 만들 수 있는 모든 조합의 키 조합 경우의 수 탐색
            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(min-B).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int depth, int sum) { // 현재 직원, 이전에 고른 숫자,현재 합
        // B보다 커지는 순간
        if(sum >= B) { // 어차피 더 가도 커지기만 함
            min = Math.min(min, sum);
            return;
        }

        // 모든 직원을 선택했다면 종료
        if(depth == N) {
            return;
        }

        // 현재 직원 선택
        dfs(depth+1, sum+H[depth]);
        
        // 현재 직원 선택x
        dfs(depth+1, sum);
    }
}