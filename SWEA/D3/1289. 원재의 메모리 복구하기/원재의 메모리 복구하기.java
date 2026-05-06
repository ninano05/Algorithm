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
            String s = br.readLine();

            int res = 0;
            // 이전과 바뀌는 지점이 몇개인지 확인하면 됨
            if(s.charAt(0) == '1') res++; // 000...으로 초기화 되어 있기 때문
            for(int i=1; i<s.length(); i++) {
                if(s.charAt(i) != s.charAt(i-1)) res++; // 이전이랑 달라지면 +1
            }
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}