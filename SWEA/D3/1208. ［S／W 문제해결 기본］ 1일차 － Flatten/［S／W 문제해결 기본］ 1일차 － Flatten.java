import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 처음에 정렬을 하고 들어가는게 탐색 횟수를 줄이는데 도움이 될듯
		// 어차피 1씩 증감하고 빠지는 거니까
		// 덤프한 다음에는 앞뒤로만 비교해서 나랑 같거나 커지는 지점에서 스탑
		
		for(int t=1; t<=10; t++) {
			int d = Integer.parseInt(br.readLine());// 덤프할 횟수
			int max = 99; // 최대 상자 번호 인덱스
			int[] boxs = new int[max+1]; // 상자 배열 생성
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 상자 개수 채우기
			for(int i=0; i<100; i++) {
				boxs[i] = Integer.parseInt(st.nextToken());
			}
			// 상자 오름차순으로 정렬
			Arrays.sort(boxs); // 앞이 최저점, 뒤가 최고점
			int sub = 0; // 덤프 후 최고점 최저점 차이
			// 덤프 하기
			for(int i=0; i<d; i++) {
				// 종료 조건 확인 (먼저 해주기 -> 덤프할 필요 없을 수도)
				sub = boxs[max] - boxs[0];
				if(sub <= 1) break;
				
				// 상자 옮기기 (앞에서 검사 했기 때문에 상자 높이 무조건 100미만 만족)
				boxs[0] += 1; // 상자 넣기(맨 앞이 최저점)
				boxs[max] += -1; // 상자 빼기 (맨 뒤가 최고점)
				
				// 다시 크기 순으로 정렬
				// 작은 쪽 정렬 (다음보다 큰 경우에만)
				if(boxs[0] > boxs[1]) {
					for(int j=1; j<=max; j++) {
						if(boxs[j]>= boxs[0]) {
							int temp = boxs[0];
							boxs[0] = boxs[j-1];
							boxs[j-1] = temp;
							break;
						}
					}
				}
				// 큰 쪽 정렬 (이전보다 작은 경우에만)
				if(boxs[max] < boxs[max-1]) {
					for(int j=max-1; j>=0; j--) {
						if(boxs[max] >= boxs[j]) {
							int temp = boxs[max];
							boxs[max] = boxs[j+1];
							boxs[j+1] = temp;
							break;
						}
					}
				}
				
			}
			sub = boxs[max] - boxs[0]; // 마지막까지 도달했을 경우
			sb.append("#").append(t).append(" ").append(sub).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}