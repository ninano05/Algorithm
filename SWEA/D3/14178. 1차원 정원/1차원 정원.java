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
			
			int N = Integer.parseInt(st.nextToken()); // 꽃 개수 1~N
			int D = Integer.parseInt(st.nextToken()); // 분무기 거리
			
			// 분무기 처음에는 1+D에 놓는다.
			// 그 뒤로는 2D 간격으로 둔다.
			// 즉 다음 분무기의 위치는 이전 위치에서 2D+1이다
			int first = 1+D; // 처음 분무기 위치
			int count = 1; // 분무기 개수
			int inter = 2*D+1; // 분무기 간격
			
			// 이후에는 2D+1에 분무기를 놓으면 됨
			count += (N-first)/inter; // 몫이 분무기를 놓은 개수임
			
			// 그러나 마지막 분무기를 놓고도 칸이 D 이상으로 남았다면 하나 추가해줘야 함
			if(N-(first+(count-1)*inter) > D) count++;
			
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}