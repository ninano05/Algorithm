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
			int N = Integer.parseInt(br.readLine());
			
			int[] price = new int[N];
			
			// 가격 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			// 가격 정렬하기(오름 차순)
			Arrays.sort(price);
			
			int cost = 0; // 지불해야 할 가격
			
			int rest = N%3; // 3개씩 묶고 남은 옷 개수
			
			// 남은 옷 먼저 계산해 두기
			for(int i=0; i<rest; i++) {
				cost += price[i];
			}
			
			int counter = 0;
			
			// 이후 3개 묶음 중 제일 저렴한 거 빼고 합산하기
			for(int i=rest; i<N; i++) { // 남은 옷은 3n개임
				if(counter != 0) { // 3개의 묶음 중 제일 저렴한게 아니라면
					cost += price[i];
				}
				counter = (counter+1)%3; // 0, 1, 2 반복
			}
			
			sb.append("#").append(t).append(" ").append(cost).append("\n");	
		}
		System.out.print(sb);
		br.close();
	}
}