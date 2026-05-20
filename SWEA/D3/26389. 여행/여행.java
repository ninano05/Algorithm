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
			String s = br.readLine();
			
			// E가 나왔으면 W는 한번이라도 나와야 함
			// N이 나왔으면 S는 한번이라도 나와야 함
			boolean E = false;
			boolean W = false;
			boolean N = false;
			boolean S = false;
			
			boolean res = true;
			
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				
				if(c == 'E') E = true;
				else if(c == 'W') W = true;
				else if(c == 'N') N = true;
				else if(c == 'S') S = true;
			}
			
			if(W!=E || N!=S) res = false;
			
			sb.append(res ? "Yes" : "No").append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}