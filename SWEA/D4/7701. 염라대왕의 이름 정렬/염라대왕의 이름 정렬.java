import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스  개수
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine()); // 명부 이름 개수
			
			// 이름 입력 받기
			String[] name = new String[N];
			for(int i=0; i<N; i++) {
				name[i] = br.readLine();
			}
			
			// 길이로 정렬하기
			// 길이가 같으면 사전 순으로 정렬
			Arrays.sort(name, (a,b) -> {
				if(a.length() == b.length()) return a.compareTo(b);
				return a.length() - b.length();
			});
			
			
			sb.append("#").append(t).append("\n");
			sb.append(name[0]).append("\n");
			// 중복 제거해서 출력
			for(int i=1; i<N; i++) {
				if(!name[i].equals(name[i-1])) {
					sb.append(name[i]).append("\n");
				}
			}
		}
		System.out.print(sb);
		br.close();
	}
}