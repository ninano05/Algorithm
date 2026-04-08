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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            // 수 입력 받기
            for(int i=0; i<10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 정렬하기 (오름차순)
            Arrays.sort(arr);
            // 최대 최소 빼고 평균 계산
            double avg = 0;
            for(int i=1; i<9; i++) {
                avg += (double)arr[i];
            }
            avg = avg / 8.0;
            sb.append("#").append(t).append(" ").append(Math.round(avg)).append("\n");
        }

        System.out.print(sb);
        br.close();
	}
}