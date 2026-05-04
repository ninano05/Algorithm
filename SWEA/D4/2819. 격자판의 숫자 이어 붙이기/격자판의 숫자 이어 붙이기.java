import java.util.*;
import java.io.*;

class Solution
{
	static int[][] board;
	static int N = 4;
	static HashSet<String> set;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			// 격자판 입력받기
			board  = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 중복 개수 처리
			set = new HashSet<>(); 
			
			// 서로 다른 숫자 개수 구하기 (시작점 여러개로)
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dfs(0, i, j, ""+board[i][j]);
				}
			}
			
			sb.append("#").append(t).append(" ").append(set.size()).append("\n"); // 개수만 출력
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void dfs(int depth, int r, int c, String s) {		
		// 종료 조건 (7자리 다 골랐으면)
		if(depth == 6) {
			set.add(s);
			return;
		}
		
		// 다음 좌표 고르기
		for(int i=0;i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N) { // 범위 안
				// 선택하기
				dfs(depth+1, nr, nc, s+board[nr][nc]);
			}
		}
	}
}