import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String s = br.readLine();
			StringBuilder decodeString = new StringBuilder();
			
			sb.append("#").append(t).append(" ");
			// 전부 해독후 이진수로 변환
			for(int i=0; i<s.length(); i++) {
				decodeString.append(tenToTwobit(decoder(s.charAt(i))));
			}
			// 8비트씩 끊어서 보기
			for(int i=0; i<decodeString.length(); i+=8) {
				sb.append(bitToWord(decodeString.substring(i, i+8)));
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	// 4개의 문자 => 3개의 실제 문자로 변환
	// 아스키 코드 뺄셈 간격 이용
	public static int decoder(char c) {
		// 숫자인 경우
		if(c>='0' && c<='9') return c-'0'+52;
		// 대문자 영어인 경우
		else if (c>='A' && c<='Z') return c-'A';
		// 소문자 영어인 경우
		else if(c>='a' && c<='z' ) return c-'a'+26;
		// 특수 기호
		else if(c == '+') return 62;
		else return 63;
	}
	// 10진수 이진수(string)변환 - (6비트 자리)
	public static String tenToTwobit(int n) {
		String binary = String.format("%6s", Integer.toBinaryString(n)).replace(' ', '0');
		return binary;
	}
	// 이진수(8bit)를 문자로 변환
	public static char bitToWord(String s) {
		int num = Integer.parseInt(s, 2); //2진수 -> 10진수
		char c = (char) num; // 아스키 코드(숫자) -> 문자
		return c;
	}
}