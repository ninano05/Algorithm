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
            int N = Integer.parseInt(br.readLine()); // 버스 노선 개수

            // 버스 정류장은 5000개
            int[] busStop = new int[5001]; // 0은 없는 취급

            // 각 버스 노선이 지나는 정류장에 +1하기
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 버스 정류장 시작 번호
                int b = Integer.parseInt(st.nextToken()); // 버스 정류장 종료 번호

                // 노선이 지나는 버스 정류장 표시하기
                for(int j=a; j<=b; j++) {
                    busStop[j]++;
                }
            }

            int P = Integer.parseInt(br.readLine()); // 버스 정류장
            // 출력하기
            sb.append("#").append(t).append(" ");
            for(int i=0; i<P; i++) {
                int c = Integer.parseInt(br.readLine());
                sb.append(busStop[c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}