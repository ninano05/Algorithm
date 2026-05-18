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
			long N = Long.parseLong(br.readLine());

			long res = 0;
			
			long X = Math.round(Math.pow(N, 1.0/3));
			
			// 세제곱근 검증하기
			if(X*X*X == N) { // 세제곱이 같으면
				res = X;
			} else {
				res = -1;
			}
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}