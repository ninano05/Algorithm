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
			// bfs나 dfs 돌리기
			bfs(start[0], start[1]);
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void bfs(int r, int c) {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(r, c)); // 큐에 넣기
		miro[r][c] = 1; // 왔던 길 표시
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			
			// 상하좌우 이동
			for(int i=0; i<4; i++) {
				
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) { // 범위 안
					if(miro[nr][nc] == 3) { // 도착점 찾으면
						res = 1; // 상태 업데이트
						return; // bfs 종료
					} else if(miro[nr][nc] == 0) { // 길일 때
						que.offer(new Node(nr, nc));
						miro[nr][nc] = 1; // 방문 처리
					}
				}
			}
		}
	}
}