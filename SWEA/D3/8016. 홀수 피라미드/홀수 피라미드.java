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
			long N = Integer.parseInt(br.readLine());
			
			long l = getOdd(getSum(N-1)+1);
			long r = getOdd(getSum(N));
			
			
			sb.append("#").append(t).append(" ").append(l).append(" ").append(r).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	// x번 째 홀수 구하는 함수
	public static long getOdd(long x) {
		return 2*x-1;
	}
	
	// n까지 모든 홀수의 합
	public static long getSum(long n) {
		return n*n;
	}
}