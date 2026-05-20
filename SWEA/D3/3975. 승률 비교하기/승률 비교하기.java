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
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			double Alice = (double)A/B; // 앨리스가 승률
			double Bob = (double)C/D; // 밥 승률
			
			sb.append("#").append(t).append(" ");
			if(Alice > Bob) sb.append("ALICE");
			else if(Bob > Alice) sb.append("BOB");
			else sb.append("DRAW");
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}