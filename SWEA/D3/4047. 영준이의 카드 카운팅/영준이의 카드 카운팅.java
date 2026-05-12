import java.util.*;
import java.io.*;

class Solution
{
	static boolean[][] card;
	static int[] cardSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String s = br.readLine(); // 영준이가 가지고 있는 카드 입력
			
			// 0: S, 1:D, 2:H, 3:C
			card = new boolean[4][14]; // 카드 여부 확인
			cardSum = new int[4]; // 무늬별 앞으로 필요한 카드 개수
			for(int i=0; i<4; i++) { // 카드 전체 개수로 채워두기
				cardSum[i] = 13;
			}
			boolean err = true;
			
			// 3개 단위로 하나의 카드 정보
			for(int i=0; i<s.length(); i+=3) {
				char c = s.charAt(i); // 무늬
				int num = Integer.parseInt(s.substring(i+1, i+3)); // 카드 번호
				err = getCard(c, num); // 카드 저장
				if(!err) break;
			}
			
			sb.append("#").append(t).append(" ");
			if(!err) sb.append("ERROR");
			else {
				for(int i=0; i<4; i++) {
					sb.append(cardSum[i]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static boolean getCard(char c, int num) {
		if(c == 'S' && !card[0][num]) {
			cardSum[0]--;
			return card[0][num] = true;
			
		}
		else if(c == 'D' && !card[1][num]) {
			cardSum[1]--;
			return card[1][num] = true;
		} 
		else if(c == 'H' && !card[2][num]) {
			cardSum[2]--;
			return card[2][num] = true;
		} 
		else if(c == 'C' && !card[3][num]) {
			cardSum[3]--;
			return card[3][num] = true;
		}
		else return false; // 카드가 이미 저장이 되어있던 경우
	}
}