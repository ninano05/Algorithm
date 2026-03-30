import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int[][] snail;

        // 오른쪽, 아래, 왼쪽, 위 순서
        int[] dx = {0, 1, 0, -1}; //행
        int[] dy = {1, 0, -1, 0}; //열
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            snail = new int[n][n];
            int x = 0; // 현재 행 위치
            int y = 0; // 현재 열 위치
            int dir = 0; // 진행 방향

            for(int cur=1; cur <= n*n; cur++) {
                snail[x][y] = cur;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 방향 바꾸기
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || snail[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;
            }
            sb.append("#").append(i+1).append("\n");
            for(int sx=0; sx<n; sx++) {
                for(int sy=0; sy<n; sy++) {
                    sb.append(snail[sx][sy]).append(" ");
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}