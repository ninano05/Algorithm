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
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken()); // 집합 A 크기
			int B = Integer.parseInt(st.nextToken()); // 집합 B 크기
			
			int[] Agroup = new int[A];
			int[] Bgroup = new int[B];
			
			// 집합 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<A; i++) {
				Agroup[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<B; i++) {
				Bgroup[i] = Integer.parseInt(st.nextToken());
			}
			
			// A와 B 사이 겹치는 원소 개수 확인
			int same = 0; // 겹치는 원소 개수
			for(int i=0; i<A; i++) {
				int a = Agroup[i];
				for(int j=0; j<B; j++) {
					int b = Bgroup[j];
					if(a == b) {
						same++;
						break;
					}
				}
			}
			
			char res;
			
			// 겹치는 원소 개수가 A와 B의 각 크기랑 같은 경우
			if(same == A && same == B) {
				res = '=';
			}
			// A의 크기와 같은 경우 -> A는 B에 속함
			else if(same == A && same != B) { 
				res = '<';
			}
			// B의 크기와 같은 경우 -> B는 A에 속함
			else if(same != A && same == B) {
				res = '>';
			} 
			// 다 안 같으면 서로 다른 집합
			else { 
				res = '?';
			}
			sb.append(res).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}