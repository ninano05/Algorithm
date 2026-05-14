import java.util.*;
import java.io.*;

class Solution
{
	static int[] left;
	static int[] right;
	static char[] node;
	static boolean res;
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine()); // 케이스 개수
			
			// 변수 초기화
			left = new int[N+1];
			right = new int[N+1];
			node = new char[N+1];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(st.nextToken()); // 몇번째 노드
				char c = st.nextToken().charAt(0); // 해당 문자
				node[n] = c;
				
				int l = 0; // 왼쪽 (0이면 없는 거임)
				int r = 0; // 오른쪽
				
				if(st.hasMoreTokens()) {
					l = Integer.parseInt(st.nextToken());
					left[n] = l;
				}
				if(st.hasMoreTokens()) {
					r = Integer.parseInt(st.nextToken());
					right[n] = r;
				}
			}
			
			// 이제 연산 되는지 확인 하기
			res = true;
			stack = new Stack<>();
			
			inOrder(1); // 1번 노드에서 시작
			
			// 마지막 요소 검사하기
			if(stack.peek()<'0' || stack.peek()>'9') res = false;
			
			sb.append("#").append(t).append(" ");
			sb.append(res ? "1" : "0");
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
	
	public static void inOrder(int start) {
		
		if(!res) return; // 이전 결과가 거짓이면 리턴
		
		if(start == 0) return; // 0이면 없는 노드라서
		
		inOrder(left[start]); // 왼쪽 노드 탐색
		
		if(node[start]<'0' || node[start] >'9') { // 숫자가 아님
			if(stack.isEmpty()) { // 스택이 비어 있음
				res = false; // 문자 처음은 불 가능
				return;
			} else {
				char c = stack.peek(); 
				if(c<'0' || c>'9') { // 이전에도 문자라면
					res = false; // 반환하기
					return;
				}
			}
		}
		
		stack.add(node[start]);
		
		inOrder(right[start]); // 왼쪽 노드 탐색
	}
}