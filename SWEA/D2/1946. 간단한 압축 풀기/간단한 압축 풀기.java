import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int index = 0; // 줄바꿈 관리
			
			sb.append("#").append(t).append("\n");
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				char lan = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				for(int j=0; j<num; j++) { // 문자열 반복
					sb.append(lan);
					index++;
					if(index >= 10) { // 10개 도달하면 줄바꿈
						index = 0;
						sb.append("\n");
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}