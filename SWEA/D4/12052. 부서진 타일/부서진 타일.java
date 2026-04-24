import java.util.*;
import java.io.*;

class Solution
{
	static char[][] tile;
	static int N;
	static int M;
	
	// 왼쪽 상단을 기준으로 부서진 타일 묶음 보기(오른쪽, 아래, 오른쪽 아래 대각선)
	static int[] dr = {0, 1 , 1};
	static int[] dc = {1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 행
			M = Integer.parseInt(st.nextToken()); // 열
			
			tile = new char[N][M];
			int breakTile =0; // 부서진 타일 개수
			
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<M; j++) {
					tile[i][j] = s.charAt(j);
					if(tile[i][j] == '#') breakTile++;
				}
			}
			// 결과 초기값
			boolean res = true;
			// 일단 부서진 타일의 개수가 4의 배수가 아니면 못 고침 (0도 배수로 포함)
			if(breakTile%4 == 0) {
				// 부서진 타일의 개수가 4의 배수라면 배치를 확인해야 함
				// 위에서부터 고쳐야지 중간 부터 고치면 안 됨
				// 부서진 타일 시작 점을 기준으로 타일 살피기
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(tile[i][j] == '#') {
							fixTile(i, j);
						}
					}
				}
				// 부서진 타일 남았는지 확인
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(tile[i][j] == '#') {
							res = false;
						}
					}
				}
			} else {
				// 4의 배수가 아니라 못 고침
				res = false;
			}
			
			sb.append("#").append(t).append(" ");
			if(res) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void fixTile(int r, int c) {
		int canFix = 0;
		
		// 고칠 수 있는 지 확인
		for(int i=0; i<3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr<N && nc>=0&&nc<M) { // 범위 안
				if(tile[nr][nc] == '#') canFix++;
			}
			
		}
		
		// 고치기
		if(canFix == 3) {
			tile[r][c] = '.';
			for(int i=0; i<3; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				tile[nr][nc] = '.';
			}
		}
	}
}