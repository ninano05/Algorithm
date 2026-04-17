import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			int len = Integer.parseInt(br.readLine()); // 테이블 한 변 길이
			
			// 테이블 선언 및 입력하기
			int[][] table = new int[len][len];
			StringTokenizer st;
			for(int i=0; i<len; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<len; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res = 0; // 교착 상태 개수
			// 하나의 열에서 1다음에 2가 나오면 교착상태 한개이다.
			// boolean을 통해서 1다음에 2가 나오는 상태를 관리한다.(0은 의미 없는 값)
			for(int i=0; i<len; i++) { // 열 반복
				boolean deadLock = false; // 열이 넘어가면 상태 초기화
				for(int j=0; j<len; j++) {
					if(table[j][i] == 1) {
						deadLock = true; // 1이 나오면 true로 바꾸기
					}else if(table[j][i] == 2 && deadLock) { // 이번에 2이고 이전에 1이 나온 상태라면
						res ++; // 교착 상태 개수 증가
						deadLock = false; // 다시 상태 초기화
					}
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}