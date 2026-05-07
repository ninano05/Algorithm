import java.util.*;
import java.io.*;

class Solution
{
   	static char[][] board;
	static int[][] bombNum;
	static int N;
	
	// 주변 8곳 이동
	// 상하좌우, 4가지 대각선
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static class Node{
		int r;
		int c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine()); //판 크기
			
			// 지뢰판 입력 받기
			board  = new char[N][N];
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					board[i][j] = s.charAt(j);
				}
			}
			
			bombNum = new int[N][N];			
			// 빈 칸일 경우 주변 지뢰 개수 저장하기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j] == '.') {
						countBomb(i, j);
					}
				}
			}
			
			int count = 0;
			// 0인 곳은 먼저 탐색해버리기 bfs로
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j] == '.' && bombNum[i][j] == 0) {
						// 빈 공간이고 주변에 폭탄이 없으면 탐색하기
						bfs(i, j);
						count++; // 탐색 한번 = 클릭 한번
					}
				}
			}
			
			// 남은 빈공간 개수 세기 -> 한번씩 모두 눌러줘야 함
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j] == '.') count++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void countBomb(int r, int c) {
		int count = 0;
		
		// 주변 8곳 확인
		for(int i=0; i<8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N) { // 범위 안 일때
				if(board[nr][nc] == '*') count++; // 폭탄이면 개수 더하기				
			}
		}
		
		bombNum[r][c] = count; // 개수 저장
	}
	
	public static void bfs(int r, int c) {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(r, c)); // 탐색 시작 노드
		board[r][c] = 'C'; //방문 처리
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			
			// 주변 노드 확인
			for(int i=0; i<8; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(board[nr][nc] == '.' && bombNum[nr][nc] == 0) { // 빈칸이고, 주변에 폭탄이 없으면
						que.offer(new Node(nr, nc)); // 다음 탐색지로 넣기
						board[nr][nc] = 'C'; // 방문 처리
					}
					else if(board[nr][nc] == '.' && bombNum[nr][nc] != 0) { // 빈칸이고 폭탄 개수가 0이 아니면
						board[nr][nc] = 'C'; // 방문처리만 하기
					}
				}
			}
		}
	}
}