import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 완전 탐색
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine()); // 들어야 하는 수업 일 수
			
			st = new StringTokenizer(br.readLine());
			int[] lecture = new int[7]; // 수업 여부
			int num = 0; // 일주일에 총 수업 시간
			
			for(int i=0; i<7; i++) {
				lecture[i] = Integer.parseInt(st.nextToken());
				if(lecture[i] == 1) num++;
			}
			
			int min = Integer.MAX_VALUE; // 최소의 수업 일 수
			
			// 언제 시작하냐에 따라서 수업 일 수가 달라짐
			for(int i=0; i<7; i++) { // 수업 시작일 선정하기
				
				int day = 0; // 현재 전체 일 수
				int course = 0; // 실제 수강한 수업 일 수
				
				// 수업 일수 채울 때까지 반복
				if(lecture[i] == 1) { // 수업이 있는 날임 - 시작일로 채택
					// 첫 주 남은 날 계산
					for(int j=i; j<7; j++) {
						day++; // 전체 일 수 추가
						if(lecture[j] == 1) { // 수업있으면
							course++; // 수업 일 수 추가
						}
					}
					
					// 중간 주 계산 (한 주 더 들어감)
					while(course < N) {
						day += 7;
						course+=num;
					}
					// 마지막 주 제외
					day -= 7;
					course -= num; 
					
					// 마지막 주 계산
					for(int j=0; j<7; j++) {
						day++;
						if(lecture[j] == 1) {
							course++; 
							if(course == N) break;
						}
					}

					// 최소 일 수 비교
					min = Math.min(min, day);
				}
			}
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}