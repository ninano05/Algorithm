import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			// 첫번 째와 마지막 달 계산
			if (m1 == m2) answer += (d2-d1+1);
			else {
				answer +=(getDay(m1) - d1 +1);
				answer += d2;
			}
			// 사이에 있는 달 계산
			for(int i=m1+1; i<m2; i++) {
				answer+=getDay(i);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	// 온전한 달일 경우 일 반환 함수
	public static int getDay(int m) {
		if(m == 2) return 28;
		else if(m == 4 || m==6 || m==9 || m==11) return 30;
		else return 31;
	}
}