import java.util.*;
import java.io.*;

class Solution
{
	static String order = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String s = br.readLine();
			
			int count = 0; // 순서에 올바른 알파벳 개수
			
			//검사하기
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == order.charAt(i)) count++;
				else {
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}