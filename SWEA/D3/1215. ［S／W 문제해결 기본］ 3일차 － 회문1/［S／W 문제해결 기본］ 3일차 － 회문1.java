import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		//8*8 고정이니까 완탐을 돌리자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			int len = Integer.parseInt(br.readLine());
			char[][] board = new char[8][8]; // 고정 크기의 판
			// 판에 문자 입력
			for(int i=0; i<8; i++) {
				String s = br.readLine();
				for(int j=0; j<8; j++) {
					board[i][j] = s.charAt(j);
				}
			}
			int pd = 0; // 회문 총 개수
			// 회문 찾기 완탐 돌리기
			//행
			for(int r=0; r<8; r++) {
				for(int i=0; i<=8-len; i++) { // 탐색 시작 좌표
					boolean isP = true; // 회문인가?
					for(int j=0; j<(len/2); j++) {
						if(board[r][i+j] != board[r][i+(len-j-1)]) { // 앞과 뒤 비교
							isP = false;
							break;
						}
					}
					if(isP) pd++; // true면 회문 개수 추가
				}
			}
			//열
			for(int c=0; c<8; c++) {
				for(int i=0; i<=8-len; i++) {
					boolean isP = true; // 회문인가?
					for(int j=0; j<(len/2); j++) {
						if(board[i+j][c] != board[i+(len-j-1)][c]) { // 앞과 뒤 비교
							isP = false;
							break;
						}
					}
					if(isP) pd++;
				}
			}
			sb.append("#").append(t).append(" ").append(pd).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}