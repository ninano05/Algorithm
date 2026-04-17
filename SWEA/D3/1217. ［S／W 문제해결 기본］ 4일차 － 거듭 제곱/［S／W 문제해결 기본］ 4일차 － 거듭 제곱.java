import java.util.Scanner;

class Solution
{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int T = sc.nextInt();
			// 숫자 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 재귀함수 호출을 통한 제곱 (int 안넘는다고 주어짐)
			int res = power(N, M);
			
            System.out.println("#"+T+" "+res);
		}
	}
	
	// 제곱하는 재귀함수
	public static int power(int N, int M) {
		if(M == 1) return N; // 1에 도달하면 N 반환 
		else {
			return N * power(N, M-1); // 다음 재귀 호출 * N => 제곱 표현
		}
	}
}