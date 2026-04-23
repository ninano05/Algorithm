import java.util.*;
import java.io.*;

class Solution
{
	static int[][] miro;
	static int N = 100;
	static int res;
	
	// 상하좌우 이동
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};
	
	public static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			int[] start = new int[2]; //0:행, 1:열
			
			// 변수 초기화
			miro = new int[N][N];
			// 미로 입력
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					miro[i][j] = s.charAt(j) - '0';
					if(miro[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					}
				}
			}
			res = 0;
			// dfs 돌리기
			dfs(start[0], start[1]);
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void dfs(int r, int c) {
		// 찾으면 종료
		if(miro[r][c] == 3) {
			res = 1;
			return;
		}
		miro[r][c] = 1; // 방문 처리
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N) { // 범위 안
				if(miro[nr][nc] != 1) {
					dfs(nr, nc);
				}
			}
		}
	}
}