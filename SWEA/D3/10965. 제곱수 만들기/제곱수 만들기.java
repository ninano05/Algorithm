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
            int A = Integer.parseInt(br.readLine()); // 자연수

            // A 인수 분해 하기
            // 소인수, 지수
            HashMap<Integer, Integer> map = new HashMap<>();

            int num = A;
            // A 소인 수 분해
            for(int i=2; i*i<=A; i++) {
                while(num%i == 0) {
                    num = num/i;
                    map.put(i, map.getOrDefault(i, 0)+1);
                }
            }
            // 인수 분해 모두 하고 남은 건 소수임
            if(num > 1) map.put(num, map.getOrDefault(num, 0)+1);

            int B = 1; // 기본값
            for(int n: map.keySet()) {
                if(map.get(n)%2 != 0) { // 지수가 짝수가 아니라면
                    B *= n;
                }
            }

            sb.append("#").append(t).append(" ").append(B).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}