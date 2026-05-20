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
			int N = Integer.parseInt(br.readLine());
			
			String fullSentence = ""; //모든 문장 합쳐버리기
			int[] name = new int[N]; // 문장별 이름 개수
			
			int count = 0; // 현재까지 나온 문장의 개수
			
			while(count < N) {
				String s = br.readLine();
				
				// 문장 부호 확인
				for(int i=0; i<s.length(); i++) {
					if(s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?') {
						count++;
					}
				}
				fullSentence+= (" "+s); // 문장 합치기(공백을 넣는 이유는 단어가 붙지 않도록)
			}
			
			st = new StringTokenizer(fullSentence, ".!?"); // 부호로 이어진 문장 자르기
			
			for(int i=0; i<N; i++) { // 문장마다 확인
				// 잘라진 문장 단어 단위로 자르기
				StringTokenizer word = new StringTokenizer(st.nextToken()); // 공백 제거
				while(word.hasMoreTokens()) {
					if(isName(word.nextToken())) {
						name[i]++;
					}
				}
			}
			sb.append("#").append(t).append(" ");
			for(int n: name) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	// 이름인지 판단하는 함수
	public static boolean isName(String s) {
		if(s.charAt(0)>='A'&&s.charAt(0)<='Z') { // 첫글자 대문자
			for(int i=1; i<s.length(); i++) { // 다음 소문자 영어인지 확인
				if(s.charAt(i)<'a' || s.charAt(i) > 'z') { // 소문자 영어 아니면
					return false;
				}
			}
			return true;
		}
		return false;
	}
}