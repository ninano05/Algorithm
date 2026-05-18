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
			
			long s1 = getSum(N);
			long s2 = getOddSum(N);
			long s3 = getEvenSum(N);
			
			sb.append("#").append(t).append(" ");
			sb.append(s1).append(" ").append(s2).append(" ").append(s3).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
	
	// 1부터 개의 합
	public static long getSum(long n) {
		return ((n+1)*n)/2;
	}
	
	// 1부터 홀수 N개의 합
	public static long getOddSum(long n) {
		return n*n;
	}
	
	// 2부터 짝수 N개의 합
	public static long getEvenSum(long n) {
		return n*(n+1);
	}
}