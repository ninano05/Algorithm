import java.util.*;
import java.io.*;

class Solution
{
	static public int[][] miro; // 미로 정보
	
	// 상하좌우 이동
	static int[] dr = {-1, 1, 0, 0}; // 행 이동
	static int[] dc = {0, 0, -1, 1}; // 열 이동
	
	// 길 찾았는지 여부
	static int find;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			//변수 선언
			miro = new int[16][16];
			find = 0;
			
			// 시작 좌표
			int startR = 0;
			int startC = 0;
			
			// 미로 입력 받기
			for(int r=0; r<16; r++) {
				String s = br.readLine();
				for(int c=0; c<16; c++) {
					miro[r][c] = s.charAt(c) - '0';
					if(miro[r][c] == 2) { // 시작 좌표 입력 받기
						startR = r;
						startC = c;
					}
				}
			}
			// 미로 길 찾기
			bfs(startR, startC);
			sb.append("#").append(T).append(" ").append(find).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	public static void bfs(int startR, int startC) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{startR, startC}); // 큐에 위치 넣기
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll(); //현재 살필 노드
			
			for(int i=0; i<4; i++) {
				int nR = cur[0] + dr[i];
				int nC = cur[1] + dc[i];
				
				if(nR >= 0&& nR<16&& nC>=0 && nC<16) {
					if(miro[nR][nC] == 3) {
						find = 1; // 찾은 결과 저장
						break; // 종료하기
					} else if(miro[nR][nC] == 0) {
						queue.offer(new int[] {nR, nC}); // 큐에 넣어두기
						miro[nR][nC] = 1; // 방문 표시(다시 못돌아가도록 1로 변경)
					}
				}
			}
		}
	}
}