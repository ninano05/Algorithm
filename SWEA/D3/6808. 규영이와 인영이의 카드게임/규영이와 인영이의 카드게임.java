import java.util.*;
import java.io.*;

class Solution
{
	static int[] card;
	static int[] rest;
	static boolean[] used; // 인영이 카드 사용 표시
	static int win;
	static int lose;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			// 규영이 카드
			card = new int[9];
			
			// 규영이가 쓰고 남은 카드 알기 위한 배열
			boolean[] last = new boolean[19]; // 인덱스가 번호임
			
			// 규영이 카드 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				int a = Integer.parseInt(st.nextToken());
				card[i] = a;
				last[a] = true;
			}
			
			// 인영이 카드 구하기
			rest = new int[9];
			int idx = 0;
			for(int i=1; i<19; i++) {
				if(!last[i]) {
					rest[idx] = i;
					idx++;
				}
			}
			
			used = new boolean[9];
			win = 0;
			lose = 0;
			// 규영이가 이기는 경우의 수 탐색하기
			dfs(0, 0, 0); 
			
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void dfs(int idx, int score, int rival) {// 몇번째 카드 비교인지, 규영이 점수, 인영이 점수
		
		// 종료 조건 - 다 구했을 때
		if(idx == 9) {
			if(score > rival) { // 규영이가 이김
				win ++;
				return;
			} else if(rival > score) { // 규영이가 짐
				lose++;
				return;
			}
		}
		
		// 인영이 카드 고르기 (규영이는 idx, 인영이 카드만 고르면 됨)
		for(int i=0; i<9; i++) {
			
			if(!used[i]) { // 사용되지 않은 카드일때
				used[i] = true; // 사용 처리
				// 규영이 카드가 큰 경우
				if(card[idx] > rest[i]) {
					dfs(idx+1, score+card[idx]+rest[i], rival);
					
					// 되돌아 와서 사용 처리 취소
					used[i] = false;
					
				} else { // 인영이 카드가 큰 경우
					dfs(idx+1, score, rival+card[idx]+rest[i]);
					
					// 되돌아 와서 사용 처리 취소
					used[i] = false;
				}
			}
			
		}
		
	}
}