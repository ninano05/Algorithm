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
			
			long N = Long.parseLong(st.nextToken());
			int PD = Integer.parseInt(st.nextToken());
			int PG = Integer.parseInt(st.nextToken());
			
			boolean res = false;
			
			// 전체 승률에 대한 계산
			if(PG == 100 && PD != 100) { // 전체가 100이면 부분도 100
				res = false;
			} 
			else if(PG == 0 && PD !=0) { // 전체가 0이면 부분도 0
				res = false;
			} else { // 나머지 경우
				// N에대한 승률 PD%가 정확히 판수로 나타내져야 함
				// 5판의 2% 이런 경우는 안 되는 경우임
				// 100판의 10% 는 가능한 경우임 -> 이런 n이 하나라도 있으면 되는 것
				for(long n=1; n<=N; n++) {
					if(((n*PD)%100) == 0) {
						res = true;
						break;
					}
				}
			}
			
			sb.append("#").append(t).append(" ")
			.append(res ? "Possible" : "Broken").append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}