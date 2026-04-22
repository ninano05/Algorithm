import java.util.*;
import java.io.*;

class Solution
{
	static int[][] food;
	static int N;
	static int L;
	static int max; // 최고 점수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			// 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			// 변수 크기 지정 및 초기화
			food = new int[N][2]; // 인덱스와 고르는 개수 맞추기 위함
			
			// 재료 정보 입력 받기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				food[i][0] = Integer.parseInt(st.nextToken()); // 점수
				food[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			
			// 최고 점수 초기화
			max = 0;
			// 재료 조합 시작
			dfs(0, 0, 0); // 아무것도 안고르고 시작
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	// idx로 관리하는 건 내가 몇번째 재료를 보고 있는가 이다. 
	// 재료를 만날때마다 선택은 두가지이다 
	// 재료를 고른다. 재료를 고르지 않는다
	// 재료를 고르면 값을 업데이트 해서 다음 재료를 고를지 말지로 넘어간다.
	// 재료를 안 고르면 값을 업데이트 하지 말고 다음 재료를 고를지 말지로 넘어간다.
	public static void dfs(int idx, int score, int kcal) {
		// 점수 초과했으면 더 보지 말고 다음 경우로 넘어가자
		if(kcal > L) return;
		
		// 모든 재료에 대해서 고를지 말지 선택 했다면 최대값 갱신
		if(idx == N) {
			max = Math.max(score, max);
			return;
		}
		
		// 이번 재료 고르고 다음으로 넘어가기
		dfs(idx+1, score+food[idx][0], kcal+food[idx][1]); // 골랐으면 정보 갱신
		
		// 백트래킹
		// 이번 재료 안 고르고 다음으로 넘어가기
		dfs(idx+1, score, kcal); // 안고르면 현행 유지
		
	}
}