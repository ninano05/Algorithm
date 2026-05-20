import java.util.*;
import java.io.*;

class Solution
{
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken()); //행
			int c = Integer.parseInt(st.nextToken()); //열
			
			char[][] board = new char[r][c];
			
			// 판 입력 받기
			for(int i=0; i<r; i++) {
				String s = br.readLine();
				for(int j=0; j<c; j++) {
					board[i][j] = s.charAt(j);
				}
			}
			
			boolean res = true;
			
			// 각 칸에서 주변이랑 안 겹치도록 가능한지 확인
			loop:
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					char cur = board[i][j];
					
					if(cur == '?') { // 안정해졌다면
						
						// 4방향 확인하기
						for(int k=0; k<4; k++) {
							int nr = i+dr[k];
							int nc = j+dc[k];
							
							if(nr>=0 && nr<r && nc>=0 && nc<c) { // 범위 안이면
								if(board[nr][nc] == '#') { 
									if(cur == '?') cur = '.'; // 반대로 가정해두기
									else if(cur == '#') { // 만약 가정해둔 값이랑 같다면?
										res = false;
										break loop;
									}
								} else if(board[nr][nc] == '.') {
									if(cur == '?') cur = '#';
									else if(cur == '.') {
										res = false;
										break loop;
									}
								}
							}
						}
						board[i][j] = cur; // 새로 지정한 색으로 업데이트
						
					} else { // 정해져 있다면
						// 4방향 확인하기
						for(int k=0; k<4; k++) {
							int nr = i+dr[k];
							int nc = j+dc[k];
							
							if(nr>=0 && nr<r && nc>=0 && nc<c) { // 범위 안이면
								if(cur == board[nr][nc]) { // 주변과 색이 같으면
									res = false;
									break loop;
								}
							}
						}
					}
				}
			}
			sb.append("#").append(t).append(" ")
			.append(res ? "possible" : "impossible").append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}