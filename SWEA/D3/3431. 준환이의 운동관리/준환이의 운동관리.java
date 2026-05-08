import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 운동의 최소 요구치
            int U = Integer.parseInt(st.nextToken()); // 운동의 최대 요구치
            int X = Integer.parseInt(st.nextToken()); // 지금 한 운동량

            sb.append("#").append(t).append(" ");
            if(X < L) { // 운동이 더 필요
                sb.append(L-X);
            } else if(X > U) { // 운동 시간 초과
                sb.append("-1");
            } else { //운동 적당히 함, 더 할 필요 없음
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}