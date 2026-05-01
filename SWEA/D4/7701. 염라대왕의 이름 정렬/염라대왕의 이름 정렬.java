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
			Set<String> set = new HashSet<>();
			for(int i=0; i<N; i++) {
				set.add(br.readLine()); // 중복 제거
			}
			
			String[] name = new String[set.size()]; // 이름 저장할 배열
			// 이름 배열로 옮기기
			int idx = 0;
			for(String s : set) {
				name[idx] = s;
				idx++;
			}
			
			// 길이로 정렬하기
			// 길이가 같으면 사전 순으로 정렬
			Arrays.sort(name, (a,b) -> {
				if(a.length() == b.length()) return a.compareTo(b);
				return a.length() - b.length();
			});
			
			// 출력
			sb.append("#").append(t).append("\n");
			for(String s : name) {
				sb.append(s).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}