import java.util.*;
import java.io.*;

class Solution
{
	static HashSet<Integer>[] score; // 문제 단계별로 가능한 점수 저장
    static int N;
    static int[] test;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine()); // 문제 개수

            test = new int[N]; // 문제 별 배점
            // 문제별 배점 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                test[i] = Integer.parseInt(st.nextToken());
            }

            score = new HashSet[N+1];
            for(int i=0; i<=N; i++) {
                score[i] = new HashSet<>();
            }
            // 가능한 점수 탐색하기
            dfs(0, 0); // 몇번째 문제 인지

            sb.append("#").append(t).append(" ").append(score[N].size()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static void dfs (int depth, int sum) {
        // 이전에 이 시기에 동점으로 온적이 있다면 경우의 수 더 보지 않음
        // 왜냐면 이 전에 경우의 수를 계산했을 테니까!
        if(score[depth].contains(sum)) return;

        // 지금 단계까지의 합산 점수
        score[depth].add(sum);

        // 모든 문제 채점했다면
        if(depth == N) return;

        // 문제 채점하기
        // 문제 풀었을 경우
        dfs(depth+1, sum+test[depth]);

        // 문제 안 풀었을 경우

        dfs(depth+1, sum);
    }
}