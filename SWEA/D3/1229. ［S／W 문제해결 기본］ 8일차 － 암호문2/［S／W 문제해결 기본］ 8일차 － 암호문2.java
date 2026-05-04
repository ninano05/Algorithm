import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(br.readLine()); // 암호문 길이

            List<Integer> list = new ArrayList<>(); // 암호문 저장할 공간
            st = new StringTokenizer(br.readLine());
            // 원본 암호문 입력받기
            for(int i=0; i<N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int command = Integer.parseInt(br.readLine()); // 명령어 개수
            
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String c = st.nextToken(); // 명령어 I,D

                if(c.equals("I")) { // 삽입
                    int idx = Integer.parseInt(st.nextToken()); // 삽입 시작 인덱스
                    int n = Integer.parseInt(st.nextToken()); // 숫자 개수

                    // 삽입하기
                    for(int i=0; i<n; i++) {
                        list.add(idx+i, Integer.parseInt(st.nextToken()));
                    }

                } else { // 삭제
                    int idx = Integer.parseInt(st.nextToken()); // 삭제 시작 인덱스
                    int n = Integer.parseInt(st.nextToken()); // 숫자 개수

                    // 삭제 하기
                    for(int i=0; i<n; i++) {
                        list.remove(idx); // idx 위치가 삭제되면, idx+1의 위치가 idx로 오기때문에, idx만 계속 지우면 된다.
                    }
                }
            }
            // 앞에 10개 출력하기
            sb.append("#").append(t).append(" ");
            for(int i=0; i<10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}