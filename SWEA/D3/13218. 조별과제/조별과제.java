import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine()); // 학생 수

            // 학생 수가 최대가 되려면 3인 1조가 기본임
            // 3인 1조하고 남은 학생은 만들어진 조 아무데나 넣으면 되어서 상관 쓸 필요 없음
            int team = N/3; // 몇 팀 나오는지
            sb.append("#").append(t).append(" ").append(team).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}