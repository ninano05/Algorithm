import java.util.*;
import java.io.*;

class Solution
{
	static boolean[] prime; // idx가 소수인지 아닌지.
	static int MAX = 1000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		prime = new boolean[MAX];
		
		// 1000000까지의 소수 구해두기(에라토스테네스의 채)
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for(int i=2; i*i<MAX; i++) {
			if(prime[i]) {
				for(int j=i*i; j<MAX; j+=i) {
					prime[j] = false;
				}
			}
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