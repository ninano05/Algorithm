import java.util.*;
import java.io.*;

class Solution
{
	static boolean[] prime; // idx가 소수인지 아닌지.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		prime = new boolean[1000001];
		
		// 1000000까지의 소수 구해두기
		for(int i=1; i<=1000000; i++) {
			prime[i] = isPrime(i);
		}
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int count = 0; // 테네스 소수 개수
			
			
			// A에서 B까지의 소수 찾기
			for(int i=A; i<=B; i++) {
				if(isTenes(i, D) && prime[i]) { // 특별할 때 소수인지
					count++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	// 소수 판벌
	public static boolean isPrime(int n) {
		if(n == 1) return false;
		if(n == 2) return true;
		
		for(int i=2; i*i<=n; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
	
	// 테네스 특별한 수인지 판별하기
	public static boolean isTenes(int num, int D) {
		while(num > 0) {
			int n = num%10;
			if(n == D) { // 같은 숫자 하나라도 나오면
				return true;
			}
			num = num/10;
		}
		return false;
	}
}