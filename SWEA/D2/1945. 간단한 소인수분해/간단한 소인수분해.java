import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] numSet = {2, 3, 5, 7, 11};
		
			int temp = N;
			sb.append("#").append(t).append(" ");
			// numSet으로 소인수 분해
			for(int i=0; i<5; i++) {
				int num = numSet[i];
				int repeat = 0;
				// 하나의 숫자로 계속 나누기 -> 나머지가 0이 아닐때까지
				while(temp % num == 0) {
					temp = temp / num;
					repeat ++;
				}
				sb.append(repeat).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}