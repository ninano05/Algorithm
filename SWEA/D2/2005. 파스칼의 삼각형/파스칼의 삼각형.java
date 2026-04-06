import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] paskal = new int[N][N];

            for(int i=0; i<N; i++) {
                paskal[i][0] = 1; // 처음 1
                paskal[i][i] = 1; // 끝 1
                for(int j=1; j<i; j++) {
                    paskal[i][j] = paskal[i-1][j-1] + paskal[i-1][j];
                }
            }
            sb.append("#").append(t).append("\n");
            for(int i=0; i<N; i++) {
                for(int j=0; j<=i; j++) {
                    sb.append(paskal[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
	}
}