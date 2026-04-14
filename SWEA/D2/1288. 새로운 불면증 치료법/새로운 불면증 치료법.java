import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// hashSet 사이즈 사용
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			Set<Character> set = new HashSet<>(); // 만난 숫자 담아두기
			int curNum = 0;
			
			while(set.size()<10) { // 0~9까지 채워지면 탈출
				curNum += N; // 이번 순서
				String s = String.valueOf(curNum);
				for(int i=0; i<s.length(); i++) {
					set.add(s.charAt(i)); // 문자 하나씩 넣기, 자동 중복 처리
				}
			}
			sb.append("#").append(t).append(" ").append(curNum).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}