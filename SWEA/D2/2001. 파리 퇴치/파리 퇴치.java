import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] fly = new int[n][n]; // 파리 배열 초기화

            // 파리 배열 채우기
            for(int f=0; f<n; f++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int fn=0; fn<n; fn++) {
                    fly[f][fn] = Integer.parseInt(st.nextToken());
                }
            }

            int maxSum = 0; //최대 파리 값
            // 파리 잡기
            for(int row=0; row<=n-m; row++) {
                for(int col = 0; col<=n-m; col++) {
                    int sum = 0; // 현재 파리채 파리 합
                    for(int j=0; j<m; j++) {
                        for(int k=0; k<m; k++) {
                            sum += fly[row+j][col+k];
                        }
                    }
                    if(sum > maxSum) maxSum = sum;
                }
            }
            sb.append("#").append(i+1).append(" ").append(maxSum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}