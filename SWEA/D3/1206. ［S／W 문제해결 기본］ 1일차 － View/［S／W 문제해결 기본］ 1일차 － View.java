import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 양쪽 두개에 대한 검사를 진행하기
		// 빌딩 높이의 차로 구하면 될듯
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] buildings = new int[N];
			// 빌딩 높이 입력하기
			for(int i=0; i<N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			// 조망권 확보 세대 검사
			int light = 0; // 조망권 확보 세대 수
			for(int i=2; i<N-2; i++) { // 앞 뒤 0세대 2개씩은 검사할 필요 없음
				int cur = buildings[i]; // 현재 검사할 세대
				// 앞 2세대 중 더 높은 빌딩 선택
				int front = Math.max(buildings[i-2], buildings[i-1]);
				// 뒤 2세대 중 더 높은 빌딩 선택
				int back = Math.max(buildings[i+1], buildings[i+2]);
				int max = Math.max(front, back); // 앞 뒤 중 더 높은 세대 선택
				if(cur > max) light += (cur - max); // 현재 아파트가 더 높으면 조망권이 좋은 세대임
			}
			sb.append("#").append(t).append(" ").append(light).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}