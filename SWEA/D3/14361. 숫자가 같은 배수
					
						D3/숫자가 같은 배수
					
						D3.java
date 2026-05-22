import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++) {
			// 길이가 똑같아야 함
			// 절대로 10배 이상은 안 됨
			String s = br.readLine();
			int len = s.length();
			int N = Integer.parseInt(s);
			
			int[] use = new int[10]; // 사용 가능한 숫자 개수
			for(int i=0; i<s.length(); i++) {
				use[s.charAt(i)-'0']++;
			}
			
			boolean res = false;
			
			// 하나당 많아봤자 9배까지임
			for(int i=2; i<=9; i++) {
				boolean canMake = true;// 이번 배수는 가능한지 아닌지
				
				String cur = String.valueOf(N*i);
				
				// 길이 초과되면 break
				if(cur.length() > len) break;
				
				// 재배열 가능한지 확인하기
				int[] need = new int[10];
				for(int j=0; j<cur.length(); j++) {
					int c = cur.charAt(j)-'0';
					need[c]++;
				}
				
				// 필요한 개수 비교
				for(int j=0; j<9; j++) {
					if(use[j] != need[j]) {
						canMake = false;
					}
				}
				
				// 이번에 만들었다면
				if(canMake) {
					res = true;
					break;
				}
			}
			
			sb.append("#").append(t).append(" ")
			.append(res ? "possible" : "impossible").append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}