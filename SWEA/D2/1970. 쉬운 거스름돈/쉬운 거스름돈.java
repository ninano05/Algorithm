import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] won = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] changes = new int[8]; // 50,000, 10,000 ... 10원 순서 (위와 동일)

            for(int i=0; i<won.length; i++) {
                changes[i] = N/won[i];
                N %= won[i];
            }
            sb.append("#").append(t).append("\n");
            for(int n : changes) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}